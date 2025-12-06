package com.franklin.service;

import com.franklin.dto.upload.PresignUrlDTO;

import java.io.InputStream;

/**
 * @Auther: franklin
 * @Date: 2025/11/21
 * @Description: Aliyun OSS Service
 */
public interface AliyunOSSService {

    /**
     * Upload the object on Object file path using inputStream
     * @param Object
     * @param inputStream
     * @return
     */
    String upload(String Object, InputStream inputStream) throws com.aliyuncs.exceptions.ClientException;


    String generatePresignedUrl(PresignUrlDTO urlDTO) throws com.aliyuncs.exceptions.ClientException;
}
