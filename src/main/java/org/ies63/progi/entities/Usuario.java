package org.ies63.progi.entities;

import java.io.Serializable;

// Serializable: recomendado para los objetos que se guardan en la sesion
public class Usuario implements Serializable {

    private int id;
    private String nombre;
    private String clave;

    //CONSTRUCTORES
    public Usuario(){
    }
    public Usuario(String nombre, String clave){
        this.nombre=nombre;
        this.clave=clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString(){
        return "Usuario:" + this.id + " - " + this.nombre;
    }

}
