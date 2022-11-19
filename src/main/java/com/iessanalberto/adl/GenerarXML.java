package com.iessanalberto.adl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;

//Las modificaciones realizadas son, eliminar el metodo main de la clase y convertirla en una fabrica de objetos con metodos
//que realizan funciones

//Posibles mejoras el metodo deberia recibir la ruta donde se quiere generar el XML
public class GenerarXML {

    ListaProyectos listaProyectos;
    //El archivo donde se vuelca el contenido, creo que se podria pasar como parametro del constructor
    File archivo;
    public GenerarXML(ListaProyectos listaProyectos ){
        this.listaProyectos=listaProyectos;

    }
    //Este metodo genera el archivo XML
    public void generar() {


        try {

            archivo = new File("src/main/resources/proyectos.xml");
            JAXBContext context = JAXBContext.newInstance(ListaProyectos.class);

            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(listaProyectos, archivo);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
