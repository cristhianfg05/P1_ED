package clases;

import java.util.Iterator;

import tads.TadLlista;

public class Lista implements TadLlista<Object>, Iterable<Nodo> {

	private Nodo nodoInicial; // Nodo inicial que no se puede perder (posicion 0 de la lista)
	private Nodo nodoActual; // Nodo que usaremos para viajar por la lista
	private int longitudLista;

	@Override
	public void Crear() {
		this.longitudLista = 0;
	}

	@Override
	public void Inserir(Object Ob) {
		Nodo nuevoNodo = (Nodo) Ob;
		if (this.longitudLista == 0) { // Caso lista vacia añadimos a la primera posicion
			this.nodoInicial = nuevoNodo;
			this.nodoActual = nuevoNodo;
			this.longitudLista++;
		} else { // Caso lista con Nodos recorremos hasta el ultimo elemento
			this.nodoActual = this.nodoInicial;
			for (int i = 0; i < this.longitudLista; i++) {
				this.nodoActual = this.nodoActual.getSeg();
			}
			this.nodoActual.setSeg(nuevoNodo);
			this.nodoActual.getSeg().setAnt(this.nodoActual);
			this.longitudLista++;
		}

	}

	@Override
	public void InserirPos(Object Ob, int pos) {
		// TODO Auto-generated method stub
	}

	@Override
	public Object Obtenir(int pos) { // Pos {0,1,2,...,nElem}
		if (pos < this.longitudLista) {
			int i = 0;
			this.nodoActual = this.nodoInicial;
			while (i < pos) {
				this.nodoActual = this.nodoActual.getSeg();
				i++;
			}

			return this.nodoActual;
		}else
			return null;
	}

	@Override
	public int Longitud() {
		return this.longitudLista;
	}

	@Override
	public void Esborrar(int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public int Buscar(Object data) {
		if(this.longitudLista == 0) {
			return 0;
		}else {
			Nodo dataNodo = (Nodo) data;
			this.nodoActual = this.nodoInicial;
			int i = 0;
			boolean trobat = false;
			while(i<this.longitudLista && !trobat) {
				this.nodoActual = this.nodoActual.getSeg();
				if(dataNodo.equals(this.nodoActual)) {
					trobat = true;
				}
			}
			return i;
		}
	}

	@Override
	public Iterator<Nodo> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
