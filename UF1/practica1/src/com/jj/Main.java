package com.jj;

import com.thoughtworks.xstream.XStream;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;

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

    public static List<Elemento> listaElemento = new ArrayList<>();

    public static void bloquejarPantalla() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("Toca 'C' per a continuar ");
        while (in.hasNext()) {
            if ("C".equalsIgnoreCase(in.next())) break;
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, TransformerException, ParserConfigurationException {

        Scanner scanner = new Scanner(System.in);
        String opcio = "";
        do {
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
            System.out.print("opcio seleccionada: ");
            opcio = scanner.nextLine();

            switch (opcio) {
                case "1":
                    introduirDades();
                    bloquejarPantalla();
                    break;
                case "2":
                    llistaDades();
                    bloquejarPantalla();

                    break;
                case "3":
                    guardarBinari();
                    bloquejarPantalla();

                    break;
                case "4":
                    crearXml();
                    bloquejarPantalla();

                    break;
                case "5":
                    llegirBInari();
                    bloquejarPantalla();

                    break;
                case "6":
                    llegirDadesXml();
                    bloquejarPantalla();

                    break;
                case "7":

                    break;
                default:
                    System.out.println("ERROR: COMANDA NO RECONEGUDA");
                    System.out.println();
                    break;

            }
        } while (!opcio.equals("7"));


    }


    public static void llistaDades() {
        PriorityQueue<String> nausOrdenades = new PriorityQueue<>();


        for (Elemento datos : listaElemento) {
            System.out.println("=======================================");
            System.out.println("id:        " + datos.getId());
            System.out.println("any:       " + datos.getAnyo());
            System.out.println("temporada: " + datos.getTemporada());
            System.out.println("thumb:    " + datos.getImagen());
        }

    }

    public static void llegirDadesXml() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documentoXML = builder.parse(new File("Elementos.xml"));
            documentoXML.getDocumentElement().normalize();

            System.out.println("Elemento raiz: " + documentoXML.getDocumentElement().getNodeName());

            NodeList empleados = documentoXML.getElementsByTagName("fila");

            for (int i = 0; i < empleados.getLength(); i++) {

                Node emple = empleados.item(i);

                if (emple.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) emple;

                    System.out.println(elemento.getNodeType() == Element.ELEMENT_NODE);

                    System.out.println("ID: " + getNodo("id", elemento));
                    System.out.println("Apellido: " + getNodo("ano", elemento));
                    System.out.println("Departamento: " + getNodo("temporada", elemento));
                    System.out.println("Salario: " + getNodo("thumb", elemento));
                    System.out.println("=======================================");

                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("oh, oh! Hubo un problema" + e.getMessage() + " - " + e.toString());
        }
    }

    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }


    public static void introduirDades() {
        Scanner sc = new Scanner(System.in);
        String intDados;

        System.out.println("id:        ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("año:       ");
        String ano = sc.nextLine();
        System.out.println("temporada: ");
        String temporada = sc.nextLine();
        System.out.println("thumb:    ");
        String thumb = sc.nextLine();
        listaElemento.add(new Elemento(id, ano, temporada, thumb));
    }


    public static void guardarBinari() throws IOException {

        File fichero = new File("listaElementos.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        DataOutputStream dataOS = new DataOutputStream(fileout);

        for (Elemento datos : listaElemento) {
            dataOS.writeInt(datos.getId());
            dataOS.writeUTF(datos.getAnyo());
            dataOS.writeUTF(datos.getTemporada());
            dataOS.writeUTF(datos.getImagen());
        }
        dataOS.close();
    }


    public static void llegirBInari() throws IOException {

        File fichero = new File("listaElementos.dat");
        FileInputStream fileout = new FileInputStream(fichero);
        DataInputStream dataOS = new DataInputStream(fileout);

        for (Elemento datos : listaElemento) {
            System.out.println("=======================================");
            System.out.println
                    ("id:        " + dataOS.readInt() + "\nany:       " + dataOS.readUTF() +
                            "\ntemporada: " + dataOS.readUTF() + "\nthumb:    " + dataOS.readUTF());
        }
        dataOS.close();
    }



    public static void crearXml() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        DOMImplementation domImplementation = builder.getDOMImplementation();
        Document document = domImplementation.createDocument(null, "Empleados", null);
        document.setXmlVersion("1.0"); // asignamos la version de nuestro XML

        int id;
        String ano, temporada, thumb;
        for (Elemento elemento : listaElemento)
        {
            id =elemento.getId();
            ano= elemento.getAnyo();
            temporada = elemento.getTemporada();
            thumb = elemento.getImagen();
            Element arrel =  document.createElement("fila");
            document.getDocumentElement().appendChild((Node) arrel);

            crearElemento("id", String.valueOf(id).trim(), (Element) arrel,document);
            crearElemento("ano", ano.trim(), (Element) arrel,document);
            crearElemento("temporada", temporada.trim(), (Element) arrel,document);
            crearElemento("thumb", thumb.trim(), (Element) arrel,document);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("Elementos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console= new StreamResult(System.out);
            transformer.transform(source, console);

        }


    }
    static void  crearElemento(String datoEmple, String valor,
                               Element raiz, Document document){
        Element elem = document.createElement(datoEmple); //creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}



