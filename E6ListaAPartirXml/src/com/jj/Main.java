package com.jj;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {

    public static void main(String[] args)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("produkte.xml"));
            document.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList productos = document.getElementsByTagName("empleado");

            for (int i = 0; i < productos.getLength(); i ++) {

                Node emple = productos.item(i);

                if (emple.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) emple;
                    /*
                    System.out.println("ID: " + getNodo("id", elemento));
                    System.out.println("Apellido: " + getNodo("apellido", elemento));
                    System.out.println("Departamento: " + getNodo("dep", elemento));
                    System.out.println("Salario: " + getNodo("salario", elemento));
                    */

                }
            }
        } catch (Exception e) { e.printStackTrace();}

    }
}
