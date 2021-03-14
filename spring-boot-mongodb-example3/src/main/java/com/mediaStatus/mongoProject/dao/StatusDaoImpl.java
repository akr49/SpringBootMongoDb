package com.mediaStatus.mongoProject.dao;

import com.mediaStatus.mongoProject.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class StatusDaoImpl implements StatusDao{

    @Autowired
    @Qualifier("statusMongoTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Status status, String collectionName) {
        this.mongoTemplate.insert(status, collectionName);
    }
}
