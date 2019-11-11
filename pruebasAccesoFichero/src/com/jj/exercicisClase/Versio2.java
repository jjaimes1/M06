package com.jj.exercicisClase;

import java.io.File;
import java.util.Scanner;

public class Versio2
{

    public static void main(String[] args)
    {
        String arguments;

        System.out.println("introdueix la direccio");
        Scanner lector = new Scanner(System.in);
        arguments = lector.next();

        System.out.println(arguments);

        File directori = new File(arguments);

        String[] directoril = directori.list();

        boolean subDir= false;

        if (directoril.length!=0)
        {
            for (int i = 0; i < directoril.length; i++) {
                System.out.println(directoril[i]);
                String text= ".txt";
                if (!directoril[i].contains(text))
                {
                    subDir=true;
                }
            }



            for (int i = 0; i < directoril.length; i++) {

                if (subDir)
                {
                    System.out.println("No s'ha pogut esborrar el directori principal ni cap arxiu degut a que existeix un subdirectori\n");
                    break;
                }
                File arxiu = new File(directori + "/" + directoril[i]);

                arxiu.delete();
                if (arxiu.exists()) {
                    System.out.println("el arxiu " + arxiu + " no sa borrat correctament");
                } else {
                    System.out.println("el arxiu " + arxiu + " sa borrat correctament");
                }

            }
        }

        directori.delete();
    }
}
