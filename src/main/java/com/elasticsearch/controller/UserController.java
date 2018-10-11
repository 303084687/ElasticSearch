package com.elasticsearch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.dao.UserDao;
import com.elasticsearch.model.User;

@RestController
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    //单字符串模糊查询，默认排序。将从所有字段中查找包含传来的word分词后字符串的数据集 http://localhost:8080/allMatch?word=电影&size=20
    @RequestMapping("/allMatch")
    public List<User> getAllUsers(String word, @PageableDefault Pageable pageable) {
        return userDao.getAllUsers(word, pageable);
    }

    //单字段对某字符串模糊查询,分词匹配 http://localhost:8080/singleMatch?word=电影&size=20
    @RequestMapping("/singleMatch")
    public List<User> getUser(String word, @PageableDefault Pageable pageable) {
        LOG.info("Getting user with word: {}", word);
        return userDao.getUserById(word, pageable);
    }

    //单字段对某字符串term匹配，即不分词匹配 http://localhost:8080/termMatch?userId=25
    @RequestMapping("/termMatch")
    public List<User> getUserTerm(int userId) {
        LOG.info("Getting user with userId: {}", userId);
        return userDao.termUser(userId);
    }

    //根据姓名和个人评价多个字段匹配某字符串并按照年龄降序排列 http://localhost:8080/multiMatch?word=策划&size=20
    @RequestMapping("/multiMatch")
    public Object singleUserId(String word, @PageableDefault(sort = "id", direction = Direction.DESC) Pageable pageable) {
        return userDao.multiMatchUser(word, pageable);
    }

    //多个字段合并查询(性别必须相等，用户主键小于的用户) http://localhost:8080/boolMatch?sex=女&userId=100&size=20
    @RequestMapping("/boolMatch")
    public Object bool(String sex, int userId, @PageableDefault Pageable pageable) {
        return userDao.boolUser(sex, userId, pageable);
    }
}