package com.curso.generar;

import jakarta.persistence.Persistence;
//Para que funcione tengo que tener creada la base de datos que se llama biblioteca(persistence.xml) creada
public class Generar {
    public static void main(String[] args) {
        Persistence.generateSchema("biblioteca", null);
}
}
