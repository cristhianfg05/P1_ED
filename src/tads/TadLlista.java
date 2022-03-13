package tads;

public interface TadLlista <T>{	
	
	//A�ade al final de la lista
	void Inserir(T Ob);
	
	//A�ade a la lista en la posicion indicada
	boolean InserirPos(T Ob, int pos);
	
	//Devuelve el elemento en la  posicion indicada
	T Obtenir(int pos);
	
	//Devuelve el numero de elementos de la lista
	int Longitud();
	
	//Borra un elemento de la lista de la posicion
	boolean Esborrar(int pos);
	
	//Comprueba si esta en la lista (si esta devuelve el numero
	//de elementos buscados, sino devuelve el numero de elementos recorridos
	int Buscar(T data);
	
	String toString();
	String toStringIterator();
}


