package com.jj.exercicisClase;

import java.io.File;
import java.util.Scanner;

public class Versio3
{

    public static void main(String[] args)
    {
        File directori = new File(args[0]);

        String[] directoril = directori.list();

        boolean subDir= false;
        boolean major= false;

        System.out.println("mida directori: "+ directori.length());
        System.out.println("mida de l'argument: "+ args[1]);

        if (directori.length() > Long.parseLong(args[1]))
        {
            major=true;
        }

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

                if (major)
                {
                    System.out.println("la mida total NO es me gran que la rebuda per arguments");
                    break;
                }
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
