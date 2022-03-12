package mainPKG;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import clases.*;
public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Inserir funciona
		//InserirPos funciona
		//Obtenir funciona
		//Buscar funciona
		//Eliminar funciona
		
		Lista listaEnlazada = afegirDadesDeFitxer(20);
		//listaEnlazada.Inserir(new Nodo(new Ciutada("a","a","dato1")));
		//listaEnlazada.Inserir(new Nodo(new Ciutada("a","a","dato2")));
		//listaEnlazada.Inserir(new Nodo(new Ciutada("a","a","dato3")));
		//listaEnlazada.Inserir(new Nodo(new Ciutada("a","a","dato4")));
		//listaEnlazada.InserirPos(new Nodo(new Ciutada("a","a","nuevo dato 2")),1);
		//System.out.print(listaEnlazada);
		//System.out.print(listaEnlazada.Obtenir(5)+"\n");
		//System.out.print(listaEnlazada.Buscar(new Nodo(new Ciutada("a","a","dato2")))+"\n");
		//listaEnlazada.Esborrar(2);
		System.out.print(listaEnlazada);
		

	}
	
	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 10000)
			nLinies = 10000;
		result = new String[nLinies];
		Scanner f = new Scanner(new File("CiutadansED.csv"));
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}
	
	private static Lista afegirDadesDeFitxer(int linies) throws FileNotFoundException {
		Lista lista = new Lista();
		String[] fichero = llegirLiniesFitxer(linies);
		for (int i = 0; i < linies; i++) {
			String[] ficheroSplit = fichero[i].split(",");
			lista.Inserir(new Nodo(new Ciutada(ficheroSplit[0],ficheroSplit[1],ficheroSplit[2]+ficheroSplit[3])));
		}
		return lista;
	}
}
