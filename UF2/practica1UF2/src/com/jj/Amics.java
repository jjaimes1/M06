package com.jj;

public class Amics
{
    public int idAmic;
    public String nom;
    public String cognom1;
    public String cognom2;
    public int telefon;

    public Amics(int idAmic, String nom, String cognom1, String cognom2, int telefon) {
        this.idAmic = idAmic;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.telefon = telefon;
    }
/*
    public  {
        return "Amics{" +
                "idAmic=" + idAmic +
                ", nom='" + nom + '\'' +
                ", cognom1='" + cognom1 + '\'' +
                ", cognom2='" + cognom2 + '\'' +
                ", telefon=" + telefon +
                '}';
    }

 */
    @Override
    public String toString() {
        return "(" + idAmic +
                ",'" + nom + '\'' +
                ",'" + cognom1 + '\'' +
                ",'" + cognom2 + '\'' +
                "," + telefon +")";
    }

    public int getIdAmic() {
        return idAmic;
    }

    public void setIdAmic(int idAmic) {
        this.idAmic = idAmic;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
}
