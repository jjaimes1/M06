package com.jj;

import java.sql.*;

public class ConexioMySql {

    public static void main(String[] args) {
        //Cargar el driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplo", "root", "Jupiter1+");

            // Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery("SELECT * FROM departamentos");

            System.out.println("=============================");
            System.out.println("Coneccio BD MYSQL");
            System.out.println("=============================");

            while (resul.next()) {
                System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " +
                        resul.getString(3));
            }
            System.out.println("=============================");


            resul.close();// Cerrar ResultSet
            sentencia.close();// Cerrar Statement
            //conexion.close();//Cerrar conexion
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
