package jUnit;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import clases.Ciutada;
import clases.Lista;
import clases.ListaHash;
import clases.Nodo;

@TestMethodOrder(OrderAnnotation.class)

class PruebasUnitarias2 {

	@Test
	@Order(1)
	void test() {
		
	}

	private static ListaHash afegirDadesDeFitxer2(int linies) throws FileNotFoundException {
		ListaHash lista = new ListaHash(linies + 10);
		String[] fichero = llegirLiniesFitxer(linies);
		for (int i = 0; i < fichero.length; i++) {
			String[] ficheroSplit = fichero[i].split(",");
			lista.Inserir(ficheroSplit[0], ficheroSplit[1], ficheroSplit[2]);
		}
		return lista;
	}
	
	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 100)
			nLinies = 100;
		
		System.out.print(nLinies);
		result = new String[nLinies];
		Scanner f = new Scanner(new File("CiutadansED.csv"));
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}
	
}
