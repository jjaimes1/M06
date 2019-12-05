package com.jj;

import java.io.File;

public class VerDir
{

    public static void main(String[] args)
    {
        //creamos un fichero que es la rurta del fichero al que intentamos aceder
        File fichero = new File("/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/pruebasAccesoFichero/src/com/jj");
        //luego guardamos el contenido del fichero en un array de tipo string
        String[] lista =fichero.list();

        //luego mediante un bucle recorremos el contenido del array
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }
}
