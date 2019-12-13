package com.jj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main
{
    //// TODO: 12/12/19 datos de la tabla AMICS
    public int idAmic;
    public String nom;
    public String cognom1;
    public String cognom2;
    public int telefon;
    //// TODO: 12/12/19 datos de la tabla ADRECES
    public int idAdreces;
    public String nomVia;
    public int cp;
    public String poblacio;

//// TODO: 12/12/19 creacion de los objetos amics y adreces

    public static Set<Amics> amicsSet = new LinkedHashSet<Amics>();
    public static Set<Adreces> adrecesSet = new LinkedHashSet<Adreces>();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "Jupiter1+");
        //Statement statement = conexion.createStatement();

        amicsSet.add(new Amics(21,"manolito", "jimenes", "morales", 666555444));



        String opcio ="";
        Scanner sc = new Scanner(System.in);
        while (!opcio.equals("q")) {
            System.out.println("·············ESCULL UNA DE LES SEGUENTS OPCIONS···········");
            System.out.println("==========================================================");
            System.out.println("1. Altes");
            System.out.println("2. Baixes");
            System.out.println("3. Modificacio de dades");
            System.out.println("4. Llistat de tots el amics que tinguem i la seva adreça");
            System.out.println("5. Cerca per nom o cognom i que retorni tots el resultats" +
                    "\n   coincidents amb el que hagi introduit l'usuari en fer la cerca");
            System.out.println("\nq. sortir");

            opcio = sc.nextLine();
            switch (opcio) {
                case "1":
                    System.out.println("hola que ace 1");

                    donarAlta(conexion);

                    bloquejarPantalla();
                    break;
                case "2":
                    System.out.println("hola que ace 2");
                    bloquejarPantalla();
                    break;
                case "3":
                    System.out.println("hola que ace 3");
                    bloquejarPantalla();
                    break;
                case "4":
                    System.out.println("hola que ace 4");
                    bloquejarPantalla();
                    break;
                case "5":
                    System.out.println("hola que ace 5");
                    bloquejarPantalla();
                    break;
                case "q":
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("opcio equivocada");
                    bloquejarPantalla();
            }
        }
    }

    public static void donarAlta(Connection con)
    {
        boolean autocomit = true;
        Statement stm = null;
        try {
            autocomit= con.getAutoCommit();
            stm=con.createStatement();
            stm.executeUpdate(String.valueOf(amicsSet));


        }catch (SQLException ex)
        {

        }
    }
    public static void donarBaixa()
    {

    }
    public static void modificacioDades()
    {

    }
    public static void llistarDades()
    {

    }
    public static void busquedaPerNomOCogn()
    {

    }


    public static void bloquejarPantalla() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("Toca 'C' per a continuar ");
        while (in.hasNext()) {
            if ("C".equalsIgnoreCase(in.next())) break;
        }
        System.out.println();
        System.out.println();
    }
}
