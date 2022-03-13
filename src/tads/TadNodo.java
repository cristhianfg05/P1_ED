package tads;

import clases.Nodo;

public interface TadNodo<T>{
	Nodo getSeg();
	Nodo getAnt();
	T getValor();
	void setSeg(T nodo);
	void setAnt(T nodo);
	String toString();
}

