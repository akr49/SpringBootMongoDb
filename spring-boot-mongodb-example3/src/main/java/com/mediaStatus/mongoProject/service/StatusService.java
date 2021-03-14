package com.mediaStatus.mongoProject.service;

import com.mediaStatus.mongoProject.model.Status;

public interface StatusService {

    void insert(Status status, String collectionName);

}
