package com.example.joseantonio.proyecto2.Activitys;

/**
 * Created by JoseAntonio on 11/01/2017.
 */

public class Contacto{

    private int imagen;
    private String nombre;
    private int estado;

    public Contacto(int imagen, String nombre, int descripcion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.estado = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEstado() {
        return estado;
    }

    public int getImagen() {
        return imagen;
    }
}


