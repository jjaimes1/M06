package com.jj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File fichero = new File("/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/pruebasAccesoFichero2/ficheroPrueba/ficheroTexto.txt");
        //true es para que lo sobreescribir si ya existe
        FileWriter fic = new FileWriter(fichero, true);
        String cadena ="preuba de fichero";
        char[] cad = cadena.toCharArray();

        for (int i = 0; i < cad.length; i++)
        {
            fic.write(cad[i]);
        }

        fic.append("111111111111");
        fic.append("2222222222222 33333333");
        fic.write(cadena);

        fic.close();


    }
}
