package model;

import java.util.LinkedList;

public class Stanza implements IArea {
	
	private int numero;
	private LinkedList<TavoloAbs> tavoli = new LinkedList<TavoloAbs>();
		
	public Stanza(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public LinkedList<TavoloAbs> getTavoli() {
		return tavoli;
	}
	
	public void nuovoTavolo(TavoloAbs t) {
		this.tavoli.add(t);
	}

}
