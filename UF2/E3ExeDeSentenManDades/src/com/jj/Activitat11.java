package com.jj;

import java.sql.*;

public class Activitat11
{
    public static void main(String[] args) throws SQLException {
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "Jupiter1+");
        PreparedStatement sentencia = conexion.createStatement();

    }
}
