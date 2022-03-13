package clases;

import tads.TadLlista;

public class Lista implements TadLlista<Object> {

	private Nodo nodoInicial; // Nodo inicial que no se puede perder (posicion 0 de la lista)
	private Nodo nodoFinal; // Nodo final que tenemos que actualizar con cada inserción normal (posicion
							// nElem de la lsita)
	private int longitudLista;

	public Lista() {
		this.longitudLista = 0;
	}

	@Override
	public void Inserir(Object Ob) {
		Nodo nuevoNodo = (Nodo) Ob;
		if (this.longitudLista == 0) { // Caso lista vacia añadimos a la primera posicion
			this.nodoInicial = nuevoNodo;
			this.nodoFinal = nuevoNodo;
			this.longitudLista++;
		} else { // Caso lista con Nodos añadimos el nodo en el final
			this.nodoFinal.setSeg(nuevoNodo);
			this.nodoFinal.getSeg().setAnt(this.nodoFinal);
			this.nodoFinal = this.nodoFinal.getSeg();
			this.longitudLista++;
		}

	}

	@Override
	public boolean InserirPos(Object Ob, int pos) { // Insertar elemento en posicion pos {0,1,...,nElem-1}
		Nodo nuevoNodo = (Nodo) Ob;
		if (this.longitudLista == 0 && pos != 0) { // Caso 1: lista vacia
			return false;
		} else if (pos > this.longitudLista) {
			return false;
		} else if (pos == 0 && this.longitudLista == 0) {	//Caso 2 lista vacia posicion inicial
			this.nodoInicial = nuevoNodo;
			this.nodoFinal = nuevoNodo;
			this.longitudLista++;
		} else if (pos == 0) { // Caso 3 posicion inicial con nodos
			this.nodoInicial.setAnt(nuevoNodo);
			this.nodoInicial.getAnt().setSeg(this.nodoInicial);
			this.nodoInicial = nuevoNodo;
			this.longitudLista++;
		} else if (pos == this.longitudLista && this.longitudLista > 2) { // Caso 4 posicion final si la lista tiene mas
																			// de 2 elementos
			this.nodoFinal.setSeg(nuevoNodo);
			this.nodoFinal.getSeg().setAnt(this.nodoFinal);
			this.nodoFinal = this.nodoFinal.getSeg();
			this.longitudLista++;
		} else { // Caso 5 posicion intermedia
			Nodo nodoActual = this.nodoInicial;
			for (int i = 0; i < pos - 1; i++) {
				nodoActual = nodoActual.getSeg();
			}
			nodoActual.getSeg().setAnt(nuevoNodo);
			Nodo nodoAux = nodoActual.getSeg();
			nodoActual.setSeg(nuevoNodo);
			nodoActual.getSeg().setAnt(nodoActual);
			nodoActual.getSeg().setSeg(nodoAux);
			this.longitudLista++;
		}
		return true;
	}

	@Override
	public Object Obtenir(int pos) { // Pos {0,1,2,...,nElem-1}
		if (pos < this.longitudLista && pos >= 0) {
			if (pos == 0) // Caso 1 posicion 1
				return nodoInicial;
			else if (pos == longitudLista - 1) // Caso 2 posicion final
				return nodoFinal;

			int i = 0; // Caso 3 posicion intermedia
			Nodo nodoActual = this.nodoInicial;
			while (i < pos) {
				nodoActual = nodoActual.getSeg();
				i++;
			}

			return nodoActual;
		} else
			return false;
	}

	@Override
	public int Longitud() {
		return this.longitudLista;
	}

	@Override
	public boolean Esborrar(int pos) { // Eliminar elemento de la posicion pos {0,1,...,nElem-1}
		if (pos > this.longitudLista - 1 || pos < 0 || this.longitudLista == 0)
			return false;
		else if (pos == this.longitudLista - 1) { // Ultima posición a borrar (caso especifico)
			this.nodoFinal = this.nodoFinal.getAnt();
			this.longitudLista--;
		} else if (pos == 0) { // Primera posicion a borrar (caso especifico)
			this.nodoInicial = this.nodoInicial.getSeg();
			this.longitudLista--;
		} else { // Posición intermedia (caso basico)
			Nodo nodoActual = this.nodoInicial;
			for (int i = 0; i < pos - 1; i++) // Avanzo hasta pos-1 para ponerme en el primer nodo a modificar
				nodoActual = nodoActual.getSeg();

			nodoActual.setSeg(nodoActual.getSeg().getSeg());
			nodoActual.getSeg().setAnt(nodoActual);
			this.longitudLista--;
		}
		return true;
	}

	@Override
	public int Buscar(Object data) {
		if (this.longitudLista == 0) {
			return 0;
		} else {
			Nodo dataNodo = (Nodo) data;
			Nodo nodoActual = this.nodoInicial;
			int i = 0;
			boolean trobat = false;
			while (i < this.longitudLista && !trobat) {

				if (dataNodo.getValor().compareTo(nodoActual.getValor()) == 0) {
					trobat = true;
				} else {
					i++;
					nodoActual = nodoActual.getSeg();
				}

			}
			System.out.print("Elemento encontrado? " + trobat + "\n");
			// Devuelve el costo / elementos recorridos lo haya encontrado o no
			if (trobat)
				return i + 1;
			else
				return i;
		}
	}

	@Override
	public String toString() {
		String concat = "";
		Nodo nodoActual = this.nodoInicial;
		for (int i = 0; i < longitudLista; i++) {
			concat = concat + nodoActual.getValor().getNom() + " " 
					+ nodoActual.getValor().getCognom() + " DNI: "
					+ nodoActual.getValor().getDni() + "\n";
			nodoActual = nodoActual.getSeg();
		}
		return concat;
	}

	@Override
	public String toStringIterator() {
		String concat = "";
		Nodo nodoActual = this.nodoInicial;
		while (nodoActual.hasNext()) {
			concat = concat + nodoActual.getValor().getNom() + " " 
					+ nodoActual.getValor().getCognom() + " DNI: "
					+ nodoActual.getValor().getDni() + "\n";
			nodoActual = nodoActual.next();
		}
		concat = concat + nodoActual.getValor().getNom() + " " 
				+ nodoActual.getValor().getCognom() + " DNI: "
				+ nodoActual.getValor().getDni() + "\n";
		return concat;
	}

}
