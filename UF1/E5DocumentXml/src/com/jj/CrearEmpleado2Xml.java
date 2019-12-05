package com.jj;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class CrearEmpleado2Xml {
    public static void main(String arg[]) throws IOException {
        File fichero = new File("FichData.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int  edades, dep, posicion=0; //para situarnos al principio del fichero
        Double salario;
        char nombre[] = new char[10], aux;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0"); // asignamos la version de nuestro XML

            for(;;) {
                file.seek(posicion); //nos posicionamos

                for (int i = 0; i < nombre.length; i++) {
                    aux = file.readChar();//recorro uno a uno los caracteres del nombre
                    nombre[i] = aux;    //los voy guardando en el array
                }
                String nombreS= new String(nombre);//convierto a String el array
                edades=file.readInt(); // obtengo edades de empleado
                dep=file.readInt();//obtengo dep
                salario=file.readDouble();  //obtengo salario

                if(edades>0) { //edades validos a partir de 1
                    Element raiz = document.createElement("empleado"); //nodo empleado
                    document.getDocumentElement().appendChild(raiz);
                    CrearElemento("nombres",nombreS.trim(), raiz, document); //Nombres
                    CrearElemento("edades",Integer.toString(edades), raiz, document); //a�adir ID
                }
                posicion= posicion + 36; // me posiciono para el sig empleado
                if (file.getFilePointer() == file.length())   break;

            }//del for que recorre el fichero

            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("Empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console= new StreamResult(System.out);
            transformer.transform(source, console);


        }catch(Exception e)
        {
            System.err.println("Error: "+e);
        }
        file.close();  //cerrar fichero
    }//de main

    //Inserci�n de los datos del empleado
    static void  CrearElemento(String datoEmple, String valor,
                               Element raiz, Document document){
        Element elem = document.createElement(datoEmple); //creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}//de la clase