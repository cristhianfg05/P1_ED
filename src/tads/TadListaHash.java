package tads;

public interface TadListaHash <T,K>{
	
	void Inserir(K key, T value, T value2);
	
	T Obtenir(K key);
	
	int Buscar(K key);
	
	int Mida();
	
	void Esborrar(K key);
	
	T[]ObtenirValors();
	
	K[]ObtenirKeys();
	
	float ObtenirFactorCarrega();
	
}
