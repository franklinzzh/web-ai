package com.franklin.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.franklin.entity.File;
import com.franklin.exception.BusinessException;
import com.franklin.mapper.FileMapper;
import com.franklin.service.AliyunOSSService;
import com.franklin.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Auther: franklin
 * @Date: 2025/11/30
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final AliyunOSSService aliyunOSSService;
    private final FileMapper fileMapper;


    @Override
    public String upload(MultipartFile file) throws IOException, ClientException {
        if (file == null || file.isEmpty()){
            throw new BusinessException("File is empty.");
        }
        // Set the Unique File Name
        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null || originalFileName.trim().equals("")) {
            throw new BusinessException("File name can't be null");
        }
        String uniqueFileName = setUniqueName("", originalFileName);
        System.out.println(uniqueFileName);
        // Upload file
        String dirName = "util/";
        String objectName = dirName + uniqueFileName;
        String OSSPath =aliyunOSSService.upload(objectName, file.getInputStream());

        File fileEntity = new File();
        fileEntity.setName(originalFileName);
        fileEntity.setPath(OSSPath);
        fileMapper.create(fileEntity);
        return OSSPath;
    }

    @Override
    public String uploadAvatar(String username, MultipartFile avatar) throws ClientException, IOException {
        if (avatar == null || avatar.isEmpty()){
            throw new BusinessException("File is empty.");
        }
        // Set the Unique File Name
        String originalFileName = avatar.getOriginalFilename();
        if (originalFileName == null || originalFileName.trim().equals("")) {
            throw new BusinessException("File name can't be null");
        }
        String uniqueFileName = setUniqueName(username, originalFileName);
        System.out.println(uniqueFileName);
        // Upload file
        String dirName = "emp/avatar/";
        String objectName = dirName + uniqueFileName;
        String OSSPath =aliyunOSSService.upload(objectName, avatar.getInputStream());

        File fileEntity = new File();
        fileEntity.setName(originalFileName);
        fileEntity.setPath(OSSPath);
        fileMapper.create(fileEntity);
        return OSSPath;
    }


    private String setUniqueName (String username, String originalFileName) {
        int lastDotIndex = originalFileName.lastIndexOf(".");
        String fileName = originalFileName.substring(0, lastDotIndex);
        String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String uniqueFileName = "img-" + username + "-" + timestamp + extName;
        return uniqueFileName;
    }
}
