package com.upload;

import com.alibaba.fastjson.JSON;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Kylin
 * @version v1.0
 * @project apilog-save
 * @date 2020/11/3
 */
public class FastdfsUploadFile implements UploadFile {

    private Logger logger = LoggerFactory.getLogger(FastdfsUploadFile.class);

    private final FastFileStorageClient fastFileStorageClient;

    public FastdfsUploadFile(FastFileStorageClient fastFileStorageClient) {
        this.fastFileStorageClient = fastFileStorageClient;
    }

    @Override
    public String upload(MultipartFile file, String extension) {
        try {
            FastFile fastFile = new FastFile.Builder().withFile(file.getInputStream(), file.getSize(), extension).build();
            StorePath storePath = fastFileStorageClient.uploadFile(fastFile);
            logger.info("上传文件：{}，{}", file.getOriginalFilename(), JSON.toJSONString(storePath));
            return storePath.getFullPath();
        } catch (IOException e) {
            logger.error("上传文件失败 ! ", e);
            return null;
        }
    }
}
