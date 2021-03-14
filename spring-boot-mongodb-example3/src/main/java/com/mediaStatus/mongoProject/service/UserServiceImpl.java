package com.mediaStatus.mongoProject.service;

import com.mediaStatus.mongoProject.dao.UserDao;
import com.mediaStatus.mongoProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insert(List<User> users, String collectionName) {
        userDao.insert(users, collectionName);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void remove() {
        userDao.remove();
    }
}
