package com.jj;

import java.sql.*;

public class ConexioPostgres
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        // Establecemos la conexion con la BD
        // todo 2/12        el error que me daba en la linea 19 era no tenia acceso a la base de datos, por lo tanto tenia que otorgarle privilegios
        // todo 2/12        al nuevo usuario creado, lo cual hice mal a primera vez
        Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost/ejemplo", "ejemplo1", "ejemplo1");

        // Preparamos la consulta
        Statement sentencia = conexion.createStatement();
        ResultSet resul = sentencia.executeQuery("select * from departamentos;");

        System.out.println("=============================");
        System.out.println("Coneccio BD POSTGRESQL");
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
