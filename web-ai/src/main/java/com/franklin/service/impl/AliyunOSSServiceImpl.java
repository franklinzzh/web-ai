package com.franklin.service.impl;

import com.aliyun.oss.*;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.franklin.dto.upload.PresignUrlDTO;
import com.franklin.exception.BusinessException;
import com.franklin.service.AliyunOSSService;
import com.franklin.util.AliyunOSSProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class AliyunOSSServiceImpl implements AliyunOSSService {

    private final AliyunOSSProperties aliyunOSSProperties;
    private final OSS ossClient;

    public String upload(String objectName, InputStream inputStream) throws com.aliyuncs.exceptions.ClientException {
        // get basic info from properties
        String endpoint = aliyunOSSProperties.getEndpoint();
        String region = aliyunOSSProperties.getRegion();
        String bucketName = aliyunOSSProperties.getBucketName();
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
            throw new BusinessException("Upload to OSS failed");
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
            throw new BusinessException("Upload to OSS failed");
        }
        return objectName;
//        return endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + objectName;
    }

    public String generatePresignedUrl(PresignUrlDTO urlDTO) throws com.aliyuncs.exceptions.ClientException {
        String path = urlDTO.getPath();
        Integer minutes = urlDTO.getExpire();
        String bucketName = aliyunOSSProperties.getBucketName();
        try {
            // 过期时间
            Date expiration = new Date(System.currentTimeMillis() + minutes * 60 * 1000);

            // 构造预签名 URL 请求y
            GeneratePresignedUrlRequest request =
                    new GeneratePresignedUrlRequest(bucketName, path, HttpMethod.GET);

            request.setExpiration(expiration);

            // 生成完整的临时访问 URL
            URL signedUrl = ossClient.generatePresignedUrl(request);
            return signedUrl.toString();
        } catch (OSSException | ClientException e) {
            log.error("OSS upload failed: {}", e.getMessage(), e);
            throw new BusinessException("Fetch Presigned Url failed");
        }
    }
}