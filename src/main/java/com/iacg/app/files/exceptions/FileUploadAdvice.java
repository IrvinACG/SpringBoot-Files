package com.iacg.app.files.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class FileUploadAdvice {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<?> handleMaxSizeException (MaxUploadSizeExceededException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Verifica el tamanio de los archivos");
    }

}
