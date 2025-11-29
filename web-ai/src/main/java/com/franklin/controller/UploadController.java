package com.franklin.controller;

import com.aliyuncs.exceptions.ClientException;
import com.franklin.dto.upload.PresignUrlDTO;
import com.franklin.service.AliyunOSSService;
import com.franklin.util.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: franklin
 * @Date: 2025/11/18
 * @Description: File upload controller
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/upload")
public class UploadController {

    private final AliyunOSSService aliyunOSSService;

    /**
     * Upload File to AliyunOSS
     *
     * @param username
     * @param avatar
     * @return
     * @throws IOException
     * @throws ClientException
     */
    @PostMapping("/avatar")
    public Result upload(String username, @RequestParam("file") MultipartFile avatar) throws IOException, ClientException {
        log.info("上传文件：{}, {}", username, avatar);
        if (avatar == null || avatar.isEmpty()){
            return Result.error("File is empty.");
        }
        // Set the Unique File Name
        String originalFileName = avatar.getOriginalFilename();
        String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueFileName = "img-" + UUID.randomUUID().toString().replace("-", "") + extName;
        System.out.println(uniqueFileName);
        // Upload file
        String dirName = "emp/photo/";
        String objectName = dirName + uniqueFileName;
        String OSSPath =aliyunOSSService.upload(objectName, avatar.getInputStream());
        System.out.println(OSSPath);
        // return OSS file path
        return Result.success(OSSPath);
    }

    @PostMapping("/presign")
    public Result fetchPresignedUrl(@RequestBody PresignUrlDTO urlDTO) throws ClientException{
        log.info("Fetch Presigned Url: {}", urlDTO);
        String presignedUrl =aliyunOSSService.generatePresignedUrl(urlDTO);
        return Result.success(presignedUrl);
    }

}
