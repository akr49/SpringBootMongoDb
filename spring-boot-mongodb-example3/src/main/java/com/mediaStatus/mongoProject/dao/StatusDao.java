package com.mediaStatus.mongoProject.dao;

import com.mediaStatus.mongoProject.model.Status;

public interface StatusDao {

    void insert(Status status, String collectionName);
}
