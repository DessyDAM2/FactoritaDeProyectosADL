package com.iessanalberto.adl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;


public class generarXML {

    ArrayList<Proyecto> proyectos = new ArrayList<>();
    ArrayList<String> usuarios= new ArrayList<>(), tags= new ArrayList<>() , familiasImplicadas= new ArrayList<>();
    String titulo , descrip , coordinador;
    Valoracion valoracion;
    Boolean estado, visibilidad;

    public generarXML(){

    }

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public ArrayList<String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<String> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getFamiliasImplicadas() {
        return familiasImplicadas;
    }

    public void setFamiliasImplicadas(ArrayList<String> familiasImplicadas) {
        this.familiasImplicadas = familiasImplicadas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(Boolean visibilidad) {
        this.visibilidad = visibilidad;
    }

    public generarXML(ArrayList<String> usuarios, ArrayList<String>tags, ArrayList<String> familiasImplicadas, Proyecto proyecto,
                      String titulo, String descrip, String coordinador, Valoracion valoracion, boolean estado, boolean visibilidad ){
        this.proyectos.add(proyecto);
        this.usuarios.addAll(usuarios);
        this.tags.addAll(tags);
        this.familiasImplicadas.addAll(familiasImplicadas);
        this.titulo = titulo;
        this.descrip = descrip;
        this.coordinador = coordinador;
        this.valoracion = valoracion;
        this.estado = estado;
        this.visibilidad = visibilidad;

    }
    public void generar() {
        listaProyectos objetoProyecto = new listaProyectos();

        try {

            File archivo = new File("src/main/resources/proyectos.xml");
            JAXBContext context = JAXBContext.newInstance(listaProyectos.class);

            Marshaller marshaller = context.createMarshaller();
            Proyecto proyecto = new Proyecto(usuarios, tags, familiasImplicadas, titulo, descrip, coordinador, valoracion, estado, visibilidad);

            objetoProyecto.setProyectos(proyectos);

            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(objetoProyecto, archivo);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
