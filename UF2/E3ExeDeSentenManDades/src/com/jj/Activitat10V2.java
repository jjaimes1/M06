package com.jj;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Activitat10V2
{
    static DateTimeFormatter formatterYYYYMMDD = DateTimeFormatter.ofPattern("yyyy/MM");
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String suma0="";
        Class.forName("com.mysql.cj.jdbc.Driver");

        String emp_n = "6666";
        String apellido = "MORENO";
        String oficio = "VENDEDOR";
        String dir = "7902";

        // todo esta fecha hay que actualizarla pra que funcione correctamente
        String fechaIntroducida = "05/12/2019";
        if (LocalDateTime.now().getDayOfMonth()<10) suma0="0";
        String fechaActual = LocalDateTime.now().format(formatterYYYYMMDD)+ "/"+ suma0 + LocalDateTime.now().getDayOfMonth();

        String salario = "1111";
        String comision = "666";
        String dept_n = "10";
        boolean correcte = false;
        String error = "sin errores";
        Scanner sc = new Scanner(System.in);
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "Jupiter1+");
        Statement sentencia = conexion.createStatement();

        System.out.println(fechaActual);

        while (!correcte)
        {
        System.out.println("introduce los datos necesarios para rellenar la tabla");
        System.out.println("=====================================================");
        System.out.print("introduce num de empleado NO EXISTENTE: ");
        emp_n= sc.nextLine();
        System.out.print("introduce apellido: ");
        apellido = sc.nextLine();
        System.out.print("introduce oficio: ");
        oficio = sc.nextLine();
        System.out.print("introduce el numero del director EXISTENTE: ");
        dir = sc.nextLine();
        System.out.print("introduce la fecha ACTUAL EN FORMATO YYYY/MM/DD: ");
        fechaIntroducida = sc.nextLine();
        System.out.print("introduce el salario MAYOR QUE CERO: ");
        salario = sc.nextLine();
        System.out.print("introduce la comision: ");
        comision = sc.nextLine();
        System.out.print("introduce el numero de departamento EXISTENTE: ");
        dept_n = sc.nextLine();

        ResultSet depExist = sentencia.executeQuery("select * from departamentos where dept_no = "+ dept_n);
        if (!depExist.next()) {
            error = "el departamento " + dept_n+ "NO existe";
        }
        ResultSet empExist = sentencia.executeQuery("select * from empleados where EMP_NO = "+ emp_n);
        if (empExist.next()) {
            error = "el empleado " + emp_n +" YA EXISTE en la lista";
        }
        if (Float.valueOf(salario)<0) {
            error = "el salario NO es mayor que 0";
        }
        ResultSet dirExist = sentencia.executeQuery("select * from empleados where dir = "+ dir);
        if (!dirExist.next()) {
            error = "el director " + emp_n +" NO existe en la lista";
        }
        if (!fechaActual.equals(fechaIntroducida)) {
            error = "la fecha introducida NO es correcta (LA ACTUAL)";
        }

        if (!error.equals("sin errores")) {
            System.out.println(error);
            error = "sin errores";
            System.out.println("VUELVE A INTENTARLO");
        }
        else
        {
            correcte= true;
            System.out.println("===============");
            System.out.println(" TODO CORRECTO");
            System.out.println("===============");
            break;
        }
        }

        String insercio = "INSERT  INTO empleados VALUES (" + emp_n + ",'" + apellido + "','" + oficio + "'," + dir + ",'" + fechaIntroducida + "'," + salario + "," + comision + "," + dept_n + ")";
        Statement sentencia1 = conexion.createStatement();
        int resul = sentencia1.executeUpdate(insercio);
        System.out.println(insercio);

        sentencia.close();
        //conexion.close();


    }
}
