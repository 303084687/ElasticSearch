package com.elasticsearch.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import com.elasticsearch.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    //索引名称
    @Value("${elasticsearch.index.name}")
    private String indexName;

    @Value("${elasticsearch.user.type}")
    private String userTypeName;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    //获取所有用户信息带分页
    @Override
    public List<User> getAllUsers(String word, Pageable pageable) {
        SearchQuery getAllQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.queryStringQuery(word)).withPageable(pageable)
                .build();
        return esTemplate.queryForList(getAllQuery, User.class);
    }

    //根据字段模糊匹配
    @Override
    public List<User> getUserById(String word, Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withFilter(QueryBuilders.matchQuery("self_assessment", word))
                .withPageable(pageable).build();
        return esTemplate.queryForList(searchQuery, User.class);
    }

    //根据用户主键全文匹配
    @Override
    public List<User> termUser(int userId) {
        //不对传来的值分词，去找完全匹配的        
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery("id", userId)).build();
        return esTemplate.queryForList(searchQuery, User.class);
    }

    //multi_match多个字段匹配某字符串(用户姓名+自我评价),要是设置完全包含查询设置一下Operator,无论是matchQuery，
    //multiMatchQuery，queryStringQuery等，都可以设置operator。默认为Or，设置为And后，就会把符合包含所有输入的才查出来,也可以通过精度来设置
    @Override
    public List<User> multiMatchUser(String word, Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
                QueryBuilders.multiMatchQuery(word, "person_cname", "self_assessment").operator(Operator.AND).minimumShouldMatch("75%"))
                .withPageable(pageable).build();
        return esTemplate.queryForList(searchQuery, User.class);
    }

    //bool合并查询,性别必须是女而且用户主键小于100,withFilter不会计算分值查询的结果可以被缓存
    @Override
    public List<User> boolUser(String sex, int userId, Pageable pageable) {
        //拼接查询条件
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if (StringUtils.isNotBlank(sex)) {
            queryBuilder.must(QueryBuilders.termQuery("person_sex", sex));
        }
        if (userId > 0) {
            queryBuilder.should(QueryBuilders.rangeQuery("id").lt(500));
        }
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withFilter(queryBuilder).withPageable(pageable).build();
        return esTemplate.queryForList(searchQuery, User.class);
    }

}
