package com.java.food.service.impl;

import com.java.food.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements IFileService {
    @Override
    public String upload(MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();

            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
            System.out.println(path);

            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //重新生成文件名
            fileName = String.valueOf(System.currentTimeMillis()) + suffixName;

            try {
                file.transferTo(new File(path + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "http://localhost:8080/" + fileName;

        }
        return "-1";
    }
}
