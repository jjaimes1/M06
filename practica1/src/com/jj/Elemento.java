package com.jj;

import java.util.Objects;

public class Elemento
{
    public  int id;
    public  String anyo;
    public  String temporada;
    public  String imagen;


    public Elemento(int id, String anyo, String temporada, String imagen) {
        this.id = id;
        this.anyo = anyo;
        this.temporada = temporada;
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elemento elemento = (Elemento) o;
        return id == elemento.id &&
                Objects.equals(anyo, elemento.anyo) &&
                Objects.equals(temporada, elemento.temporada) &&
                Objects.equals(imagen, elemento.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, anyo, temporada, imagen);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
