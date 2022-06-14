package mainPKG;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import clases.*;

public class main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		System.out.print("Cuantos ciudadanos del fichero quieres añadir? [0-100] ");
		
		ListaEnlazadaOrdenada listaEnlazada = afegirDadesDeFitxer(sc.nextInt());


		char opcion = 'a';

		while (opcion != '8') {
			System.out.print("\nMenú: \n" + "[1]Inserir Ciutadà a la lista\n"
					+ "[2]Inserir Ciutadà a la lista en posició especifica\n" + "[3]Obtenir dades Ciutadà\n"
					+ "[4]Buscar si existeix ciutadá + cost de la busqueda\n" + "[5]Eliminar Ciutadà\n"
					+ "[6]Longitud de la lista\n" + "[7]Imprimir lista completa\n" + "[8]Salir\n");

			opcion = sc.next().charAt(0);

			switch (opcion) {
			case '1':

				System.out.print("\nNom del nou ciutadà: ");
				String nom = sc.next();
				System.out.print("\nCognom del nou ciutadà: ");
				String cognom = sc.next();
				System.out.print("\nDNI del nou ciutadà: ");
				String dni = sc.next();
				listaEnlazada.Inserir(new Nodo(new Ciutada(nom, cognom, dni)));

				break;
			case '2':

				System.out.print("\nNom del nou ciutadà: ");
				nom = sc.next();
				System.out.print("\nCognom del nou ciutadà: ");
				cognom = sc.next();
				System.out.print("\nDNI del nou ciutadà: ");
				dni = sc.next();
				System.out.print("\nPosició del nou ciutadà: ");
				int pos = sc.nextInt();
				listaEnlazada.InserirPos(new Nodo(new Ciutada(nom, cognom, dni)), pos);

				break;
			case '3':

				System.out.print("\nPosició del ciutadà a obtenir: ");
				pos = sc.nextInt();

				if (listaEnlazada.Obtenir(pos) == (Object) false)
					System.out.print("Posicio no posible");
				else
					System.out.print(listaEnlazada.Obtenir(pos));

				break;
			case '4':

				System.out.print("\nNom del ciutadà a buscar: ");
				nom = sc.next();
				System.out.print("\nCognom ciutadà a buscar: ");
				cognom = sc.next();
				System.out.print("\nDNI del ciutadà a buscar: ");
				dni = sc.next();

				System.out.print("\nAquesta busqueda te un cost de "
						+ listaEnlazada.Buscar(new Nodo(new Ciutada(nom, cognom, dni))));

				break;
			case '5':

				System.out.print("\nPosició del ciutadà a eliminar: ");
				pos = sc.nextInt();
				System.out.print("\nCiutadà eliminat? " + listaEnlazada.Esborrar(pos));

				break;
			case '6':
				
				System.out.print("\nLa lista tiene "+listaEnlazada.Longitud()+" elementos");
				
				break;
			case '7':
				
				System.out.print(listaEnlazada);
				
				break;
			case '8':
				System.out.print("\nSaliendo...\n");
				break;
			default:
				System.out.print("\nOpcion invalida\n");
				break;
			}
		}
		
		/*Test de pruebas HASH MUCHOS ELEMENTOS*/
		ListaHash p = afegirDadesDeFitxer2(15); 	//Añade muchos elementos a la lista todos recogidos del CSV Generado en Mookaroo
		System.out.println(p);						//Imprimimos la lista completa
		System.out.println(p.ObtenirKeys());		//Recogemos todos los DNI
		System.out.println(p.ObtenirValors()[0]);	//Recogemos todos los nombres
		System.out.print(p.ObtenirValors()[1]);		//Recogemos todos los apellidos
		System.out.println(p.Buscar("57295964M"));	//Buscamos el primer elemento añadido (Obtenir y buscar tienen el mismo funcionamiento por lo que testeando uno sabemos que ambos funcionan)
		System.out.println(p.Buscar("92897800W"));	//Buscamos el ultimo elemento añadido
		
		p.Esborrar("57295964M");					//Borramos el primer elemento y uno del medio y mostramos por pantalla
		p.Esborrar("48928682G");
		System.out.println(p);						//Mostramos y ambos elementos han desaparecido
		
		sc.close();
	}

	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 100)
			nLinies = 100;
		
		result = new String[nLinies];
		Scanner f = new Scanner(new File("ED_Ciutadans_50k.csv"));
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}

	private static ListaEnlazadaOrdenada afegirDadesDeFitxer(int linies) throws FileNotFoundException {
		ListaEnlazadaOrdenada lista = new ListaEnlazadaOrdenada();
		String[] fichero = llegirLiniesFitxer(linies);
		for (int i = 0; i < fichero.length; i++) {
			String[] ficheroSplit = fichero[i].split(",");
			lista.Inserir(new Nodo(new Ciutada(ficheroSplit[0], ficheroSplit[1], ficheroSplit[2] + ficheroSplit[3])));
		}
		return lista;
	}
	
	private static ListaHash afegirDadesDeFitxer2(int linies) throws FileNotFoundException {
		ListaHash lista = new ListaHash(3);
		String[] fichero = llegirLiniesFitxer(linies);
		int i = 0;
		for (i = 0; i < fichero.length; i++) {
			String[] ficheroSplit = fichero[i].split(",");
			lista.Inserir(ficheroSplit[2]+ficheroSplit[3], ficheroSplit[1], ficheroSplit[0]);
		}
		return lista;
	}
}
