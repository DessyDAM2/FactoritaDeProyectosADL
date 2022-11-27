package com.iessanalberto.adl.Clases;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement (name="usuario")
@XmlType(propOrder ={"rol","nombre","contraseña","puntuacion","familiaProfesional","email","telefono","gustos","comentariosPersonales","comentariosExternos","historial","proyectosFavoritos"})
public class Usuario {


    private String rol;
    private String nombre;
    private String contraseña;
    private Double puntuacion;

    private String familiaProfesional;
    private String email;
    private String telefono;
    private String[] gustos;
    private String[] comentariosPersonales;
    private String[] comentariosExternos;
    private Proyecto[] historial;
    private Proyecto[] proyectosFavoritos;

    public Usuario(String rol, String nombre, String contraseña, String familiaProfesional, String email, String[] gustos){
        this.rol=rol;
        this.nombre=nombre;
        this.contraseña=contraseña;
        this.familiaProfesional=familiaProfesional;
        this.email=email;
        this.gustos=gustos;
    }
    public Usuario(){};
    @XmlElement(name="rol")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    @XmlElement(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement(name="contraseña")
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    @XmlElement(name="puntuacion")
    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }
    @XmlElement(name="familiaProfesional")
    public String getFamiliaProfesional() {
        return familiaProfesional;
    }

    public void setFamiliaProfesional(String familiaProfesional) {
        this.familiaProfesional = familiaProfesional;
    }
    @XmlElement(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @XmlElement(name="telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @XmlElementWrapper(name = "gustos")
    @XmlElement(name="gusto")
    public String[] getGustos() {
        return gustos;
    }

    public void setGustos(String gustos[]) {
        this.gustos = gustos;
    }
    @XmlElementWrapper(name = "comentariosPersonales")
    @XmlElement(name="comentariosPersonal")
    public String[] getComentariosPersonales() {
        return comentariosPersonales;
    }

    public void setComentariosPersonales(String[] comentariosPersonales) {
        this.comentariosPersonales = comentariosPersonales;
    }
    @XmlElementWrapper(name = "historial")
    @XmlElement(name="proyecto")
    public Proyecto[] getHistorial() {
        return historial;
    }

    public void setHistorial(Proyecto[] historial) {
        this.historial = historial;
    }
    @XmlElementWrapper(name = "historialFavoritos")
    @XmlElement(name="favorito")
    public Proyecto[] getProyectosFavoritos() {
        return proyectosFavoritos;
    }

    public void setProyectosFavoritos(Proyecto[] proyectosFavoritos) {
        this.proyectosFavoritos = proyectosFavoritos;
    }

    @XmlElementWrapper(name = "comentariosPersonales")
    @XmlElement(name="comentariosPersonal")
    public String[] getComentariosExternos() {
        return comentariosExternos;
    }

    public void setComentariosExternos(String[] comentariosExternos) {
        this.comentariosExternos = comentariosExternos;
    }
}
