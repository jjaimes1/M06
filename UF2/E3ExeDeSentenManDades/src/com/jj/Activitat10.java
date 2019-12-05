package com.jj;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Activitat10
{
    static DateTimeFormatter formatterDDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String emp_n = "6666";
        String apellido = "PEPITO";
        String oficio = "VENDEDOR";
        String dir = "7902";

        // todo esta fecha hay que actualizarla pra que funcione correctamente
        String fechaIntroducida = "05/12/2019";
        String fechaActual = LocalDateTime.now().format(formatterDDMMYYYY);
        String salario = "1111";
        String comision = "666";
        String dept_n = "10";
        int imsertarOK = 0;
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "Jupiter1+");
        Statement sentencia = conexion.createStatement();

        ResultSet depExist = sentencia.executeQuery("select * from departamentos where dept_no = "+ dept_n);
        if (depExist.next())        {
            System.out.println("el departamento " + dept_n+ " existe");
        }
        ResultSet empExist = sentencia.executeQuery("select * from empleados where EMP_NO = "+ emp_n);
        if (!empExist.next())        {
            System.out.println("el empleado " + emp_n +" NO existe en la lista");
        }
        if (Float.valueOf(salario)>0)        {
            System.out.println("el salario es major que 0");
        }
        ResultSet dirExist = sentencia.executeQuery("select * from empleados where dir = "+ dir);
        if (dirExist.next())        {
            System.out.println("el empleado " + emp_n +" NO existe en la lista");
        }
        if (fechaActual.equals(fechaIntroducida))        {
            System.out.println("la fecha introducida es correcta");
        }

        /*
        while (depExist.next()) {
            System.out.println(depExist.getInt(1) + " " + depExist.getString(2) + " " +
                    depExist.getString(3));
        }*/

        //String insercio = "INSERT  INTO empleados VALUES (" + emp_n + ",'" + apellido + "','" + oficio + "'," + dir + ",'" + fecha + "'," + salario + "," + comision + "," + dept_n + ")";
        //Statement sentencia = conexion.createStatement();
        //int resul = sentencia.executeUpdate(insercio);
        //System.out.println(insercio);

        sentencia.close();
        //conexion.close();

    }
}
