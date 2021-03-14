package com.mediaStatus.mongoProject.controller;

import com.mediaStatus.mongoProject.model.Status;
import com.mediaStatus.mongoProject.model.User;
import com.mediaStatus.mongoProject.service.StatusService;
import com.mediaStatus.mongoProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/users")
public class UserController {

    @Autowired
    private StatusService statusService;

    @Autowired
    private UserService userService;

//    @PreDestroy
//    public void clean(){
//        Query query = new Query();
//        userService.remove(query,"users");
//    }

    @PostConstruct
    public void initialize() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Peter", "Development", 3000L));
        users.add(new User(2, "Sam", "Operations", 2000L));
        userService.insert(users, "users");
        System.out.println("users successfully created");
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/create/status")
    public ResponseEntity<Object> createStatus(@RequestParam Integer userId,
                                               @RequestParam(required = false) String description,
                                               @RequestParam MultipartFile inputFile) {
        String filename = inputFile.getName();
        byte[] fileData = null;
        try {
            fileData = inputFile.getBytes();
        } catch (IOException e) {
            System.out.println("error occurred while converting file to byte array");
        }
        Status status = new Status(1, "xyz", "this is a status", fileData);
        statusService.insert(status, "status");
        //creating response format
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Status successfully created");
        response.put("data", null);
        return ResponseEntity.ok(response);
    }
}
