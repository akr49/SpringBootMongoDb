package com.mediaStatus.mongoProject.service;

import com.mediaStatus.mongoProject.model.User;

import java.util.List;

public interface UserService {

    void insert(List<User> users, String collectionName);

    List<User> findAll();

    void remove();
}
