package tads;

public interface TadLlista <T>{
	
	//Inicializa lista
	void Crear();
	
	//Añade al final de la lista
	void Inserir(T Ob);
	
	//Añade a la lista en la posicion indicada
	void InserirPos(T Ob, int pos);
	
	//Devuelve el elemento en la  posicion indicada
	T Obtenir(int pos);
	
	//Devuelve el numero de elementos de la lista
	int Longitud();
	
	//Borra un elemento de la lista de la posicion
	void Esborrar(int pos);
	
	//Comprueba si esta en la lista (si esta devuelve el numero
	//de elementos buscados, sino devuelve lo mismo en una exception
	int Buscar(T data);
	
	
}
