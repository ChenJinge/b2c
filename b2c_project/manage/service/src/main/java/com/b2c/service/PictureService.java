package com.b2c.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by chenjinge on 2016/7/4.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);

}
