package com.jj;

import java.util.ArrayList;
import java.util.List;

public class ListaElementos
{

    private List<Elemento> lista = new ArrayList<Elemento>();

    public ListaElementos() {
    }

    public void add(Elemento per) {
        lista.add(per);
    }

    public List<Elemento> getListaDepartamento() {
        return lista;
    }
}

