package com.jj;

public class Cursos {

	private String nameCurso;
	private String descripcion;

	public Cursos(String curso, String descripcion) {
		this.nameCurso = curso;
		this.descripcion = descripcion;
	}
	public String getNameCurso() {
		return nameCurso;
	}
	public String getDescCurso() {
		return descripcion;
	}
	public void setNameCurso(String nameCurso) {
		this.nameCurso = nameCurso;
	}
	public void setDescCurso(String descripcion) {
		this.descripcion = descripcion;
	}
}
