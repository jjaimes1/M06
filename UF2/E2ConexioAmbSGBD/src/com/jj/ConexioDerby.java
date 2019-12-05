package com.jj;

import java.sql.*;

public class ConexioDerby
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //Class.forName("com.mysql.cj.jdbc.Driver");


        Connection conexion = DriverManager.getConnection
                ("jdbc:derby:/home/users/inf/wiam2/iam26541596/Documents/jhonny/M06/UF2/apacheDerby/ejemplo");

        // Preparamos la consulta
        Statement sentencia = conexion.createStatement();
        ResultSet resul = sentencia.executeQuery("select * from departamentos");

        System.out.println("=============================");
        System.out.println("Coneccio BD DERBY");
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
