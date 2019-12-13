package com.jj;

import java.sql.*;

public class Activitat11
{
    public static void main(String[] args) throws SQLException  {
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "Jupiter1+");

        String dep = args[0];

        String secuencia= "select apellido, salario, oficio from empleados where dept_no = ?" ;
        String secDep = "select dnombre from departamentos where dept_no = ?";


        PreparedStatement sentencia = conexion.prepareStatement(secuencia);
        PreparedStatement sentDep = conexion.prepareStatement(secDep);

        sentencia.setInt(1, Integer.parseInt(dep));
        sentDep.setInt(1,Integer.parseInt(dep));

        ResultSet result = sentencia.executeQuery();
        ResultSet resDep = sentDep.executeQuery();

        double salariMedio= 0;
        int numEmpl=0;

        if (resDep.next()) {
            System.out.println("============================================");
            System.out.println("APELLIDO\tSALARIO\tOFICIO\t\tDEPARAMENTO");
            System.out.println("============================================");
            while (result.next()) {
                System.out.println(
                        result.getString("apellido") + "\t\t" +
                                result.getDouble("salario") + "\t" +
                                result.getString("oficio") + "\t" +
                                resDep.getString("dnombre"));
                System.out.println("============================================");
                numEmpl++;
                salariMedio = salariMedio+ Double.valueOf(result.getString("salario"));
            }
            System.out.println("SALARIO MEDIO:\t" + salariMedio/numEmpl);
            System.out.println("============================================");
            System.out.println("NUM DE EMPLEADOS DEL DEPARTAMENTO " + dep +":\t"+ numEmpl);
        }
        else
        {
            System.out.println("======================================================");
            System.out.println("el departamento " + dep + " introducido por argumento NO EXISTE");
            System.out.println("======================================================");
        }


        result.close();
        sentencia.close();
        //resDep.close();
        //sentDep.close();
        //// TODO: 12/9/19   por alguna razon, si cierro la coneccion me da error,
        //// TODO: 12/9/19   ya lo vimos en clase de todas las formas en los otros ejercicios
        conexion.close();
    }
}
