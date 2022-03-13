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
import clases.Nodo;

@TestMethodOrder(OrderAnnotation.class)
class PruebasUnitarias {

	
	//assertEquals(resultadoEsperado, resultado);
	@Test
	@Order(1)
	void testInserir() throws FileNotFoundException {	//Caso lista vacia + Caso lista con elementos
		Lista listaPruebas = afegirDadesDeFitxer(10);
		System.out.print(listaPruebas+"\n");
		System.out.print(listaPruebas.toStringIterator()+"\n");
	}
	
	@Test
	@Order(2)
	void testInserirPos() throws FileNotFoundException {
		Lista listaPruebas = afegirDadesDeFitxer(4);
		listaPruebas.InserirPos(new Nodo(new Ciutada("Cristhian", "Fajado", "49978348S")), 0);	//Inserir en la primera posición
		System.out.print(listaPruebas+"\n");
		listaPruebas.InserirPos(new Nodo(new Ciutada("Cristhian", "Fajado", "49978348S")), 5);
		System.out.print(listaPruebas+"\n");
		listaPruebas.InserirPos(new Nodo(new Ciutada("Cristhian", "Fajado", "49978348S")), 3);
		System.out.print(listaPruebas+"\n");
	}
	
	@Test
	@Order(3)
	void testObtenirCaso1() throws FileNotFoundException{	//Caso posicion inicial
		Lista listaPruebas = afegirDadesDeFitxer(4);
		Nodo n = (Nodo)listaPruebas.Obtenir(0);
		Ciutada resultatObtingut = n.getValor();
		Ciutada resultatEsperat = new Ciutada("Morgana","Sunners","57295964M");
		System.out.print(resultatEsperat.getDni()+" - "+ resultatObtingut.getDni()+"\n");
		assertEquals(resultatEsperat.getDni(), resultatObtingut.getDni());
	}
	
	@Test
	@Order(4)
	void testObtenirCaso2() throws FileNotFoundException{	//Caso posicion final
		Lista listaPruebas = afegirDadesDeFitxer(4);
		Nodo n = (Nodo)listaPruebas.Obtenir(3);
		Ciutada resultatObtingut = n.getValor();
		Ciutada resultatEsperat = new Ciutada("Chaddie","Clulee","19741348C");
		System.out.print(resultatEsperat.getDni()+" - "+ resultatObtingut.getDni()+"\n");
		assertEquals(resultatEsperat.getDni(), resultatObtingut.getDni());
	}
	
	@Test
	@Order(5)
	void testObtenirCaso3() throws FileNotFoundException{	//Caso posicion media
		Lista listaPruebas = afegirDadesDeFitxer(4);
		Nodo n = (Nodo)listaPruebas.Obtenir(2);
		Ciutada resultatObtingut = n.getValor();
		Ciutada resultatEsperat = new Ciutada("Fredek","Di Biaggi","62511696F");
		System.out.print(resultatEsperat.getDni()+" - "+ resultatObtingut.getDni()+"\n");
		assertEquals(resultatEsperat.getDni(), resultatObtingut.getDni());
	}
	
	@Test
	@Order(6)
	void testObtenirCaso4() throws FileNotFoundException{	//Caso posicion Out of range
		Lista listaPruebas = afegirDadesDeFitxer(4);
		boolean resultatObtingut= (boolean)listaPruebas.Obtenir(50);
		boolean resultatEsperat = false;
		assertEquals(resultatEsperat, resultatObtingut);
	}
	
	@Test
	@Order(7)
	void testEsborrarCaso1() throws FileNotFoundException{	//Caso posicion inicial
		Lista listaPruebas = afegirDadesDeFitxer(10);
		boolean resultatObtingut= listaPruebas.Esborrar(0);
		boolean resultatEsperat = true;
		System.out.print("\n"+listaPruebas);
		assertEquals(resultatEsperat, resultatObtingut);
	}
	
	@Test
	@Order(8)
	void testEsborrarCaso2() throws FileNotFoundException{	//Caso posicion Final
		Lista listaPruebas = afegirDadesDeFitxer(10);
		boolean resultatObtingut= listaPruebas.Esborrar(9);
		boolean resultatEsperat = true;
		System.out.print("\n"+listaPruebas);
		assertEquals(resultatEsperat, resultatObtingut);
	}
	
	@Test
	@Order(9)
	void testEsborrarCaso3() throws FileNotFoundException{	//Caso posicion media
		Lista listaPruebas = afegirDadesDeFitxer(10);
		boolean resultatObtingut= listaPruebas.Esborrar(4);
		boolean resultatEsperat = true;
		System.out.print("\n"+listaPruebas);
		assertEquals(resultatEsperat, resultatObtingut);
	}
	
	@Test
	@Order(10)
	void testEsborrarCaso4() throws FileNotFoundException{	//Caso posicion imposible
		Lista listaPruebas = afegirDadesDeFitxer(10);
		boolean resultatObtingut= listaPruebas.Esborrar(-3);
		boolean resultatEsperat = false;
		System.out.print("\n"+listaPruebas);
		assertEquals(resultatEsperat, resultatObtingut);
	}
	
	@Test
	@Order(11)
	void testBuscarCaso1() throws FileNotFoundException{	//Caso primer elemento
		Lista listaPruebas = afegirDadesDeFitxer(10);
		int costeObtenido = listaPruebas.Buscar(new Nodo(new Ciutada("Morgana","Sunners","57295964M")));
		int costeEsperado = 1;
		System.out.println(costeObtenido);
		assertEquals(costeEsperado, costeObtenido);
	}
	
	@Test
	@Order(12)
	void testBuscarCaso2() throws FileNotFoundException{	//Caso elemento final
		Lista listaPruebas = afegirDadesDeFitxer(10);
		int costeObtenido = listaPruebas.Buscar(new Nodo(new Ciutada("Sonnnie","Mauchline","61199141S")));
		int costeEsperado = 10;
		System.out.println(costeObtenido);
		assertEquals(costeEsperado, costeObtenido);
	}
	
	@Test
	@Order(13)
	void testBuscarCaso3() throws FileNotFoundException{	//Caso elemento enmedio
		Lista listaPruebas = afegirDadesDeFitxer(10);
		int costeObtenido = listaPruebas.Buscar(new Nodo(new Ciutada("Chaddie","Clulee","19741348C")));
		int costeEsperado = 4;
		System.out.println(costeObtenido);
		assertEquals(costeEsperado, costeObtenido);
	}
	
	@Test
	@Order(14)
	void testBuscarCaso4() throws FileNotFoundException{	//Caso elemento no encontrado
		Lista listaPruebas = afegirDadesDeFitxer(10);
		int costeObtenido = listaPruebas.Buscar(new Nodo(new Ciutada("Cristhian","Sunners","49384729S")));
		int costeEsperado = 10;
		System.out.println(costeObtenido);
		assertEquals(costeEsperado, costeObtenido);
	}
	
	
	
	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 100)
			nLinies = 100;
		
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
		for (int i = 0; i < fichero.length; i++) {
			String[] ficheroSplit = fichero[i].split(",");
			lista.Inserir(new Nodo(new Ciutada(ficheroSplit[0], ficheroSplit[1], ficheroSplit[2] + ficheroSplit[3])));
		}
		return lista;
	}
	
}
