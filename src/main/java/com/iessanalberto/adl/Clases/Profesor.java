package com.iessanalberto.adl.Clases;

import com.iessanalberto.adl.Clases.Usuario;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="usuario")
public class Profesor extends Usuario {
    private String centro;
    @XmlElement(name="centro")
    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public Profesor(String rol, String nombre, String contraseña, String familiaProfesional, String email, String[] gustos) {
        super(rol, nombre, contraseña, familiaProfesional, email, gustos);
    }
}
