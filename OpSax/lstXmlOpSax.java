package e7.stXml.OpSax;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class lstXmlOpSax {

	static GestionContenido gestor;//Creo una variable aqui

	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {

		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		gestor = new GestionContenido();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("test/produkte.xml");
		procesadorXML.parse(fileXML);
		//son para la seleccion del menu ###
		Scanner sc = new Scanner(System.in);
		String op = "m";
		int selection = 0;
		boolean run;
		//########
		do {

			/*
			 * llamo al metodo para listar los cursos lstElements() 
			 * le paso indic y le digo si necesito o no recorrer
			 * todo el bucle
			 */

			lstElements(0, run = true);
			System.out.println();
			System.out.println("Indique el numero del curso al que quiere acceder o presione q para salir");
			op = sc.next();
			/*
			 * compruevo si op es numerico y si lo es parsea y comprueba que este dentro del
			 * rango de opciones
			 */
			if (isNumeric(op)) {
				selection = Integer.parseInt(op);
				if (selection < 20 && selection != 0) {
					/*
					 * llama al metodo para listar los nodos lstElements() y esta vez le digo que no
					 * quiero que recorra todo el array.
					 */					
					lstElements(selection, run = false);
				}else {System.out.println("selecione un numero de la lista.");}
				oneMomentpls();
			}
		} while (!op.equals("q"));
		System.out.println(" Goodby (^_^)V");
	}

	private static void lstElements(int selec, boolean run) {
		System.out.println();
		int i = 0;
		ArrayList<Cursos> todosLosCuros = gestor.todosLosCuros;

		for (Cursos curs : todosLosCuros) {
			if (!run) {
				System.out.println(todosLosCuros.get(selec).getNameCurso());
				System.out.println("\n"+todosLosCuros.get(selec).getDescCurso());
				return;
			}
			if (curs.getDescCurso() == "Titulo") {
				System.out.println("  " + curs.getNameCurso());
				System.out.println("----------------------------------");
			} else
				System.out.println(i + ") " + curs.getNameCurso());
			i++;
		}
	}
//#### seleccion del menu ########## 
	public static void oneMomentpls() {
		String seguir;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Press Enter key to continue...");
		try {
			seguir = teclado.nextLine();
		} catch (Exception e) {
		}
	}

	public static boolean isNumeric(String cadena) {
		boolean resultado;
		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}
		return resultado;
	}
//###############
}
//relacionado con la selecion de elemento del metodo lstElements
class GestionContenido extends DefaultHandler {
	Cursos curso;
	ArrayList<Cursos> todosLosCuros = new ArrayList<Cursos>();

	public GestionContenido() {
		super();
	}

	public void startElement(String uri, String nombre, String nombreC, Attributes atts) {

		if (atts.getValue("type") != null) {
			if (atts.getValue("text") == null) {
				curso = new Cursos(atts.getValue("header"), "Titulo");
				todosLosCuros.add(curso);
			} else {
				curso = new Cursos(atts.getValue("header"), atts.getValue("text"));
				todosLosCuros.add(curso);
			}
		}
	}

}

