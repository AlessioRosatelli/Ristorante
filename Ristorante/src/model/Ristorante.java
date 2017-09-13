package model;

import java.util.LinkedList;

import controller.*;

public class Ristorante {

	private String nome;
	private String indirizzo;
	private long telefono;
	private String email;
	private String direttore;
	private LinkedList<Area> listaAree;
	private LinkedList<Ordinazione> ordinazioni = new LinkedList<Ordinazione>();
	private LinkedList<Cameriere> camerieri = new LinkedList<Cameriere>();
	private LinkedList<IObsOrd > obsOrdinazioni = new LinkedList<IObsOrd>();
	private LinkedList<IObsTavolo> obsTavoli = new LinkedList<IObsTavolo>();
	
	public Ristorante (String nome, String indirizzo, long telefono, String email,String direttore) {
		this.setNome(nome);
		this.setIndirizzo(indirizzo);
		this.setTelefono(telefono);
		this.setEmail(email);
		this.setDirettore(direttore);
	}
	
	public void nuovaArea(Area area) {
		this.listaAree.add(area);
	}
	
	public void nuovaSottoAreaStanza(IArea areaNuova, Area areaPadre) {
		areaPadre.addSottoArea(areaNuova);
	}
	
	
	
	public void nuovoTavolo(TavoloAbs tavolo, Stanza stanza) {
		stanza.addTavolo(tavolo);
	}
	
	public void nuovaOrdinazione(Ordinazione ordinazione) {
		this.ordinazioni.add(ordinazione);
		this.notifyAll(ordinazione);
	}
	
	public void concludiOrdinazione(Ordinazione ordinazione) {
		ordinazione.setInCorso(false);
		ordinazione.getTavolo().setOccupato(false);
		this.notifyAll(ordinazione.getTavolo());
	}

	
	public void eseguiOp(IOperazioneRistorante op) {
		op.applicaOp(this);
	}
	

	
	public LinkedList<TavoloAbs> getTavoli(){
		LinkedList<TavoloAbs> tavoli = new LinkedList<TavoloAbs>();
		for (Area a:this.listaAree)
			tavoli.addAll(a.getTavoli());
		return tavoli;	
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDirettore() {
		return direttore;
	}

	public void setDirettore(String direttore) {
		this.direttore = direttore;
	}
	
	public Cameriere addCameriere(String nome, String cognome){
		Cameriere cameriere = new Cameriere(nome, cognome);
		this.camerieri.add(cameriere);
		return cameriere;
	}
		
	public LinkedList<Cameriere> getListaCamerieri(){
		return this.camerieri;
	}
		
	public void removeCameriere(Cameriere cameriere){
		this.camerieri.remove(cameriere);
	}

	public LinkedList<Area> getListaAree() {
		return listaAree;
	}
	
	public LinkedList<Ordinazione> getOrdinazioni(){
		return this.ordinazioni;
	}

	public LinkedList<IObsOrd > getObsOrdinazioni() {
		return obsOrdinazioni;
	}

	public void addObsOrd(IObsOrd obs) {
		this.obsOrdinazioni.add(obs);
	}

	public LinkedList<IObsTavolo> getObsTavoli() {
		return obsTavoli;
	}

	public void addObsTavolo(IObsTavolo obs) {
		this.obsTavoli.add(obs);
	}
	
	public void notifyAll(TavoloAbs t) {
		for(IObsTavolo obs : this.obsTavoli)
			obs.update(t);
	}
	
	public void notifyAll(Ordinazione o) {
		for(IObsOrd obs : this.obsOrdinazioni)
			obs.update(o);
	}

}
