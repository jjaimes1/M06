package e8.Xml.Serial;

import java.io.Serializable;

public class Departamento implements Serializable {
	private String name_dpt;
	private String location_dpt;
	private int num_dpt;


	public Departamento(String nombre, String localidad, int n_dpt) {
		this.name_dpt = nombre;
		this.location_dpt = localidad;
		this.num_dpt = n_dpt;
	}

	public void setName_dpt(String name) {
		name_dpt = name;
	}

	public String getName_dpt() {
		return name_dpt;
	}

	public void setLocation_dpt(String location) {
		location_dpt = location;
	}

	public String getLocation_dpt() {
		return location_dpt;
	}

	public void setNum_dpt(int num) {
		num_dpt = num;
	}

	public int getNum_dpt() {
		return num_dpt;
	}

}
