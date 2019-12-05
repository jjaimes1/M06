package com.jj;

import java.sql.*;

public class ConexioSqlLite
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Cargar el driver

            Class.forName("org.sqlite.JDBC");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection
                    ("jdbc:sqlite:/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/UF2/sqlit/ejemplo.db");

            // Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery("select * from departamentos");

            System.out.println("=============================");
            System.out.println("Coneccio BD SQLITE");
            System.out.println("=============================");

            while (resul.next()) {
                System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " +
                        resul.getString(3));
            }
            System.out.println("=============================");


            resul.close();// Cerrar ResultSet
            sentencia.close();// Cerrar Statement
            conexion.close();//Cerrar conexion

    }
}
