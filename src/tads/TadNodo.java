package tads;

import clases.Nodo;

public interface TadNodo<T>{
	Nodo getSeg();
	Nodo getAnt();
	T getValor();
	
}
