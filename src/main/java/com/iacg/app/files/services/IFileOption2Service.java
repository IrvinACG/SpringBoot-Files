package com.iacg.app.files.services;

import com.iacg.app.files.models.ArchivoDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface IFileOption2Service {
    void save (MultipartFile file, ArchivoDto archivoDto) throws Exception;
    Resource load (String name) throws Exception;
    void save (List<MultipartFile> files, String archivosDto) throws Exception;
    Stream<Path> loadAll () throws Exception;
}
