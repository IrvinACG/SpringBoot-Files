package com.iacg.app.files.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileOption1Service {
    void save (MultipartFile file) throws IOException;
}
