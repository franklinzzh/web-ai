package com.franklin.controller;

import com.aliyuncs.exceptions.ClientException;
import com.franklin.dto.upload.PresignUrlDTO;
import com.franklin.service.AliyunOSSService;
import com.franklin.service.FileService;
import com.franklin.utils.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Auther: franklin
 * @Date: 2025/11/18
 * @Description: File upload controller
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class FileController {

    private final AliyunOSSService aliyunOSSService;
    private final FileService fileService;

    /**
     * Upload File to AliyunOSS -- path: util/
     *
     * @param file
     * @return
     * @throws IOException
     * @throws ClientException
     */
    @PostMapping("/upload/file")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException, ClientException {
        log.info("上传文件：{}", file);
        String OSSPath = fileService.upload(file);
        System.out.println(OSSPath);
        // return OSS file path
        return Result.success(OSSPath);
    }

    /**
     * Upload Avatar to AliyunOSS -- path: emp/photo/
     *
     * @param username
     * @param avatar
     * @return
     * @throws IOException
     * @throws ClientException
     */

    @PostMapping("/upload/avatar")
    public Result uploadAvatar(@RequestParam String username, @RequestParam("file") MultipartFile avatar) throws ClientException, IOException {
        log.info("上传文件：{}, {}", username, avatar);
        String OSSPath = fileService.uploadAvatar(username, avatar);
        // return OSS file path
        log.info("Finished：{}", avatar);
        return Result.success(OSSPath);
    }

    @PostMapping("/presign")
    public Result fetchPresignedUrl(@RequestBody PresignUrlDTO urlDTO) throws ClientException{
        log.info("Fetch Presigned Url: {}", urlDTO);
        String presignedUrl =aliyunOSSService.generatePresignedUrl(urlDTO);
        return Result.success(presignedUrl);
    }

}
