package Ristorante;

import java.util.LinkedList;

public class Area implements IArea {


	private String nome;
	private LinkedList<IArea> sottoAree= new LinkedList<IArea>();
	
	
	public Area(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LinkedList<IArea> getSottoAree() {
		return sottoAree;
	}
	public void addSottoArea(IArea a) {
		this.sottoAree.add(a);
	}
	

	public LinkedList<Tavolo> getTavoli(){
		LinkedList<Tavolo> tavoli = new LinkedList<Tavolo>();
		for (IArea a:this.sottoAree)
			tavoli.addAll(a.getTavoli());
		return tavoli;
	}
	
}
