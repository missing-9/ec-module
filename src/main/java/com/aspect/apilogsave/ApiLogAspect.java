package com.aspect.apilogsave;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kylin
 * @version v1.0
 * @project apilog-save
 * @date 2020/11/3
 */
@Aspect
@Component
public class ApiLogAspect {

    @Autowired
    private ApiLogService apiLogService;

    @Around("@annotation(com.aspect.apilogsave.ApiLogAnnotation)")
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        List<Object> params = new ArrayList<>();
        for (Object arg : args) {
            params.add(arg);
        }
        Object result = joinPoint.proceed();

        String methodName = joinPoint.getSignature().getName();
        String path = joinPoint.getTarget().getClass().getName();
        apiLogService.saveApiLog(methodName, path, result.toString());
        return result;
    }
}
