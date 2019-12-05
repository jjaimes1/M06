package com.jj;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class LeerFichObject1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Departamento departamento;
		File fichero = new File("FichDepartamento.dat");
		FileInputStream filein = new FileInputStream(fichero);

		ObjectInputStream dataIS = new ObjectInputStream(filein);
		int i = 1;

		try {

			while (true) {
				departamento = (Departamento) dataIS.readObject();
				System.out.println(i + ") Departamento de " + departamento.getName_dpt() + " numero "
						+ departamento.getNum_dpt() + " localidad de " + departamento.getLocation_dpt()+".");

				i++;
			}

		} catch (EOFException eo) {
		} catch (StreamCorruptedException xy) {
		}
		dataIS.close();
	}
}