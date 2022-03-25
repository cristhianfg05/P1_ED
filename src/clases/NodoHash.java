package clases;

import tads.TadNodoHash;

public class NodoHash implements TadNodoHash<Object>{

	private NodoHash seg;
	private Ciutada c;
	
	public NodoHash(Ciutada c) {
		super();
		this.c = c;
	}

	@Override
	public NodoHash getSeg() {
		return seg;
	}

	@Override
	public Ciutada getValor() {
		return c;
	}

	@Override
	public void setSeg(Object nodSeg) {
		NodoHash nod = (NodoHash)nodSeg;
		this.seg = nod;
	}

}
