package Ristorante;

import java.util.LinkedList;

public class Ristorante {

	private String nome;
	private String indirizzo;
	private String telefono;
	private String email;
	private String direttore;
	private LinkedList<Area> listaAree;
	
	
	public Ristorante(String nome, String indirizzo, String telefono, String email, String direttore) {
		this.nome=nome;
		this.indirizzo=indirizzo;
		this.telefono=telefono;
		this.email=email;
		this.direttore=direttore;
		this.listaAree=new LinkedList<Area>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public String getIndirizzo() {
		return this.indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo=indirizzo;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getDirettore() {
		return this.direttore;
	}
	
	public void setDirettore(String direttore) {
		this.direttore=direttore;
	}
	
	public LinkedList<Area> getListaAree(){
		return this.listaAree;
	}
}
