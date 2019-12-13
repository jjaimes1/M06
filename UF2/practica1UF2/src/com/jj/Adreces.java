package com.jj;

public class Adreces
{
    public int idAdreces;
    public int idAmic;
    public String nomVia;
    public int cp;
    public String poblacio;

    public Adreces(int idAdreces, int idAmic, String nomVia, int cp, String poblacio) {
        this.idAdreces = idAdreces;
        this.idAmic = idAmic;
        this.nomVia = nomVia;
        this.cp = cp;
        this.poblacio = poblacio;
    }
/*
    @Override
    public String toString() {
        return "Adreces{" +
                "idAdreces=" + idAdreces +
                ", idAmic=" + idAmic +
                ", nomVia='" + nomVia + '\'' +
                ", cp=" + cp +
                ", poblacio='" + poblacio + '\'' +
                '}';
    }


 */

    @Override
    public String toString() {
        return "INSERT INTO adreces VALUES(" +
                "" + idAdreces +
                "," + idAmic +
                ",'" + nomVia + '\'' +
                "," + cp +
                ",'" + poblacio + '\'' +")";
    }

    public int getIdAdreces() {
        return idAdreces;
    }

    public void setIdAdreces(int idAdreces) {
        this.idAdreces = idAdreces;
    }

    public int getIdAmic() {
        return idAmic;
    }

    public void setIdAmic(int idAmic) {
        this.idAmic = idAmic;
    }

    public String getNomVia() {
        return nomVia;
    }

    public void setNomVia(String nomVia) {
        this.nomVia = nomVia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }
}
