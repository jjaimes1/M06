package com.jj;

import com.sun.net.httpserver.Headers;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.text.html.CSS.getAttribute;

public class Main {

    public static void main(String[] args)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("produkte.xml"));
            document.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList productos = document.getElementsByTagName("element");
            //

            ArrayList<String> descripciones = new ArrayList<>();

            for (int i = 1; i < productos.getLength(); i ++) {

                Node nNode = productos.item(i);

                 if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                     Element elemento = (Element) nNode;
                     System.out.println( i + ") " + elemento.getAttribute("header"));
                     descripciones.add(elemento.getAttribute("text"));
                 }
            }
            System.out.println("Introdueix el número del curs del que vols informació: ");

            Scanner lector = new Scanner(System.in);
            int posicionDesc = Integer.valueOf(lector.nextLine())-1;
            System.out.println("Informació del curs:");
            if (descripciones.get(posicionDesc).equals(""))
            {
                System.out.println("no tiene descripcion");
            }
            else
            {
                System.out.println(descripciones.get(posicionDesc));
            }

        } catch (Exception e) { e.printStackTrace();}
    }
}
