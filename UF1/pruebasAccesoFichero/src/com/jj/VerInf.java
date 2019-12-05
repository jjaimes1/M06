package com.jj;

import java.io.File;

public class VerInf
{
    public static void main(String[] args)
    {
        File fichero = new File("/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/pruebasAccesoFichero/src/com/jj");

        System.out.println("el nombre del fichero es: " + fichero.getName());

        System.out.println("la direccion absoluta es: "+ fichero.getPath());

        System.out.println("la longitud del fichero es: "+fichero.length());

        if (fichero.exists())
            System.out.println("el archivo existe");
        else System.out.println("el archivo no existe");

        if(fichero.isFile())
            System.out.println("es un fichero");
        else System.out.println("no es un fichero");

        if (fichero.canExecute())
            System.out.println("el fichero se puede ejecutar");
        else
            System.out.println("el fichero NO se puede ejecutar");

        if (fichero.canRead())
            System.out.println("el fichero se puede leer");
        else
            System.out.println("el fichero NO se puede leer");

        if (fichero.canWrite())
            System.out.println("el fichero se puede modificar");
        else
            System.out.println("el fichero NO se puede modificar");

    }
}
