package com.iessanalberto.adl.Clases;

import com.iessanalberto.adl.Clases.ListaProyectos;
import com.iessanalberto.adl.Clases.Usuarios;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

//Las modificaciones realizadas son, eliminar el metodo main de la clase y convertirla en una fabrica de objetos con metodos
//que realizan funciones

//Posibles mejoras el metodo deberia recibir la ruta donde se quiere generar el XML
public class GenerarXML {


    private ListaProyectos listaProyectos=null;
    private Usuarios usuarios=null;
    //El archivo donde se vuelca el contenido, creo que se podria pasar como parametro del constructor
    File archivo;
    public GenerarXML(){
        if(listaProyectos!=null)
        generarProyectos();
        if(usuarios!=null)
        generarUsuarios();
    }
    public void setListaProyectos(ListaProyectos listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    //Este metodo genera los archivos XML
    public void generar() {
        if(listaProyectos!=null)
        generarProyectos();
        if(usuarios!=null)
        generarUsuarios();

    }
    //Este metodo genera el Xml de Proyectos
    private void generarProyectos(){
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

    //Este metodo genera el Xml de usuarios
    private void generarUsuarios() {


        try {

            archivo = new File("src/main/resources/usuarios.xml");
            JAXBContext context = JAXBContext.newInstance(Usuarios.class);

            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(usuarios, archivo);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
