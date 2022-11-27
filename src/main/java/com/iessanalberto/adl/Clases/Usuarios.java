package com.iessanalberto.adl.Clases;

import com.iessanalberto.adl.Clases.Usuario;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name="usuarios")
public class Usuarios {

    private List<Usuario> listaUsuarios=new ArrayList<>();
    @XmlElement(name = "usuario")
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
