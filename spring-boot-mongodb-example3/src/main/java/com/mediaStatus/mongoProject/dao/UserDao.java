package com.mediaStatus.mongoProject.dao;

import com.mediaStatus.mongoProject.model.User;

import java.util.List;

public interface UserDao {
    void insert(List<User> users, String collectionName);

    List<User> findAll();

    void remove();
}
