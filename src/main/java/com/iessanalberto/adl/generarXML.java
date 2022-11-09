package com.iessanalberto.adl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;


public class generarXML {
    public static void main(String[] args) {
        listaProyectos objetoProyecto = new listaProyectos();
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        ArrayList<String> usuarios = new ArrayList<>(), tags = new ArrayList<>(), familiasImplicadas = new ArrayList<>();
        String titulo = "1", descrip = "Prueba del proyecto", coordinador = "Jorge";
        Valoracion valoracion = new Valoracion("es una mierda", 4.21);
        Boolean estado = true, visibilidad = true;
        usuarios.add("Alvaro");
        tags.add("Informatica");
        familiasImplicadas.add("Informatica");

        try {

            File archivo = new File("src/main/resources/proyectos.xml");
            JAXBContext context = JAXBContext.newInstance(listaProyectos.class);

            Marshaller marshaller = context.createMarshaller();
            Proyecto proyecto = new Proyecto(usuarios, tags, familiasImplicadas, titulo, descrip, coordinador, valoracion, estado, visibilidad);
            proyectos.add(proyecto);
            objetoProyecto.setProyectos(proyectos);

            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(objetoProyecto, archivo);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
