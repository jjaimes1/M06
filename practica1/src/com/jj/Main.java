package com.jj;

import java.util.Scanner;

public class Main {
//https://moodle.escoladeltreball.org/pluginfile.php/71671/mod_resource/content/1/LecturaEmpleadoXml.java
    //mirar el putaso (por cortesia de aitor)
    /*
private static String getNodo(String etiqueta, Element elem)
{
    NodeList nodo= elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
    Node valornodo = (Node) nodo.item(0);
    return valornodo.getNodeValue();
}


}//fin de la clase

     */
    public static void main(String[] args)
    {
        System.out.println("=======================================");
        System.out.println("pulsa un buto per escollir una opcio");
        System.out.println("=======================================");
        System.out.println("1)   Introduccio de dades");
        System.out.println("2)   Llistat de dades");
        System.out.println("3)   Guardar dades en arxiu BINARI");
        System.out.println("4)   Guardar dades en arxiu XML");
        System.out.println("5)   Lllegir dades en arxiu BINARI");
        System.out.println("6)   Llegir dades d'arxiu XML");
        System.out.println("7)   Sortir");
        System.out.println("=======================================");

        Scanner scanner = new Scanner(System.in);
        String opcio = scanner.nextLine();

        switch (opcio)
        {
            case "1":

        }


    }
}
