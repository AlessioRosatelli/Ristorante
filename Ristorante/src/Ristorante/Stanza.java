package Ristorante;

import java.util.LinkedList;

public class Stanza {
	
	private int numero;
	private LinkedList<Tavolo> tavoli= new LinkedList<Tavolo>();
		
	public Stanza(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public LinkedList<Tavolo> getTavoli() {
		return tavoli;
	}
	public void addTavolo(Tavolo t) {
		this.tavoli.add(t);
	}

}
