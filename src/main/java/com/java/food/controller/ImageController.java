package com.java.food.controller;


import com.java.food.annotation.UserLoginToken;
import com.java.food.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    @Autowired
    private IFileService fileService;

    @UserLoginToken
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        return fileService.upload(file);
    }
}
