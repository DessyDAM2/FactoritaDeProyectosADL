package com.iessanalberto.adl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class generarJson {
    public static void main(String[] args) {
        try {
            listaProyectos lista;
            JAXBContext context = JAXBContext.newInstance(listaProyectos.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            lista = (listaProyectos) unmarshaller.unmarshal(new File("src/main/resources/proyectos.xml"));

            Path archivo = Path.of("target/proyectos.json");
            Gson gson;
            GsonBuilder builder = new GsonBuilder();
            gson = builder.setPrettyPrinting().create();
            String texto = gson.toJson(lista);
            Files.write(archivo, texto.getBytes());
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

    }
}
