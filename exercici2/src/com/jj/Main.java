package com.jj;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;

public class Main {

    public static boolean acabado= false;

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/exercici2/src/com/jj/Don Quijote.txt");
        BufferedReader bReader = new BufferedReader(fr);

        File dirGuardado= new File("/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/exercici2/src/com/jj");
        String dirDirectori = dirGuardado.getPath();
        File fichero1 =new File (dirDirectori, "ficheroMod.txt");

        FileWriter fMod= new FileWriter(fichero1);
        BufferedWriter modificado= new BufferedWriter(fMod);

        String codigo = "hola que ace";
        char[] cadena = codigo.toCharArray();
        System.out.println(cadena);

        Deque pila = new ArrayDeque();
        for (int i = cadena.length; i >0; i--)
        {
            pila.push(cadena[i-1]);
        }
        System.out.println(pila);

        leerLinea(pila, bReader, modificado);
        bReader.close();
        modificado.close();



    }


    public static void buscarCodigo()
    {

    }
/*
    public static long numLineas(BufferedReader bReader) {
        long lNumeroLineas = 0;
        while (bReader.readLine()!=null)
        {
            System.out.println(bReader.readLine());
            lNumeroLineas++;



        }
        return lNumeroLineas;
    }
  */

    public static void leerLinea(Deque pila, BufferedReader bReader, BufferedWriter modificado) throws IOException {
       int recorrido=0;
        Random random = new Random();
        while (bReader.readLine()!=null)
        {
            if (bReader.readLine()==null) break;
            //recorrido++;

            if (random.nextBoolean()) {
                if (acabado == true) {
                    modificado.write(bReader.readLine());
                } else {
                    codigoRandom(pila, modificado, bReader.readLine());
                }
                modificado.newLine();

            }
            else
            {
                modificado.write(bReader.readLine());
                modificado.newLine();
            }
            //System.out.println(bReader.readLine());
        }


    }

    public static void codigoRandom(Deque pila, BufferedWriter modificado, String lineaTotal) throws IOException {
        Random random = new Random();
        char[] cadena = lineaTotal.toCharArray();
        int longLinea= cadena.length;
        int varlorX = (int) (Math.random()*longLinea);


        for (int i = 0; i < cadena.length; i++)
        {

            modificado.append(cadena[i]);

            if (i==varlorX)
            {
                modificado.append("\\\\");

                if (!pila.isEmpty())
                {
                    modificado.append((Character) pila.pop());

                }
                else {
                    acabado=true;
                    modificado.append(".");
                }

            }
        }

    }




}
