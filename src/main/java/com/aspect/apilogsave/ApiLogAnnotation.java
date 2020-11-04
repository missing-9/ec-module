package com.aspect.apilogsave;

import java.lang.annotation.*;

/**
 * @author Kylin
 * @version v1.0
 * @project apilog-save
 * @date 2020/11/3
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLogAnnotation {
}
