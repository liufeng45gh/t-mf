package com.lucifer.service;

import com.baidu.ueditor.define.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.UUID;

@Component
public class FileStoreService {

    @Value("${cdn.fileStoreUrl}")
    private String fileStoreUrl;

    @Value("${cdn.domainStr}")
    private String domainStr;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String saveFile(MultipartFile multipartFile) throws Exception {

        String originFileName = multipartFile.getOriginalFilename();
        String suffix = FileType.getSuffixByFilename(originFileName);
        byte[] bytes = multipartFile.getBytes();
        String key = UUID.randomUUID().toString()+suffix;
        File file = new File(fileStoreUrl+ "/" + key);

        if (!file.exists()) {
            FileOutputStream fos = new FileOutputStream(file);
            try {
                fos.write(bytes);
                fos.close();
                logger.info("new file: %s", file.getAbsolutePath());
            } finally {
                fos.close();
            }
        } else {
            logger.info("exist file: %s", file.getAbsolutePath());
        }

        return domainStr + "/" + key;

    }
}
