package model;

import java.util.Date;
import java.util.LinkedList;

import controller.*;

public class Ristorante {

	private String nome;
	private String indirizzo;
	private long telefono;
	private String email;
	private String direttore;
	private LinkedList<Area> listaAree = new LinkedList<Area>();
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
	
	public Area nuovaArea(String nomeArea) {
		Area areaNuova = new Area(nomeArea);
		this.listaAree.add(areaNuova);
		return areaNuova;
	}
	
	public Area nuovaSottoArea(String nomeArea, Area areaPadre) {
		Area areaNuova = new Area(nomeArea);
		areaPadre.nuovaSottoIArea(areaNuova);
		return areaNuova;
	}
	
	public Stanza nuovaStanza(int numeroStanza, Area areaPadre) {
		Stanza stanza = new Stanza(numeroStanza);
		areaPadre.nuovaSottoIArea(stanza);
		return stanza;
	}
	
	public TavoloVip nuovoTavoloVip(int numero, Stanza stanza) {
		TavoloVip tavolo = new TavoloVip(numero);
		stanza.nuovoTavolo(tavolo);
		return tavolo;
	}
	
	public TavoloBase nuovoTavoloBase(int numero, Stanza stanza) {
		TavoloBase tavolo = new TavoloBase(numero);
		stanza.nuovoTavolo(tavolo);
		return tavolo;
	}
	
	public Ordinazione nuovaOrdinazione(Date data, String prodotti, TavoloAbs tavolo) {
		Ordinazione ordinazione = new Ordinazione(data, prodotti, tavolo);
		this.ordinazioni.add(ordinazione);
		this.notifyAll(ordinazione);
		return ordinazione;
	}
	
	public void concludiOrdinazione(Ordinazione ordinazione) {
		ordinazione.setInCorso(false);
		ordinazione.getTavolo().setOccupato(false);
		this.notifyAll(ordinazione.getTavolo());
	}
	
	public LinkedList<TavoloAbs> getTavoli(){
		LinkedList<TavoloAbs> tavoli = new LinkedList<TavoloAbs>();
		for (Area a:this.listaAree)
			tavoli.addAll(a.getTavoli());
		return tavoli;	
	}

	public Cameriere nuovoCameriere(String nome, String cognome){
		Cameriere cameriere = new Cameriere(nome, cognome);
		this.camerieri.add(cameriere);
		return cameriere;
	}
	
	private void eseguiOperazione(IOperazioneRistorante op) {
		op.applicaOperazione(this);
	}
	
	public int ordinazioniInCorso() {
		Contatore c= new Contatore();
		IOperazioneRistorante op= new CalcolaOrdinazioniInCorso(c);
		eseguiOperazione(op);
		return c.getValore();
	}
	
	public int tavoliLiberiArea(IArea a) {
		Contatore c= new Contatore();
		IOperazioneRistorante op = new CalcolaTavoliLiberiArea(c, a);
		eseguiOperazione(op);
		return c.getValore();
	}
	
	public int tavoliLiberiRistorante() {
		Contatore c = new Contatore();
		IOperazioneRistorante op = new CalcolaTavoliLiberiRistorante(c);
		eseguiOperazione(op);
		return c.getValore();
	}
	
	public int calcolaRendimento() {
		Contatore c= new Contatore();
		IOperazioneRistorante op= new CalcolaRendimento(c);
		eseguiOperazione(op);
		return c.getValore();
	}
	
	public boolean preferenzaVip() {
		Contatore base =  new Contatore();
		Contatore vip = new Contatore();
		IOperazioneRistorante op = new ContaTavoliPerTipoUltimaSettimana(base, vip);
		eseguiOperazione(op);
		return vip.getValore()>=base.getValore();
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

	public void nuovoObsOrd(IObsOrd obs) {
		this.obsOrdinazioni.add(obs);
	}

	public LinkedList<IObsTavolo> getObsTavoli() {
		return obsTavoli;
	}

	public void nuovoObsTavolo(IObsTavolo obs) {
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
