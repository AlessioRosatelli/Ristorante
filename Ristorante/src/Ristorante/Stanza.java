package Ristorante;

import java.util.LinkedList;

public class Stanza {

	private String nome;
	private LinkedList<Tavolo> listaTavoli;
	
	public Stanza(String nome) {
		this.nome=nome;
		this.listaTavoli=new LinkedList<Tavolo>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public LinkedList<Tavolo> getListaTavoli(){
		return this.listaTavoli;
	}
}
