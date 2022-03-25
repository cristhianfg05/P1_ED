package clases;

import tads.TadListaHash;

public class ListaHash implements TadListaHash<Object, Object> {

	//En toda la practica utilizaré 5 como valor m para hacer el calculo de la posicion
	private NodoHash lista[];
	private int elems;

	public ListaHash(int dim) {
		super();
		this.lista = new NodoHash[dim];
		this.elems = 0;
	}

	@Override
	public void Inserir(Object key, Object value, Object value2) {
		//Calculamos el factor de carga
		float carga = ObtenirFactorCarrega();
		
		if(carga > 0.75) {
			Redimensionar();
		}
		
		//Calculamos posicion
		int pos = Xor((String)key) % elems;
		
		if(this.lista[pos] == null) {
			this.lista[pos] = new NodoHash(new Ciutada((String)key,(String)value,(String)value2));
		}else {
			NodoHash actual = this.lista[pos];
			//Añadir if existe (metodo a crear) si existe modifico sino me jodo y lo añado
			while(actual.getSeg() != null) {
				actual = actual.getSeg();
			}
			actual.setSeg(new NodoHash(new Ciutada((String)key,(String)value,(String)value2)));
		}
	}

	@Override
	public Object Obtenir(Object key) {
		int pos = Xor((String)key) % elems;
		boolean trobat = false;
		NodoHash actual = this.lista[pos];
		while(!trobat) {
			if(actual.getValor().getDni().equalsIgnoreCase((String)key)) {
				trobat = true;
			}else {
				actual = actual.getSeg();
			}
		}
		if(trobat)
			return actual.getValor();
		else
			return false;
	}

	@Override
	public int Buscar(Object key) {
		int cost = 0;
		int pos = Xor((String)key) % elems;
		boolean trobat = false;
		NodoHash actual = this.lista[pos];
		while(!trobat) {
			if(actual.getValor().getDni().equalsIgnoreCase((String)key)) {
				trobat = true;
			}else {
				actual = actual.getSeg();
			}
			cost++;
		}
		if(!trobat)
			System.out.print("\nElemento no encontrado");
		return cost;
	}

	@Override
	public int Mida() {
		return this.elems;
	}

	@Override
	public void Esborrar(Object key) {
		int pos = Xor((String)key) % elems;
		boolean trobat = false;
		NodoHash actual = this.lista[pos];
		while(!trobat) {
			if(actual.getValor().getDni().equalsIgnoreCase((String)key)) {
				trobat = true;
			}else {
				actual = actual.getSeg();
			}
		}
		

	}

	@Override
	public Object[] ObtenirValors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] ObtenirKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float ObtenirFactorCarrega() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void Redimensionar() {

	}
	
	private int Xor(String palabra) {
		int valor = 0;
		for (int i = 0; i < palabra.length(); i++) {
			valor = valor + palabra.charAt(i);
		}
		String bin = Integer.toBinaryString(valor);
		int n = 1;
		for (int i = 0; i < bin.length(); i++) {
			n = n ^ Integer.valueOf(bin);
		}
		return n;
	}

}
