package clases;


import tads.TadLlista;

public class Lista implements TadLlista<Object>{

	private Nodo nodoInicial;	// Nodo inicial que no se puede perder (posicion 0 de la lista)
	private Nodo nodoFinal;		//Nodo final que tenemos que actualizar con cada inserción normal (posicion nElem de la lsita)
	private Nodo nodoActual;	// Nodo que usaremos para viajar por la lista
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
			this.nodoActual = nuevoNodo;
			this.longitudLista++;
		} else { // Caso lista con Nodos añadimos el nodo en el final
			this.nodoFinal.setSeg(nuevoNodo);
			this.nodoFinal.getSeg().setAnt(this.nodoFinal);
			this.nodoFinal = this.nodoFinal.getSeg();
			this.longitudLista++;
		}

	}

	@Override
	public boolean InserirPos(Object Ob, int pos) {	//Insertar elemento en posicion pos {0,1,...,nElem-1}
		Nodo nuevoNodo = (Nodo) Ob;
		if(this.longitudLista == 0) {	//Caso 1: lista vacia
			return false;
		}else if(pos > this.longitudLista-1) {
			return false;
		}else if(pos == 0){	//Caso 2 posicion inicial
			this.nodoInicial.setAnt(nuevoNodo);
			this.nodoInicial.getAnt().setSeg(this.nodoInicial);
			this.nodoInicial = nuevoNodo;	
			this.longitudLista++;
		}else if(pos == this.longitudLista -1) { //Caso 3 posicion final
			this.nodoFinal.setSeg(nuevoNodo);
			this.nodoFinal.getSeg().setAnt(this.nodoFinal);
			this.nodoFinal = this.nodoFinal.getSeg();
			this.longitudLista++;
		}else {	//Caso 4 posicion intermedia
			this.nodoActual = this.nodoInicial;
			for (int i = 0; i < pos; i++) {
				this.nodoActual = this.nodoActual.getSeg();
			}
			this.nodoActual.getSeg().setAnt(nuevoNodo);
			Nodo nodoAux = this.nodoActual.getSeg();
			this.nodoActual.setSeg(nuevoNodo);
			this.nodoActual.getSeg().setAnt(this.nodoActual);
			this.nodoActual.getSeg().setSeg(nodoAux);
		}
		return true;
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
			return false;
	}

	@Override
	public int Longitud() {
		return this.longitudLista;
	}

	@Override
	public boolean Esborrar(int pos) {	//Eliminar elemento de la posicion pos {0,1,...,nElem-1}
		if(pos > this.longitudLista -1 || pos < 0)
			return false;
		else if(pos == this.longitudLista-1){	//Ultima posición a borrar (caso especifico)
			this.nodoFinal = this.nodoFinal.getAnt();
			this.longitudLista--;
		}else if(pos == 0) {	//Primera posicion a borrar (caso especifico)
			this.nodoInicial = this.nodoInicial.getSeg();
			this.longitudLista--;
		}else {	//Posición intermedia (caso basico)
			this.nodoActual = this.nodoInicial;
			for (int i = 0; i < pos; i++)	//Avanzo hasta pos-1 para ponerme en el primer nodo a modificar
				this.nodoActual = this.nodoActual.getSeg();
			
			this.nodoActual.setSeg(this.nodoActual.getSeg().getSeg());
			this.nodoActual.getSeg().setAnt(nodoActual);
			this.longitudLista--;
		}
		return true;
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
			System.out.print("Elemento encontrado? "+trobat);
			//Devuelve el costo / elementos recorridos lo haya encontrado o no
			return i;	 
		}
	}


}
