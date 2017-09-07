package Ristorante;

import java.util.LinkedList;

public class Area {
<<<<<<< HEAD

	private String nome;
	private LinkedList<Stanza> listaStanze;
	
	public Area(String nome) {
		this.nome=nome;
		this.listaStanze=new LinkedList<Stanza>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public LinkedList<Stanza> getListaStanze(){
		return this.listaStanze;
	}
=======
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
	

>>>>>>> Alessio
}
