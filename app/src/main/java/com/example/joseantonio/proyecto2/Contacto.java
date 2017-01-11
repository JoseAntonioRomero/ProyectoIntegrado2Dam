package com.example.joseantonio.proyecto2;

/**
 * Created by JoseAntonio on 11/01/2017.
 */

public class Contacto{

    private int imagen;
    private String nombre;
    private String estado;

    public Contacto(int imagen, String nombre, String descripcion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.estado = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public int getImagen() {
        return imagen;
    }
}


