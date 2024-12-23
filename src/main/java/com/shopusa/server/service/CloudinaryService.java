package com.shopusa.server.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CloudinaryService {
    List<String> uploadImages(List<MultipartFile> files) throws IOException;
}
