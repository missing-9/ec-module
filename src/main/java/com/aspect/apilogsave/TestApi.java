package com.aspect.apilogsave;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kylin
 * @version v1.0
 * @project apilog-save
 * @date 2020/11/3
 */
@RestController
public class TestApi {

    @ApiLogAnnotation
    @GetMapping("/apilog")
    public void getRecord(){
        System.out.println("get record.");
        return;
    }
}
