package com.franklin.service;

import com.franklin.entity.OperateLog;

/**
 * @Auther: franklin
 * @Date: 2025/11/27
 * @Description:
 */
public interface LogService {

    /**
     * write log async
     * @param log
     */
    void writeLogAsync(OperateLog log);
}
