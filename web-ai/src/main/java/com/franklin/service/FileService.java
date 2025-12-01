package com.franklin.service;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Auther: franklin
 * @Date: 2025/11/30
 * @Description:
 */

public interface FileService {

    String upload(MultipartFile file) throws IOException, ClientException;

    String uploadAvatar(String username, MultipartFile avatar) throws ClientException, IOException;
}
