
package com.jj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class wFichObjectDat {
	public static void main(String[] args) throws IOException {

		Departamento departamento;

		File fichero = new File("FichDepartamento.dat");
		FileOutputStream fileout = new FileOutputStream(fichero, true);

		ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

		String nombres[] = { "INFORMATICA", "MARKETING", "CONTABILIDAD", "VENTAS", "COMPRAS", "PERSONAL", "RECURSOS",
				"ADMINISTRACION", "ECONOMIA" };
		String localidades[] = { "MADRID", "SEVILLA", "LEON", "TOLEDO", "GUADALAJARA", "CUENCA", "OVIEDO", "BILBAO",
				"VALENCIA" };
		int n_dpt[] = { 10, 15, 20, 25, 30, 35, 40, 45, 50 };

		for (int i = 0; i < n_dpt.length; i++) {
			departamento = new Departamento(nombres[i], localidades[i], n_dpt[i]);
			dataOS.writeObject(departamento);
		}
		dataOS.close();
	}
}