package com.mediaStatus.mongoProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Status {

    @Id
    private Integer Id;
    private String name;
    private String description;
    private byte[] fileData;

    public Status(Integer id, String name, String description, byte[] fileData) {
        Id = id;
        this.name = name;
        this.description = description;
        this.fileData = fileData;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
