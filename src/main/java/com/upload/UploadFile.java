package com.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Kylin
 * @version v1.0
 * @project apilog-save
 * @date 2020/11/3
 */
public interface UploadFile {

    String upload(MultipartFile file, String extension);
}
