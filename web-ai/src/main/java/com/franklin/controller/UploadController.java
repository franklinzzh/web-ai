package com.franklin.controller;

import com.aliyuncs.exceptions.ClientException;
import com.franklin.service.impl.AliyunOSSOperator;
import com.franklin.util.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: franklin
 * @Date: 2025/11/18
 * @Description:
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UploadController {

    // Save path (absolute path)
    private static final String uploadDir = "/Users/franklin/Desktop/Upload/";

    private final AliyunOSSOperator aliyunOSSOperator;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public Result upload(String username, Integer age, @RequestParam("file") MultipartFile image) throws IOException, ClientException {
        log.info("上传文件：{}, {}, {}", username, age, image);
        if (image == null || image.isEmpty()){
            return Result.error("File is empty.");
        }
        // Set the Unique File Name
        String originalFileName = image.getOriginalFilename();
        String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueFileName = "img-" + username + "-" + UUID.randomUUID().toString().replace("-", "") + extName;
        System.out.println(uploadDir + uniqueFileName);
        // Upload file
        String dirName = "emp/photo/";
        String objectName = dirName + uniqueFileName;
        String result = aliyunOSSOperator.upload(objectName, image.getInputStream());
        return Result.success(result);
    }
}
