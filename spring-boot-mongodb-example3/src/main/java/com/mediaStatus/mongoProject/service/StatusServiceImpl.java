package com.mediaStatus.mongoProject.service;

import com.mediaStatus.mongoProject.dao.StatusDao;
import com.mediaStatus.mongoProject.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusServiceImpl implements StatusService {

   @Autowired
   private StatusDao statusDao;


    @Override
    public void insert(Status status, String collectionName) {
        statusDao.insert(status, collectionName);
    }
}
