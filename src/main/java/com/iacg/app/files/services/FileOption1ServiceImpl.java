package com.iacg.app.files.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileOption1ServiceImpl implements IFileOption1Service {

    private final Path rootFoolder = Paths.get("files");

    @Override
    public void save(MultipartFile file) throws IOException {
            byte bytes[] = file.getBytes();
            String fileName = UUID.randomUUID().toString() + " " + file.getOriginalFilename();
            Files.write(this.rootFoolder.resolve(fileName),bytes);
    }
}
