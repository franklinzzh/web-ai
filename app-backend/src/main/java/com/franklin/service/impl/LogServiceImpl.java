package com.franklin.service.impl;

import com.franklin.entity.OperateLog;
import com.franklin.mapper.OperateLogMapper;
import com.franklin.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Auther: franklin
 * @Date: 2025/11/27
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
    private final OperateLogMapper logMapper;

    @Async
    @Override
    public void writeLogAsync(OperateLog log) {
        logMapper.insert(log);
    }
}
