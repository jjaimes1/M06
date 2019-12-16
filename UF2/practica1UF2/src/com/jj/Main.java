package com.jj;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main
{
    //// TODO: 12/12/19 datos de la tabla AMICS
    public static int idAmic;
    public static String nom;
    public static String cognom1;
    public static String cognom2;
    public static int telefon;
    //// TODO: 12/12/19 datos de la tabla ADRECES
    public static int idAdreces;
    public static String nomVia;
    public static int cp;
    public static String poblacio;

//// TODO: 12/12/19 creacion de los objetos amics y adreces

    public static Set<Amics> amicsSet = new LinkedHashSet<Amics>();
    public static Set<Adreces> adrecesSet = new LinkedHashSet<Adreces>();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agendadb", "root", "Jupiter1+");
        //Statement statement = conexion.createStatement();


        amicsSet.add(new Amics(21,"manolito", "jimenes", "morales", 666555444));
        adrecesSet.add(new Adreces(21,21,"falsa",18912,"barcelona") );



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
                    donarAlta(conexion);
                    bloquejarPantalla();
                    break;
                case "2":
                    donarBaixa(conexion);

                    bloquejarPantalla();
                    break;
                case "3":
                    System.out.println("hola que ace 3");

                    modificacioDades(conexion);
                    bloquejarPantalla();
                    break;
                case "4":
                    llistarDades(conexion);
                    bloquejarPantalla();
                    break;
                case "5":
                    busquedaPerNomOCogn(conexion);

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

    public static void donarAlta(Connection con) throws SQLException {
        boolean autocomit = true;
        Statement stm = null;
        try {

            autocomit= con.getAutoCommit();
            con.setAutoCommit(false);
            stm=con.createStatement();

            for (Amics am : amicsSet)
            {
                 stm.executeUpdate("INSERT  INTO amics VALUES" + am);
            }
            for (Adreces ad : adrecesSet)
            {
                stm.executeUpdate("INSERT  INTO adreces VALUES" + ad);
            }
            con.setAutoCommit(autocomit);

        } catch (SQLException e)
        {
            System.out.println("===================================================================");
            System.out.println("NO S'HA POGUT INSERTAR UN NOU AMIC O ADREÇA PER ALGUNA DADA ERRONEA");
            System.out.println("===================================================================\n");
            System.out.println("==================");
            System.out.println("PROVA UN ALTRE COP");
            System.out.println("==================");
            con.rollback();
            //throw e;
        }

        amicsSet.removeAll(amicsSet);
        adrecesSet.removeAll(adrecesSet);
    }
    public static void donarBaixa(Connection con) throws SQLException {
        boolean autocomit = true;
        boolean rpta1 = false;
        boolean rpta2 = false;
        Statement stm = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("introdueix el ID de l'amic que vols d'onar de baixa");
        String idABorrar;
        try {
            autocomit= con.getAutoCommit();
            con.setAutoCommit(false);
            stm=con.createStatement();

            String baixaAmics = " delete from amics where idamic= ?;";
            String baixaAdreces = " delete from adreces where idamic= ?;";

            PreparedStatement prepAmics= con.prepareStatement(baixaAmics);
            PreparedStatement prepAdreces= con.prepareStatement(baixaAdreces);

            idABorrar= sc.nextLine();

            prepAmics.setInt(1,Integer.parseInt(idABorrar));
            prepAdreces.setInt(1,Integer.parseInt(idABorrar));

            rpta2 = prepAdreces.executeUpdate()==1;
            rpta1 = prepAmics.executeUpdate()==1;

            con.setAutoCommit(autocomit);
            System.out.println("s'ha donat de baixa correctament l'amic amb l'id: "+ idABorrar);
        } catch (SQLException e)
        {
            System.out.println("===================================================================");
            System.out.println("NO S'HA POGUT DONAR DE BAIXA UN NOU AMIC PER ALGUNA DADA ERRONEA");
            System.out.println("===================================================================\n");
            System.out.println("==================");
            System.out.println("PROVA UN ALTRE COP");
            System.out.println("==================");
            con.rollback();
            throw e;
        }

    }
    public static void modificacioDades(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("escriu l'ID de l'amic que vols modificar");
        int idCambiant = Integer.parseInt(sc.nextLine());

        System.out.println("quina taula vols modificar");
        System.out.println("1. la taula amics");
        System.out.println("2. la taula adreces");
        System.out.println("3. les dues taules");
        int opcio = Integer.parseInt(sc.nextLine());
        switch (opcio)
        {
            case '1':
                modTaulaAmics(con, idCambiant);

        }

    }

    public static void modTaulaAmics(Connection con, int idEscollit) throws SQLException {
        //update adreces set nomvia='verdadera' where idamic=21;
        boolean autocomit = true;
        boolean rpta1 = false;
        Statement stm = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("introdueix el ID de l'amic que vols d'onar de baixa");
        String idABorrar;
        try {

            String modAmics = " update amics set nom=?, cognom1=?, cognom2=?, telefon=? where idamic=" + idEscollit;

            PreparedStatement prepAmics= con.prepareStatement(modAmics);

            System.out.println("introdueix el nou NOM");
            nom= sc.nextLine();
            System.out.println("introdueix el nou COGNOM1");
            cognom1 = sc.nextLine();
            System.out.println("introdueix el nou COGNOM2");
            cognom2 = sc.nextLine();
            System.out.println("introdueix el nou TELEFON");
            telefon = Integer.parseInt(sc.nextLine());

            prepAmics.setString(1,nom);
            prepAmics.setString(2,nom);
            prepAmics.setString(3,nom);
            prepAmics.setInt(4,telefon);

            rpta1 = prepAmics.executeUpdate()==1;

        } catch (SQLException e)
        {
            System.out.println("===================================================================");
            System.out.println("NO S'HA POGUT DONAR DE BAIXA UN NOU AMIC PER ALGUNA DADA ERRONEA");
            System.out.println("===================================================================\n");
            System.out.println("==================");
            System.out.println("PROVA UN ALTRE COP");
            System.out.println("==================");
            con.rollback();
            throw e;
        }



    }
    public static void modTaulaAdreces()
    {

    }

    public static void llistarDades(Connection con) throws SQLException {
        Statement sen = con.createStatement();
        Statement sen2 = con.createStatement();
        ResultSet resAmics = sen.executeQuery("select * from amics");
        ResultSet resAdreces = sen2.executeQuery("select * from adreces");

        while (resAmics.next())
        {
            resAdreces.next();
            System.out.println("===================================");
            System.out.println("===================================");
            System.out.println("id amic: \t"+resAmics.getString(1)+ "\nnombre: \t"+resAmics.getString(2)+ "\ncognom1: \t"+resAmics.getString(3)+ "\ncognom2: \t"+resAmics.getString(4)+ "\ntelefon: \t"+resAmics.getString(5));
            System.out.println("-----------------------------------");
            System.out.println("id adreça: \t"+resAdreces.getString(1)+"\nvia: \t\t"+resAdreces.getString(3)+ "\nCP: \t\t"+resAdreces.getString(4)+ "\npoblacio: \t"+resAdreces.getString(5));
        }
        resAmics.close();
        resAdreces.close();
    }
    public static void busquedaPerNomOCogn(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String paraulaBusc;
        String busqueda = "select * from amics where nom=? or cognom1=? or cognom2=?";
        PreparedStatement prepBuscqueda = con.prepareStatement(busqueda);

        System.out.println("introdueix el nom o cognom pel cual vols fer la cerca");
        paraulaBusc= sc.nextLine();

        prepBuscqueda.setString(1,paraulaBusc);
        prepBuscqueda.setString(2,paraulaBusc);
        prepBuscqueda.setString(3,paraulaBusc);

        ResultSet result = prepBuscqueda.executeQuery();

        while (result.next())
        {
            System.out.println("===================================");
            System.out.println("id amic: \t"+result.getString(1)+ "\nnombre: \t"+result.getString(2)+ "\ncognom1: \t"+result.getString(3)+ "\ncognom2: \t"+result.getString(4)+ "\ntelefon: \t"+result.getString(5));
        }

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
