package com.iacg.app.files.controllers;

import com.iacg.app.files.services.IFileOption1Service;
import com.iacg.app.files.services.IFileOption2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/files/v1/files")
public class FilesController {

    @Autowired
    private IFileOption1Service fileOption1Service;

    @Autowired
    private IFileOption2Service fileOption2Service;

    @PostMapping("/option-1")
    public ResponseEntity<?> saveFileOption1(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seleccionar un archivo");
        }
        try{
            fileOption1Service.save(file);
        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage() + "ERROR: " + e.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/option-2")
    public ResponseEntity<?> saveFilesOption2(@RequestParam("files") List<MultipartFile> files, @RequestParam("archivosDto") String archivosDto){
        if(files.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seleccionar archivos");
        }
        try{
            fileOption2Service.save(files,archivosDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage() + "ERROR: " + e.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
