package com.java.food.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    public String upload(MultipartFile file);
}
