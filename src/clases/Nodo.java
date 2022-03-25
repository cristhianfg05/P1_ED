package clases;

import java.util.Iterator;

import tads.TadNodo;

public class Nodo implements TadNodo, Iterator<Nodo>{ 
	private Ciutada c;
	private Nodo seg;
	private Nodo ant;
	
	
	
	public Nodo(Ciutada c) {
		super();
		this.c = c;
	}
	@Override
	public Nodo getSeg() {
		return this.seg;
	}
	@Override
	public Nodo getAnt() {
		return this.ant;
	}
	@Override
	public Ciutada getValor() {
		return this.c;
	}
	@Override
	public void setSeg(Object nodo) {
		Nodo n = (Nodo) nodo;
		this.seg = n;
		
	}
	@Override
	public void setAnt(Object nodo) {
		Nodo n = (Nodo) nodo;
		this.ant = n;
		
	}
	@Override
	public boolean hasNext() {
		return this.getSeg() != null;
	}
	@Override
	public Nodo next() {
		return this.getSeg();
	}
	@Override
	public String toString() {
		return "Ciutada "+c.getNom()+" "+c.getCognom()+" "+c.getDni();
	}


	
	
	
}
