package com.iacg.app.files.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface IFileOption2Service {
    void save (MultipartFile file) throws Exception;
    Resource load (String name) throws Exception;
    void save (List<MultipartFile> files) throws Exception;
    Stream<Path> loadAll () throws Exception;
}
