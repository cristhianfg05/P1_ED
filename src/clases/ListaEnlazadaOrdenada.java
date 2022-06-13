package clases;

import tads.TadLlista;

public class ListaEnlazadaOrdenada implements TadLlista<Object> {

	private Nodo nodoInicial;
	private Nodo nodoFinal;

	private int longitudLista;

	public ListaEnlazadaOrdenada() {
		this.longitudLista = 0;
	}

	// INSERTAR ORDENADO EXTRA PARA 10
	@Override
	public void Inserir(Object Ob) {
		Nodo nuevoNodo = (Nodo) Ob;
		if (this.longitudLista == 0) { // SI LA LISTA ESTA VACIA NO PODEMOS INSERTARLO DE MANERA ORDENADA
			this.nodoInicial = nuevoNodo;
			this.nodoFinal = nuevoNodo;
			this.longitudLista++;
			System.out.println("Primer ciudadano");
		} else { // SI HAY ALGUN ELEMENTO ORDENAMOS DE MANERA ALFABETICA
			Nodo nodoAux = nodoInicial;
			if (!nodoAux.hasNext()) {
				System.out.println("letra 1 " +nodoAux.getValor().getNom().charAt(0) +" letra 2 "+nuevoNodo.getValor().getNom().charAt(0));
				if (nodoAux.getValor().getNom().charAt(0) > nuevoNodo.getValor().getNom().charAt(0)) {
					this.nodoInicial.setAnt(nuevoNodo);
					this.nodoInicial.getAnt().setSeg(this.nodoInicial);
					this.nodoInicial = nuevoNodo;
					this.longitudLista++;
					System.out.println("Nuevo nodo en la primera posición");
				}else {
					this.nodoInicial.setSeg(nuevoNodo);
					nuevoNodo.setAnt(nodoInicial);
					nodoFinal = nuevoNodo;
					this.longitudLista++;
					System.out.println("Nuevo nodo en la segunda posición");
				}
			} else {
				if (nodoAux.hasNext()) {
					nodoAux = nodoAux.getSeg();
					boolean salida = false;
					while (nodoAux.hasNext() && !salida) {
						System.out.println("letra 1 " +nodoAux.getValor().getNom().charAt(0) +" letra 2 "+nuevoNodo.getValor().getNom().charAt(0));
						if (nodoAux.getValor().getNom().charAt(0) > nuevoNodo.getValor().getNom().charAt(0)) {
							nuevoNodo.setAnt(nodoAux.getAnt());
							nuevoNodo.setSeg(nodoAux);
							nodoAux.setAnt(nuevoNodo);
							nuevoNodo.getAnt().setSeg(nuevoNodo);
							longitudLista++;
							System.out.println("Nuevo nodo en la posicion intermedia");
							salida = true;
						}
						nodoAux = nodoAux.getSeg();
					}
					if (!salida) {
						if (nodoAux.getValor().getNom().charAt(0) > nuevoNodo.getValor().getNom().charAt(0)) {
							nuevoNodo.setAnt(nodoAux.getAnt());
							nuevoNodo.setSeg(nodoAux);
							nodoAux.setAnt(nuevoNodo);
							nuevoNodo.getAnt().setSeg(nuevoNodo);
							longitudLista++;
						}else {
							this.nodoFinal.setSeg(nuevoNodo);
							this.nodoFinal.getSeg().setAnt(this.nodoFinal);
							this.nodoFinal = this.nodoFinal.getSeg();
							this.longitudLista++;
							System.out.println("Nuevo nodo en la posicion intermedia 2");
						}
						
					}
				}

			}

		}

	}

	@Override
	public boolean InserirPos(Object Ob, int pos) { // Insertar elemento en posicion pos {0,1,...,nElem-1}
		Nodo nuevoNodo = (Nodo) Ob;
		if (this.longitudLista == 0 && pos != 0) { // Caso 1: lista vacia
			return false;
		} else if (pos > this.longitudLista) {
			return false;
		} else if (pos == 0 && this.longitudLista == 0) { // Caso 2 lista vacia posicion inicial
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
			concat = concat + nodoActual.getValor().getNom() + " " + nodoActual.getValor().getCognom() + " DNI: "
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
			concat = concat + nodoActual.getValor().getNom() + " " + nodoActual.getValor().getCognom() + " DNI: "
					+ nodoActual.getValor().getDni() + "\n";
			nodoActual = nodoActual.next();
		}
		concat = concat + nodoActual.getValor().getNom() + " " + nodoActual.getValor().getCognom() + " DNI: "
				+ nodoActual.getValor().getDni() + "\n";
		return concat;
	}

}
