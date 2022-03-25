package tads;

import clases.NodoHash;

public interface TadNodoHash<T> {
	NodoHash getSeg();
	T getValor();
	void setSeg(T nod);
	String toString();
	
}
