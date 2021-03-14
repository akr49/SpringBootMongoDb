package com.mediaStatus.mongoProject.dao;

import com.mediaStatus.mongoProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    @Qualifier("statusMongoTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(List<User> users, String collectionName) {
        mongoTemplate.insert(users, collectionName);
    }

    @Override
    public List<User> findAll() {
        Query query = new Query();
        return mongoTemplate.findAll(User.class, "users");
    }

    @Override
    public void remove(){
        Query query = new Query();
        mongoTemplate.remove(query,"users");
    }

}
