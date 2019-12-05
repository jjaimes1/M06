package com.jj.exercicisClase;

import java.io.File;
import java.util.Scanner;

public class Versio1
{
    //1     eliminar directori que s passi com argument 1 nivell de directori

    public static void main(String[] args) {




        File directori = new File(args[0]);


        String[] directoril = directori.list();

        if (directoril.length!=0)
        {
            for (int i = 0; i < directoril.length; i++) {
                System.out.println(directoril[i]);
            }

            for (int i = 0; i < directoril.length; i++) {

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


        /*
        if (directoril.length<=0)
        {
            directori.delete();
        }else
        {
            System.out.println("el directorio escogido tiene algun documento dentro");
        }

        if (directori.exists())
        {
            System.out.println("el directorio escogido no se ha podido borrar correctamente");
        }
        else {
            System.out.println("el directorio escogido se ha podido borrar corectamente");
        }
*/


    }



    //2     eleminar directori amb 1 subdirectori i 3 fitxers
    //3     igual que el ex 2 pero nomes esborra si el tamany es > que el argument que es passa
}
