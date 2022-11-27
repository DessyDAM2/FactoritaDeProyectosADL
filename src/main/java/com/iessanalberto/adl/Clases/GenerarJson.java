package com.iessanalberto.adl.Clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iessanalberto.adl.Clases.GenerarXML;
import com.iessanalberto.adl.Clases.ListaProyectos;
import com.iessanalberto.adl.Clases.Usuario;
import com.iessanalberto.adl.Clases.Usuarios;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

//Las modificaciones realizadas son, eliminar el metodo main de la clase y convertirla en una fabrica de objetos con metodos
//que realizan funciones y añadir unos ifs que realizan el control en la existencia de los directorios a los que se desea
//acceder
 public class GenerarJson {

     //Constructor
     public GenerarJson(){
     }

     //Este metodo permite generar un archivo a partir del metodo de generacion de un XML y a la vez se genera el XML
    public GenerarJson(GenerarXML generarXML){
         generarXML.generar();
    }

    //Metodo para generar Jsons
    public void generar() {
        generarProyecto();
        generarUsuario();

    }
    //Metodo para generar Json de proyectos
    public void generarProyecto() {
        try {
            ListaProyectos lista;
            JAXBContext context = JAXBContext.newInstance(ListaProyectos.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            //Codigo añadido, se usa un fichero xml para crear el archivo y a la vez se controla que exista el archivo xml
            File archivoXml=new File("src/main/resources/proyectos.xml");
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

    //Metodo para generar Jsons de usuarios
    public static void generarUsuario(){
       
        File archivo = new File("src/main/resources/usuarios.xml");
        File archivoJson= new File("target/Usuarios.json");
        JAXBContext contexto;
        try {
            //para leer el documento
            contexto = JAXBContext.newInstance(Usuarios.class);
            //unmarshaller para pasar de xml a java
            Unmarshaller objetoUnmarshaller = contexto.createUnmarshaller();

            Usuarios usuarios;
            List<String> textoAlumno =new ArrayList<>();
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            if(archivo.exists()) {
                usuarios = (Usuarios) objetoUnmarshaller.unmarshal(archivo);
                //Marshaller objetoMarshaller=contexto.createMarshaller();
                Files.write(archivoJson.toPath(), gson.toJson(usuarios).getBytes());


            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
