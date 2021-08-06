package com.iacg.app.files.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchivoDto implements Serializable {

    private String nombre;
    private String extension;
    private Date enviado;

}
