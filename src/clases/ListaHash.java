package clases;

import java.util.ArrayList;
import java.util.Arrays;

import tads.TadListaHash;

public class ListaHash implements TadListaHash<Object, Object> {

	private NodoHash lista[];
	private int elems;

	public ListaHash(int dim) {
		super();
		this.lista = new NodoHash[dim];
		this.elems = 0;
	}

	public NodoHash[] getLista() {
		return lista;
	}

	@Override
	public void Inserir(Object key, Object value, Object value2) {
		// Calculamos el factor de carga
		if (ObtenirFactorCarrega() > 0.75) {
			Redimensionar();
		}
		// Calculamos posicion
		int pos = key.hashCode() % this.lista.length;
		if (pos < 0)
			pos = pos * -1;

		if (this.lista[pos] == null) {
			this.lista[pos] = new NodoHash(new Ciutada((String) value, (String) value2, (String) key));
			this.elems++;
		} else {
			boolean trobat = false;
			NodoHash actual = this.lista[pos];
			if (actual.getSeg() == null
					&& actual.getValor().compareTo(new Ciutada((String) value, (String) value2, (String) key)) == 0) {
				trobat = true;
			} else {
				while (!trobat && actual.getSeg() != null) {
					if (actual.getValor().compareTo(new Ciutada((String) value, (String) value2, (String) key)) == 0) {
						trobat = true;
					} else
						actual = actual.getSeg();
				}
				if (actual.getValor().compareTo(new Ciutada((String) value, (String) value2, (String) key)) == 0) {
					trobat = true;
				}
			}
			if (trobat)
				actual.setValor(new Ciutada((String) value, (String) value2, (String) key));
			else {
				actual.setSeg(new NodoHash(new Ciutada((String) value, (String) value2, (String) key)));
				this.elems++;
			}
		}
	}

	@Override
	public Object Obtenir(Object key) {
		int pos = key.hashCode() % this.lista.length;
		if (pos < 0)
			pos = pos * -1;

		if (this.lista[pos] == null)
			return false;
		else {
			NodoHash actual = this.lista[pos];
			boolean trobat = false;
			if (actual.getSeg() == null) {
				if (actual.getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
					trobat = true;
				}
			} else {
				while (!trobat && actual.getSeg() != null) {
					if (actual.getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
						trobat = true;
					} else
						actual = actual.getSeg();
				}
				if (actual.getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
					trobat = true;
				}
			}
			if (trobat)
				return actual;
			else
				return false;
		}

	}

	@Override
	public int Buscar(Object key) {
		int cost = 1;
		int pos = key.hashCode() % this.lista.length;
		if (pos < 0)
			pos = pos * -1;
		if (this.lista[pos] == null) {
			System.out.println("\nElemento no encontrado posicion nula");
			return 1;
		} else {
			NodoHash actual = this.lista[pos];
			boolean trobat = false;
			if (actual.getSeg() == null) {
				if (actual.getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
					System.out.println("\nElemento encontrado");
					return 1;
				}
			} else {
				while (!trobat && actual.getSeg() != null) {
					if (actual.getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
						System.out.println("\nElemento encontrado");
						return cost;
					} else {
						actual = actual.getSeg();
						cost = cost + 1;
					}
				}
				if (actual.getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
					System.out.println("\nElemento encontrado");
					return cost;
				}
			}
			System.out.println("\nElemento no encontrado");
			return cost;
		}

	}

	@Override
	public int Mida() {
		return this.elems;
	}

	@Override
	public void Esborrar(Object key) {
		int pos = key.hashCode() % this.lista.length;
		if (pos < 0)
			pos = pos * -1;
		boolean trobat = false;

		if (this.lista[pos] == null) {
			System.out.println("Elemento no encontrado A");
		} else if (this.lista[pos] != null) {
			if (this.lista[pos].getSeg() == null) {
				if (this.lista[pos].getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
					trobat = true;
					this.lista[pos] = null;
				} else {
					System.out.println("Elemento no encontrado B");
				}
			} else {
				if (this.lista[pos].getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
					this.lista[pos] = this.lista[pos].getSeg();
					trobat = true;
				} else {
					NodoHash actual = this.lista[pos].getSeg();
					NodoHash nodoAElim = null;
					while (!trobat && actual.getSeg() != null) {
						if (actual.getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
							trobat = true;
							nodoAElim = actual;
						} else {
							actual = actual.getSeg();
						}
					}
					if (actual.getValor().compareTo(new Ciutada("a", "null", (String) key)) == 0) {
						trobat = true;
						nodoAElim = actual;
					}
					if (trobat) {
						actual = this.lista[pos];
						trobat = false;
						while (!trobat && actual.getSeg() != null) {
							if (actual.getSeg() == nodoAElim) {
								if (nodoAElim.getSeg() == null) {
									actual.setSeg(null);
									trobat = true;
								} else {
									actual.setSeg(nodoAElim.getSeg());
									trobat = true;
								}
							} else {
								actual = actual.getSeg();
							}
						}
					} else {
						System.out.println("Elemento no encontrado C");
					}
				}
			}
		}

	}

	@Override
	public Object[] ObtenirValors() {

		if (this.elems == 0)
			return null;
		else {
			ArrayList<String> nombres = new ArrayList<String>();
			ArrayList<String> apellidos = new ArrayList<String>();
			NodoHash actual = this.lista[0];
			for (int i = 1; i < lista.length; i++) {
				if (actual != null) {
					if (actual.getSeg() == null) {
						nombres.add(actual.getValor().getNom());
						apellidos.add(actual.getValor().getCognom());
						actual = this.lista[i];
					} else {
						while (actual.getSeg() != null) {
							nombres.add(actual.getValor().getNom());
							apellidos.add(actual.getValor().getCognom());
							actual = actual.getSeg();
						}
						nombres.add(actual.getValor().getNom());
						apellidos.add(actual.getValor().getCognom());
						actual = this.lista[i];
					}

				} else {
					actual = this.lista[i];
				}
			}
			if (actual != null) {
				if (actual.getSeg() == null) {
					nombres.add(actual.getValor().getNom());
					apellidos.add(actual.getValor().getCognom());
				} else {
					while (actual.getSeg() != null) {
						nombres.add(actual.getValor().getNom());
						apellidos.add(actual.getValor().getCognom());
						actual = actual.getSeg();
					}
					nombres.add(actual.getValor().getNom());
					apellidos.add(actual.getValor().getCognom());
				}

			}

			ArrayList<String>[] lista = new ArrayList[2];
			lista[0] = nombres;
			lista[1] = apellidos;
			return lista;
		}

	}

	@Override
	public ArrayList<String> ObtenirKeys() {

		if (this.elems == 0)
			return null;
		else {
			ArrayList<String> keys = new ArrayList<String>();
			NodoHash actual = this.lista[0];

			for (int i = 1; i < lista.length; i++) {
				if (actual != null) {
					if (actual.getSeg() == null) {
						keys.add(actual.getValor().getDni());
						actual = this.lista[i];
					} else {
						while (actual.getSeg() != null) {
							keys.add(actual.getValor().getDni());
							actual = actual.getSeg();
						}

						keys.add(actual.getValor().getDni());
						actual = this.lista[i];
					}

				} else {
					actual = this.lista[i];
				}
			}
			if (actual != null) {
				if (actual.getSeg() == null) {
					keys.add(actual.getValor().getDni());
				} else {
					while (actual.getSeg() != null) {
						keys.add(actual.getValor().getDni());
						actual = actual.getSeg();
					}

					keys.add(actual.getValor().getDni());
				}

			}
			return keys;
		}

	}

	@Override
	public String toString() {
		String concat = "";
		if (this.elems == 0)
			return "No hay elementos";
		else {
			NodoHash actual;
			for (int i = 0; i < lista.length; i++) {
				actual = this.lista[i];
				while(actual != null) {
					concat = concat + "\n"+actual.toString() + " "+i;
					actual = actual.getSeg();
				}
			}
			return concat;
		}
	}

	@Override
	public float ObtenirFactorCarrega() {
		return this.elems / this.lista.length;
	}

	private void Redimensionar() {
		System.out.println("Voy a redimensionar");
		NodoHash[] listaNueva = new NodoHash[this.lista.length  * 2];
		int pos;
		NodoHash actual, mover, insertar;
		for (int i = 0; i < this.lista.length; i++) {
			actual = this.lista[i];
			while (actual != null) {
				mover = actual;
				actual = actual.getSeg();
				mover.setSeg(null);
				pos = Math.abs(mover.getValor().getDni().hashCode() % listaNueva.length);
				insertar = listaNueva[pos];
				if(insertar == null) {
					listaNueva[pos] = mover;
				}else {
					while(insertar.getSeg() != null) {
						insertar = insertar.getSeg();
						
					}
					insertar.setSeg(mover);
				}
			}

		}
		this.lista = listaNueva;
	}
}
