package com.iacg.app.files.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iacg.app.files.models.ArchivoDto;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class FIleOption2ServiceImpl implements IFileOption2Service {

    private final Path rootFoolder = Paths.get("files");

    @Override
    public void save(MultipartFile file, ArchivoDto archivoDto) throws Exception {
        String fileName = UUID.randomUUID().toString() + " " + file.getOriginalFilename();
        Files.copy(file.getInputStream(),this.rootFoolder.resolve(fileName));
        System.out.println(archivoDto.toString());
    }

    @Override
    public Resource load(String name) throws Exception {
        return null;
    }

    @Override
    public void save(List<MultipartFile> files, String archivosDto) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        //Convertir String del JSON a clase ->Argumentos: String JSON , Clase a mapear
        List<ArchivoDto> archivoDto= Arrays.asList(mapper.readValue(archivosDto,ArchivoDto[].class));
        for (int i = 0; i < files.size(); i++){
            save(files.get(i),archivoDto.get(i));
        }
    }

    @Override
    public Stream<Path> loadAll() throws Exception {
        return null;
    }
}
