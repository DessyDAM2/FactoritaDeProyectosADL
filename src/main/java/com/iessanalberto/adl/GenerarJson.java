package com.iessanalberto.adl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//Las modificaciones realizadas son, eliminar el metodo main de la clase y convertirla en una fabrica de objetos con metodos
//que realizan funciones y añadir unos ifs que realizan el control en la existencia de los directorios a los que se desea
//acceder
 public class GenerarJson {

     Path path;
     //Constructor
     public GenerarJson(Path path){
         this.path=path;
     }

     //Este metodo permite generar un archivo a partir del metodo de generacion de un XML y a la vez se genera el XML
    public GenerarJson(GenerarXML generarXML){
         generarXML.generar();
         if(generarXML.archivo.exists())
             this.path=generarXML.archivo.toPath();
    }


    public void generar() {
        try {
            ListaProyectos lista;
            JAXBContext context = JAXBContext.newInstance(ListaProyectos.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            //Codigo añadido, se usa un fichero xml para crear el archivo y a la vez se controla que exista el archivo xml
            File archivoXml=new File(path.toUri());
            if(Files.exists(archivoXml.toPath())){
                lista = (ListaProyectos) unmarshaller.unmarshal(archivoXml);

                Path archivo = Path.of("target/proyectos.json");
                // Codigo añadido, con este otro if se controla que la ruta destino exista
                if (Files.exists(archivo.getParent())){
                    Gson gson;
                    GsonBuilder builder = new GsonBuilder();
                    gson = builder.setPrettyPrinting().create();
                    String texto = gson.toJson(lista);
                    Files.write(archivo, texto.getBytes());
                }
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

    }
}
