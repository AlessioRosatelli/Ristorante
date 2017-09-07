package Ristorante;

import java.util.LinkedList;

public class Area {

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
}
