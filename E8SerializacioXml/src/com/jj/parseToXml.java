package com.jj;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;

public class parseToXml {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File fichero = new File("FichDepartamento.dat");
		FileInputStream filein = new FileInputStream(fichero);

		ObjectInputStream dataIS = new ObjectInputStream(filein);
		System.out.println("Comienza el proceso de fichero a XML ...");

		ListaDepartamento listadpt = new ListaDepartamento();

		Departamento departamento;
		int i = 1;
		try {
			while (true) {
				departamento = (Departamento) dataIS.readObject();

				System.out.println(i + ") Departamento de " + departamento.getName_dpt() + " numero "
						+ departamento.getNum_dpt() + " localidad de " + departamento.getLocation_dpt() + ".");

				i++;

				listadpt.add(departamento);
			}
		} catch (EOFException eo) {
		}
		dataIS.close();
		try {
			XStream xstream = new XStream();
			// cambiar de nombre a las etiquetas XML
			xstream.alias("Departamentos", ListaDepartamento.class);
			xstream.alias("departamento", Departamento.class);
			xstream.aliasField( "nom", Departamento.class, "name_dpt");
			xstream.aliasField( "local", Departamento.class, "location_dpt");
			xstream.aliasField( "Dep", Departamento.class, "num_dpt");
			// quitar etiwueta lista (atributo de la clase ListaPersonas)
			//xstream.addImplicitCollection(ListaDepartamento.class, "lista");
			// Insrtar los objetos en el XML
			xstream.toXML(listadpt, new FileOutputStream("Departamentos.xml"));
			System.out.println("Creado fichero XML....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
