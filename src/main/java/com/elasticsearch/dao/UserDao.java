package com.elasticsearch.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.elasticsearch.model.User;

public interface UserDao {

    List<User> getAllUsers(String word, Pageable pageable);

    List<User> getUserById(String word, Pageable pageable);

    List<User> termUser(int userId);

    List<User> multiMatchUser(String word, Pageable pageable);

    List<User> boolUser(String sex, int userId, Pageable pageable);

}