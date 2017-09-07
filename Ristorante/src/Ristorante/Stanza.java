package Ristorante;

import java.util.LinkedList;

public class Stanza {
<<<<<<< HEAD

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
=======
	private int numero;
	private LinkedList<Tavolo> tavoli= new LinkedList<Tavolo>();
	
	public Stanza(int numero) {
		this.numero=numero;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public LinkedList<Tavolo> getT() {
		return tavoli;
	}
	public void addTavolo(Tavolo t) {
		this.tavoli.add(t);
	}

>>>>>>> Alessio
}
