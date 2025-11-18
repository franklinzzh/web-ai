package com.franklin.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: franklin
 * @Date: 2025/11/18
 * @Description:
 */
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {
    private final String endpoint;
    private final String bucketName;
    private final String region;

    public AliyunOSSProperties(String endpoint, String bucketName, String region) {
        this.endpoint = endpoint;
        this.bucketName = bucketName;
        this.region = region;
    }

    public String getEndpoint() { return endpoint; }

    public String getBucketName() { return bucketName; }

    public String getRegion() { return region; }
}
