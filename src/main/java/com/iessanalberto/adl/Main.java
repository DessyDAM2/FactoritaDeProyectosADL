package com.iessanalberto.adl;

import com.iessanalberto.adl.Clases.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
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
        //Datos para un usuario
        Alumnos alumno= new Alumnos
                ( "rol1","nombre1", "contraseña","familiaProfesional", "email", new String[]{"gusto1", "gusto12"});
        alumno.setCentro("centro");
        List<Usuario> listaUsuarios=new ArrayList<>();
        listaUsuarios.add(alumno);
        Usuarios usuarios=new Usuarios();
        usuarios.setListaUsuarios(listaUsuarios);



        //Creacion del proyecto
        Proyecto proyecto = new Proyecto( participantes, tags, familiaImplicadas, titulo, descripcion, coordinador, valoracion,  estado,  visibilidad);

        //Se crea el proyecto y se añade a la lista de proyectos
        ListaProyectos listaProyectos=new ListaProyectos();
        listaProyectos.addProyectos(proyecto);

        Profesor profesor= new Profesor
                ( "rol1","nombre1", "contraseña","familiaProfesional", "email", new String[]{"gusto1", "gusto12"});
        alumno.setCentro("centro");

        Centros centro = new Centros("IES San Alberto", "a", "Informatica", 1, listaProyectos, profesor,
                 alumno);
        //Utilizamos el metodo generarXML con la lista de proyectos para generar el XML
        generarXML estructuraDatosXml = new generarXML();
        estructuraDatosXml.setListaProyectos(listaProyectos);
        estructuraDatosXml.setUsuarios(usuarios);
        estructuraDatosXml.setCentros(centro);
        estructuraDatosXml.generar();
        generarJson generarJson=new generarJson();
        generarJson.generar();

        //Otro constructor que permite generar un XML y JSON a la vez
        /*GenerarJson generarJson=new GenerarJson(estructuraDatosXml);
        generarJson.generar();*/

    }
}
