package com.aspect.apilogsave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Kylin
 * @version v1.0
 * @project apilog-save
 * @date 2020/11/3
 */
@Service
public class ApiLogService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveApiLog(String methodName, String params, String result) {
        ApiLog apiLog = new ApiLog();
        apiLog.setMethodName(methodName);
        apiLog.setParams(params);
        apiLog.setResult(result);
        apiLog.setCreateTime(LocalDateTime.now());
        mongoTemplate.save(apiLog);
    }
}
