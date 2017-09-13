package model;

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
	
	public void nuovaSottoIArea(IArea a) {
		this.sottoAree.add(a);
	}
	

	public LinkedList<TavoloAbs> getTavoli(){
		LinkedList<TavoloAbs> tavoli = new LinkedList<TavoloAbs>();
		for (IArea a:this.sottoAree)
			tavoli.addAll(a.getTavoli());
		return tavoli;
	}
	
}
