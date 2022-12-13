package com.iessanalberto.adl.Clases;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
@XmlRootElement(name = "proyectos")
public class ListaProyectos {
    ArrayList<Proyecto> proyectos=new ArrayList<>();

    public ListaProyectos() {
    }

    @XmlElement(name= "proyecto")
    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    public void addProyectos(Proyecto proyecto) {
        this.proyectos.add(proyecto);
    }
}
