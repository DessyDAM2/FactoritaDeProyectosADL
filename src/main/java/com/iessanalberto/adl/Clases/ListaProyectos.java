package com.iessanalberto.adl.Clases;

import com.iessanalberto.adl.Clases.Proyecto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


import java.util.ArrayList;
@XmlRootElement(name = "proyectos")
public class ListaProyectos {
    //Cambios, Inicializacion del componente generaba errores con el setter de proyectos si no se inicializaba y en lugar del
    //set utilizo un acceso directo al atributo proyectos para añadir proyectos con add


    ArrayList<Proyecto> proyectos=new ArrayList<>();

    public ListaProyectos() {
    }

    //Pequeño cambio añadir esta etiqueta, el archivo de muestra enviado contenia un error mostraba la etiqueta proyectos
    //dos veces
    // <proyectos>
        // <proyectos>
        // </proyectos>
    // </proyectos>
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
