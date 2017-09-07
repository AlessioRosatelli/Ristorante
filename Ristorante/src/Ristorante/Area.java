package Ristorante;

import java.util.LinkedList;

public class Area {


	private String nome;
	private LinkedList<Area> sottoAree= new LinkedList<Area>();
	private LinkedList<Stanza> stanze= new LinkedList<Stanza>();
	
	public Area(String nome) {
		this.nome=nome;
	}
	
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
	public LinkedList<Stanza> getStanze() {
		return stanze;
	}
	public void addStanza(Stanza t) {
		this.stanze.add(t);
	}

	public LinkedList<Tavolo> getTavoli(){
		LinkedList<Tavolo> tavoli = new LinkedList<Tavolo>();
		for (Area a:this.sottoAree)
			tavoli.addAll(a.getTavoli());
		for (Stanza s:this.stanze)
			tavoli.addAll(s.getTavoli());
		return tavoli; 
	}
	
}
