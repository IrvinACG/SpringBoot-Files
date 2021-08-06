# SpringBoot-Files

Esta API enviar archivos y datos JSON para guardarlos en local

##API /files/v1/files

###Endpoint POST /option-1
Permite guardar un archivo
####Argumentos
Tipo: Request Param
- file : MultipartFile

###Endpoint POST /option-2
Permite guardar una lista archivos junto con un JSON (arreglo) metadatos de los archivos. Una vez que se envia el JSON de metados, se deserializa a la clase ArchivoDto, creando una lista del mismo tamanio de los archivos enviados.
###Estructura del JSON
[
  {
    "nombre" : "mi archivo 1",
    "extension" : "pdf",
    "enviado" : "2021-08-01T17:47:02Z"
  }
]
####Argumentos
Tipo: Request Param
- files : List<MultipartFile>
Tipo: Request Param
- archivosDto : String
