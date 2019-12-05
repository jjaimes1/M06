package e8.Xml.Serial;

import java.util.ArrayList;
import java.util.List;

public class ListaDepartamento {

	private List<Departamento> lista = new ArrayList<Departamento>();

	public ListaDepartamento() {
	}

	public void add(Departamento per) {
		lista.add(per);
	}

	public List<Departamento> getListaDepartamento() {
		return lista;
	}
}
