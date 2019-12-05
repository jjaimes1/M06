package com.jj;

import java.io.*;
import java.util.*;

public class Main2 {

    public static boolean acabado= false;
    public  static String codigo="";
    public  static boolean finCodigo= false;

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/exercici2/src/com/jj/Don Quijote.txt");
        //FileReader fr = new FileReader("C:\\Users\\kazuk\\Desktop\\DAM2\\M06\\exercici2\\src\\com\\jj\\Don Quijote.txt");
        BufferedReader bReader = new BufferedReader(fr);

        File dirGuardado= new File("/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/exercici2/src/com/jj");
        //File dirGuardado= new File("C:\\Users\\kazuk\\Desktop\\DAM2\\M06\\exercici2\\src\\com\\jj");
        String dirDirectori = dirGuardado.getPath();
        File fichero1 =new File (dirDirectori, "ficheroMod.txt");

        FileWriter fMod= new FileWriter(fichero1);
        BufferedWriter modificado= new BufferedWriter(fMod);

        // codigo secreto:
        //-------------------------------------

        System.out.println("introduce el codigo secreto:");
        String codigo = "hooo quien podra ayudame";
        Scanner codigo1= new Scanner(System.in);
        codigo= codigo1.nextLine();
        //-------------------------------------


        char[] cadena = codigo.toCharArray();
        //System.out.println(cadena);
        System.out.println();

        Deque pila = new ArrayDeque();
        for (int i = cadena.length; i >0; i--)
        {
            pila.push(cadena[i-1]);
        }
        //System.out.println(pila);

        leerLinea(pila, bReader, modificado);
        bReader.close();
        modificado.close();
        FileReader ficMod = new FileReader(fichero1);
        BufferedReader leerMod = new BufferedReader(ficMod);

        buscarCodigo(leerMod);
        leerMod.close();
        System.out.println("el codigo secreto es:");
        System.out.println(codigo);

    }

    public static void leerLinea(Deque pila, BufferedReader bReader, BufferedWriter modificado) throws IOException {
        Random random = new Random();
        while (bReader.readLine()!=null)
        {
            if (bReader.readLine()==null) break;

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

    public static void buscarCodigo(BufferedReader leerMod) throws IOException {
        String lineaTOtal;
        char [] cadena;
        while (leerMod.readLine()!=null)
        {
            lineaTOtal=leerMod.readLine();
            cadena=lineaTOtal.toCharArray();


            for (int i = 0; i < cadena.length; i++)
            {
                if ((Character.toString(cadena[i])=="\\")&&(Character.toString(cadena[i+1])=="\\")&&(Character.toString(cadena[i+2])=="."))
                {
                    codigo= codigo+ Character.toString(cadena[i]);
                    finCodigo=true;
                    break;
                }
                    if ((Character.toString(cadena[i])=="\\")&&(Character.toString(cadena[i+1])=="\\"))
                {
                    codigo= codigo+ Character.toString(cadena[i]);
                    break;
                }
            }
            if (finCodigo==true)
            {
                break;
            }
        }
    }
}
