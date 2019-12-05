package com.jj;

import java.io.Serializable;
import java.util.Objects;

public class Elemento implements Serializable
{
    public  int id;
    public  String ano;
    public  String temporada;
    public  String thumb;


    public Elemento(int id, String ano, String temporada, String thumb) {
        this.id = id;
        this.ano = ano;
        this.temporada = temporada;
        this.thumb = thumb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elemento elemento = (Elemento) o;
        return id == elemento.id &&
                Objects.equals(ano, elemento.ano) &&
                Objects.equals(temporada, elemento.temporada) &&
                Objects.equals(thumb, elemento.thumb);
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "id=" + id +
                ", ano='" + ano + '\'' +
                ", temporada='" + temporada + '\'' +
                ", thumb='" + thumb + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ano, temporada, thumb);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnyo() {
        return ano;
    }

    public void setAnyo(String ano) {
        this.ano = ano;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getImagen() {
        return thumb;
    }

    public void setImagen(String thumb) {
        this.thumb = thumb;
    }
}
