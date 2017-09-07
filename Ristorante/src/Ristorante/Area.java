package Ristorante;

import java.util.LinkedList;

public class Area {
	private String nome;
	private LinkedList<Area> sottoAree= new LinkedList<Area>();
	private LinkedList<Stanza> tavoli= new LinkedList<Stanza>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LinkedList<Area> getSottoAree() {
		return sottoAree;
	}
	public void addSottoArea(Area a) {
		this.sottoAree.add(a);
	}
	public LinkedList<Stanza> getTavoli() {
		return tavoli;
	}
	public void addStanza(Stanza t) {
		this.tavoli.add(t);
	}
	

}
