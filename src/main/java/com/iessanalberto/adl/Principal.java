package com.iessanalberto.adl;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        //Variables para un proyecto

        Valoracion valoracion = new Valoracion( "Buen proyecto",8.3);
        ArrayList<String> participantes= new ArrayList<>(Arrays.asList("Alvaro, Javier, Miguel"));
        ArrayList<String> tags = new ArrayList<>(Arrays.asList("Java, IntelliJIdea, Archivos"));
        ArrayList<String> familiaImplicadas = new ArrayList<>(Arrays.asList("DAM, Programacion, Gestion de datos"));
        String titulo = "FP2 generación de archivos";
        String descripcion = "Este conjunto de clases permiten generar archivos xml y json";
        String coordinador = "Miguel";
        Boolean estado=true;
        Boolean visibilidad=true;

        //Creacion del proyecto
        Proyecto proyecto = new Proyecto( participantes, tags, familiaImplicadas, titulo, descripcion, coordinador, valoracion,  estado,  visibilidad);

        //Se crea el proyecto y se añade a la lista de proyectos
        ListaProyectos listaProyectos=new ListaProyectos();
        listaProyectos.proyectos.add(proyecto);

        //Utilizamos el metodo generarXML con la lista de proyectos para generar el XML
        GenerarXML estructuraDatosXml = new GenerarXML(listaProyectos);
        estructuraDatosXml.generar();
        GenerarJson generarJson=new GenerarJson(Path.of("src/main/resources/proyectos.xml"));
        generarJson.generar();

        //Otro constructor que permite generar un XML y JSON a la vez
        /*GenerarJson generarJson=new GenerarJson(new GenerarXML(listaProyectos));
        generarJson.generar();*/

        }
}
