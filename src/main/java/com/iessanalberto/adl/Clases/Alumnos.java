package com.iessanalberto.adl.Clases;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="usuario")
public class Alumnos extends Usuario {
    private String centro;
    @XmlElement(name="centro")
    public String getCentro() {
        return centro;
    }
    public Alumnos(){

    }
    public void setCentro(String centro) {
        this.centro = centro;
    }

    public Alumnos(String rol, String nombre, String contraseña, String familiaProfesional, String email, String[] gustos) {
        super(rol, nombre, contraseña, familiaProfesional, email, gustos);
    }
}
