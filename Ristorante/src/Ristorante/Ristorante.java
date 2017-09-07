package Ristorante;

import java.util.Date;
import java.util.LinkedList;

public class Ristorante {

	private String nome;
	private String indirizzo;
	private long telefono;
	private String email;
	private String direttore;
	private LinkedList<Area> listaAree;
	private LinkedList<Ordinazione> ordinazioni = new LinkedList<Ordinazione>();
	private LinkedList<Cameriere> camerieri = new LinkedList<Cameriere>();
	
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
	
	public void nuovaSottoArea(Area areaNuova, Area areaPadre) {
		areaPadre.addSottoArea(areaNuova);
	}
	
	public void nuovaStanza(Stanza stanza, Area areaPadre) {
		areaPadre.addStanza(stanza);
	}
	
	public void nuovoTavolo(Tavolo tavolo, Stanza stanza) {
		stanza.addTavolo(tavolo);
	}
	
	public void nuovaOrdinazione(Ordinazione ordinazione) {
		this.ordinazioni.add(ordinazione);
	}
	
	public void concludiOrdinazione(Ordinazione ordinazione) {
		ordinazione.setInCorso(false);
		ordinazione.getTavolo().setOccupato(false);
	}
	
	public int ordinazioniInCorso() {
		int inCorso = 0;
		for (Ordinazione ord:this.ordinazioni)
			if (ord.isInCorso())
				inCorso++;
		return inCorso;
	}
	
	public int tavoliLiber() {
		int liberi = 0;
		LinkedList<Tavolo> tavoli = this.getTavoli();
		for (Tavolo t:tavoli)
			if(!t.isOccupato())
				liberi++;
		return liberi;
	}
	
	public int tavoliInArea(Area area) {
		int liberi = 0;
		LinkedList<Tavolo> tavoli = area.getTavoli();
		for (Tavolo t: tavoli)
			if (!t.isOccupato())
				liberi++;
		return liberi;
	}
	
	public double rendimento() {
		double rendimento = 0;
		LinkedList<Tavolo> tavoli = this.getTavoli();
		for (Tavolo t:tavoli)
			if(t.isVip())
				rendimento+=2;
			else
				rendimento+=1;
		return rendimento;
	}
	
	public boolean preferenzaTavoliVipUltimaSettimana() {
		int vip = 0;
		int base = 0;
		Date settimanaFa = new Date( new Date().getTime() - 7*24*3600 );
		for (Ordinazione ord:this.ordinazioni)
			if (ord.getData().after(settimanaFa))
				if (ord.getTavolo().isVip())
					vip++;
				else
					base++;
		return vip>=base;
	}
	
	public LinkedList<Tavolo> getTavoli(){
		LinkedList<Tavolo> tavoli = new LinkedList<Tavolo>();
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

}
