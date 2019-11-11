package com.jj;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class LecturaEmpleadoXml {
    public static void main(String argv[]) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documentoXML = builder.parse(new File("Empleados.xml"));
            documentoXML.getDocumentElement().normalize();
            /* La funci�n normalize() elimina nodos de texto vac�os y
             * combina los adyacentes (en caso de que los hubiera)
             * Parsea el documento XML para leerlo correctamente */

            // Un documento es tambi�n un nodo: la interfaz Document extiende de la interfaz Node
            System.out.println("Elemento ra�z: " + documentoXML.getDocumentElement().getNodeName());

            // Cogemos los nodos del documento XML que coinciden con "empleado"
            NodeList empleados = documentoXML.getElementsByTagName("empleado");

            // M�todos importantes:
            // NodeList:
            // - getLength() devolviendo el tama�o de la lista de nodos
            // - item(i) devuelve el nodo (objeto Node) de �ndice
            // Node
            // - getNodeValue
            // - getNodeName
            // Node/Element:
            // - getElementsByTagName(String nombreTag) devolviendo un NodeList
            // - getFirstChild() primer elemento inferior del nodo
            // - getAttribute(String atributo) valor del atributo
            // - hasAttribute(String atributo) si el nodo tiene o no este atributo
            // Existe un m�todo redundante que devuelve lo mismo que getNodeName() y es getTagName().

            for (int i = 0; i < empleados.getLength(); i++) {

                Node emple = empleados.item(i);

                if (emple.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) emple; //Convertimos el nodo en un elemento

                    System.out.println(elemento.getNodeType() == Element.ELEMENT_NODE);
                    System.out.println("ID del nodo elemento:" + elemento.getFirstChild().getNodeName());
                    System.out.println("�Cuantos nodos tiene elemento 'empleado'?:" + elemento.getChildNodes().getLength());
                    System.out.println("�Cuantos nodos tiene elemento 'id' dentro de empleado?:" + elemento.getChildNodes().item(0).getChildNodes().getLength());
                    System.out.println("�C�mo se llama el nodo en el que estoy: " + elemento.getNodeName());
                    System.out.println("ID del nodo elemento:" + elemento.getFirstChild().getChildNodes().item(0).getNodeValue());
                    System.out.println("ID: " + getNodo("id", elemento));
                    System.out.println("Apellido: " + getNodo("apellido", elemento));
                    System.out.println("Departamento: " + getNodo("dep", elemento));
                    System.out.println("Salario: " + getNodo("salario", elemento));

                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("oh, oh! Hubo un problema" + e.getMessage() + " - " + e.toString());
        }
    }//fin de main

    //obtener la informaci�n de un nodo
    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }

}
