package com.iessanalberto.adl.Clases;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;


public class generarXML {

    private ListaProyectos listaProyectos=null;
    private Usuarios usuarios=null;



    private Centros centros=null;
    //El archivo donde se vuelca el contenido, creo que se podria pasar como parametro del constructor
    File archivo;
    public generarXML(){
        if(listaProyectos!=null)
            generarProyectos();
        if(usuarios!=null)
            generarUsuarios();
        if(centros!=null){
            generarCentros();
        }
    }
    public void setListaProyectos(ListaProyectos listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public void setCentros(Centros centros) {this.centros = centros;}

    //Este metodo genera los archivos XML
    public void generar() {
        if(listaProyectos!=null)
            generarProyectos();
        if(usuarios!=null)
            generarUsuarios();
        if (centros!=null)
            generarCentros();
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

    private void generarCentros() {
        try {
            archivo = new File("src/main/resources/centros.xml");
            JAXBContext context = JAXBContext.newInstance(Centros.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(centros, archivo);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
