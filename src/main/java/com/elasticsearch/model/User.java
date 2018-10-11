package com.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "user", type = "doc")
public class User {
    @Id
    private Integer id;

    private String person_cname;// 中文名

    private String person_ename;// 英文名

    private String person_sex;// 性别

    private String person_age;// 年龄

    private String person_birthday;// 出生日期

    private String initial_worktime;// 首次参加工作时间

    private String work_years;// 工作年限

    private String max_degree;// 最高学历

    private String native_place;// 籍贯

    private String present_addr;// 现居住地

    private String person_tel;// 联系方式

    private String person_email;// 电子邮箱

    private String marriage_status;// 婚姻状况（1.未婚 2.已婚 3.离异 4.保密 5.其他）

    private String person_nationality;// 国籍

    private String person_nation;// 民族

    private Integer oversea_experience;// 海外工作/学习经历(1.有 2.无 3未知)

    private String politics_status;// 政治面貌

    private String self_assessment;// 自我评价

    private String photo_addr;// 照片地址

    private String channel_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerson_cname() {
        return person_cname;
    }

    public void setPerson_cname(String person_cname) {
        this.person_cname = person_cname;
    }

    public String getPerson_ename() {
        return person_ename;
    }

    public void setPerson_ename(String person_ename) {
        this.person_ename = person_ename;
    }

    public String getPerson_sex() {
        return person_sex;
    }

    public void setPerson_sex(String person_sex) {
        this.person_sex = person_sex;
    }

    public String getPerson_age() {
        return person_age;
    }

    public void setPerson_age(String person_age) {
        this.person_age = person_age;
    }

    public String getPerson_birthday() {
        return person_birthday;
    }

    public void setPerson_birthday(String person_birthday) {
        this.person_birthday = person_birthday;
    }

    public String getInitial_worktime() {
        return initial_worktime;
    }

    public void setInitial_worktime(String initial_worktime) {
        this.initial_worktime = initial_worktime;
    }

    public String getWork_years() {
        return work_years;
    }

    public void setWork_years(String work_years) {
        this.work_years = work_years;
    }

    public String getMax_degree() {
        return max_degree;
    }

    public void setMax_degree(String max_degree) {
        this.max_degree = max_degree;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getPresent_addr() {
        return present_addr;
    }

    public void setPresent_addr(String present_addr) {
        this.present_addr = present_addr;
    }

    public String getPerson_tel() {
        return person_tel;
    }

    public void setPerson_tel(String person_tel) {
        this.person_tel = person_tel;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public String getMarriage_status() {
        return marriage_status;
    }

    public void setMarriage_status(String marriage_status) {
        this.marriage_status = marriage_status;
    }

    public String getPerson_nationality() {
        return person_nationality;
    }

    public void setPerson_nationality(String person_nationality) {
        this.person_nationality = person_nationality;
    }

    public String getPerson_nation() {
        return person_nation;
    }

    public void setPerson_nation(String person_nation) {
        this.person_nation = person_nation;
    }

    public Integer getOversea_experience() {
        return oversea_experience;
    }

    public void setOversea_experience(Integer oversea_experience) {
        this.oversea_experience = oversea_experience;
    }

    public String getPolitics_status() {
        return politics_status;
    }

    public void setPolitics_status(String politics_status) {
        this.politics_status = politics_status;
    }

    public String getSelf_assessment() {
        return self_assessment;
    }

    public void setSelf_assessment(String self_assessment) {
        this.self_assessment = self_assessment;
    }

    public String getPhoto_addr() {
        return photo_addr;
    }

    public void setPhoto_addr(String photo_addr) {
        this.photo_addr = photo_addr;
    }

    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
    }

}
