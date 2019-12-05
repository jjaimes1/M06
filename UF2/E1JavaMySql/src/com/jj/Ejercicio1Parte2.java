package com.jj;

import java.sql.*;

public class Ejercicio1Parte2
{
    public static void main(String[] args) throws SQLException {

        //Cargar el driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplo", "root", "Jupiter1+");

            // Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery("SELECT apellido, oficio, salario FROM empleados order by salario desc limit 1")
                    ;

            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros, se van visualizando
            while (resul.next()) {
                System.out.println(resul.getString(1) + " " + resul.getString(2) + " " +
                        resul.getFloat(3));
            }

            resul.close();// Cerrar ResultSet
            sentencia.close();// Cerrar Statement
            //conexion.close();//Cerrar conexion
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//fin de main
}
