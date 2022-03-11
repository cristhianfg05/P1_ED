package mainPKG;

import tads.*;
import clases.*;
public class main {

	public static void main(String[] args) {
		
		Lista listaEnlazada = new Lista();
		listaEnlazada.Inserir(new Nodo(new Ciutada("a","a","123456S")));
		listaEnlazada.Inserir(new Nodo(new Ciutada("a","a","123456T")));
		listaEnlazada.Inserir(new Nodo(new Ciutada("a","a","123456U")));
		listaEnlazada.Inserir(new Nodo(new Ciutada("a","a","123456V")));
		listaEnlazada.InserirPos(new Nodo(new Ciutada("a","a","123456S")),2);
		System.out.print(listaEnlazada);

	}

}
