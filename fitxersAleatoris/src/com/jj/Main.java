package com.jj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Main {

    public static boolean letra = true;
    public static String conv= "_";
    public static void main(String[] args) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        // TODO: 10/22/19
        /*

            ID: 1, Apellido: FERNANDEZ , Departamento: 10, Salario: 1000.45
            ID: 2, Apellido: GIL       , Departamento: 20, Salario: 2400.6
            ID: 3, Apellido: LOPEZ     , Departamento: 10, Salario: 3000.0
            ID: 4, Apellido: RAMOS     , Departamento: 10, Salario: 1500.56
            ID: 5, Apellido: SEVILLA   , Departamento: 30, Salario: 2200.0
            ID: 6, Apellido: CASILLA   , Departamento: 30, Salario: 1435.87
            ID: 7, Apellido: REY       , Departamento: 20, Salario: 2000.0
         */

        int id, dep, posicio=0;
        double salari = 0, sueldoTotal;
        String nombre, apellido;
        char cognom[]= new char[10], aux;
        String apellidoS= new String();


        System.out.println("introduce id y un nombre");
        Scanner entradaTeclado= new Scanner(System.in);

        System.out.println("introdude un ID valido (1 a 7)");
        id= Integer.valueOf(entradaTeclado.nextLine());

        System.out.println("introduce un nombre");
        nombre = entradaTeclado.nextLine().toUpperCase();

        System.out.println("introduce un sueldo a añadido");
        sueldoTotal=Double.valueOf(entradaTeclado.nextLine());

        for (;;)
        {
            file.seek(posicio);
            if (id==file.readInt())
            {
                for (int i = 0; i < cognom.length; i++)
                {
                    aux=file.readChar();

                    cognom[i]=aux;
                }
                dep=file.readInt();
                apellidoS= new String(cognom);
                salari=file.readDouble();
               //System.out.println("ID de la persona: "+ id +"\nCognom: "+ apellidoS +"\nSalari total: "+ salari);
                break;
            }
            posicio=posicio+36;
            if (file.getFilePointer()==file.length())
            {
                System.out.println("no se ha encontrado el ID seleccionado");
                break;
            }
        }
        sueldoTotal=sueldoTotal+salari;
        System.out.println("ID de la persona: "+ id +"\nNombre: "+ nombre +"\nApellido: "+ apellidoS +"\nSueldo total: "+ sueldoTotal);
    }
}
