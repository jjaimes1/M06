package com.jj;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class CrearDir
{
    public static void main(String[] args)
    {
        File directorio = new File("/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/pruebasAccesoFichero/src/com/jj/directori1");
        directorio.mkdir();

        if (directorio.exists())
            System.out.println("el directorio se ha creado correctamente");
        else
            System.out.println("el directorio no se ha conseguido crear");


        // ambas formas hacen lo mismo de diferente forma
        /*
        File fichero1 = new File (directorio.getPath() + "/fichero1.txt");
        System.out.println(fichero1);
        */

        String dirDirectori = directorio.getPath();
        File fichero1 =new File (dirDirectori, "fichero1.txt");

        File fichero2 =new File (dirDirectori, "fichero2.txt");



        try {
            fichero1.createNewFile();
            fichero2.createNewFile();

        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
