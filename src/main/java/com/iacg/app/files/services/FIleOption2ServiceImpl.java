package com.iacg.app.files.services;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class FIleOption2ServiceImpl implements IFileOption2Service {

    private final Path rootFoolder = Paths.get("files");

    @Override
    public void save(MultipartFile file) throws Exception {
        String fileName = UUID.randomUUID().toString() + " " + file.getOriginalFilename();
        Files.copy(file.getInputStream(),this.rootFoolder.resolve(fileName));
    }

    @Override
    public Resource load(String name) throws Exception {
        return null;
    }

    @Override
    public void save(List<MultipartFile> files) throws Exception {
        for(MultipartFile file : files){
            save(file);
        }
    }

    @Override
    public Stream<Path> loadAll() throws Exception {
        return null;
    }
}
