package clases;

import tads.TadCiutada;

public class Ciutada implements TadCiutada, Comparable<Object>{
	
	private String nom;
	private String cognom;
	private String dni;
	
	public Ciutada(String nom, String cognom, String dni) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.dni = dni;
	}


	@Override
	public int compareTo(Object o) {	//Devuelve 0 si son iguales -1 si son diferentes
		Ciutada c = (Ciutada)o;
		if(this.getDni().equalsIgnoreCase(c.getDni()))
			return 0;
		return -1;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCognom() {
		return cognom;
	}


	public void setCognom(String cognom) {
		this.cognom = cognom;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	
}
