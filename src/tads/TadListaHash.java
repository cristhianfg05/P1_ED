package tads;

import java.util.ArrayList;

public interface TadListaHash <T,K>{
	
	void Inserir(K key, T value, T value2);
	
	T Obtenir(K key);
	
	int Buscar(K key);
	
	int Mida();
	
	void Esborrar(K key);
	
	T[]ObtenirValors();
	
	ArrayList<String> ObtenirKeys();
	
	float ObtenirFactorCarrega();
	
}
