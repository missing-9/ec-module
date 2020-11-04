package com.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Kylin
 * @version v1.0
 * @project apilog-save
 * @date 2020/11/3
 */
public class FastdfsUploadFile implements UploadFile {

    @Override
    public String upload(String storeCode, MultipartFile file, String extension) {
        return null;
    }
}
