package com.franklin.controller;

import com.franklin.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @Auther: franklin
 * @Date: 2025/11/18
 * @Description:
 */
@Slf4j
@RestController
public class UploadController {

    // Save path (absolute path)
    private static final String uploadDir = "/Users/franklin/Desktop/Upload/";

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public Result upload(String username, Integer age, @RequestParam("file") MultipartFile image) throws IOException {
        log.info("上传文件：{}, {}, {}", username, age, image);
        if (image == null || image.isEmpty()){
            throw new IllegalArgumentException("File is empty.");
        }
        // Set the Unique File Name
        String originalFileName = image.getOriginalFilename();
        String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueFileName = "img-" + LocalDate.now().toString() + '-' + UUID.randomUUID().toString().replace("-", "") + extName;
        File uploadFile = new File(uploadDir + uniqueFileName);
        // check the parent file in path is empty
        if (!uploadFile.getParentFile().exists()) {
            uploadFile.getParentFile().mkdirs();
        }
        System.out.println(uploadDir + uniqueFileName);
        // Save File
        image.transferTo(uploadFile);
        return Result.success();
    }
}
