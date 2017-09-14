package test;

import model.*;
import controller.*;

import java.util.Date;

public class Inizializzazione {

	public Ristorante ristorante = new Ristorante("RisotranteProva", "Prova", 0755555, "prova@gmail.com", "Prova della Prova");
	
	public Date oggi = new Date( new Date().getTime() - 1);
	public Date treGiorniFa = new Date( oggi.getTime() - 3*24*3600 );
	public Date dieciGiorniFa = new Date( oggi.getTime() - 10*24*3600 );
	
	public Area area1 = ristorante.nuovaArea("area1");
	public Area area2 = ristorante.nuovaArea("area2");
	
	public Area area11 = ristorante.nuovaSottoArea("area11", area1);
	public Area area12 = ristorante.nuovaSottoArea("area12", area1);
	public Area area13 = ristorante.nuovaSottoArea("area13", area1);
	public Area area21 = ristorante.nuovaSottoArea("area21", area2);
	public Area area22 = ristorante.nuovaSottoArea("area22", area1);
	
	public Stanza stanza1 = ristorante.nuovaStanza(1, area1);
	public Stanza stanza11 = ristorante.nuovaStanza(2, area11);
	public Stanza stanza12 = ristorante.nuovaStanza(3, area12);
	public Stanza stanza13 = ristorante.nuovaStanza(4, area13);
	public Stanza stanza22 = ristorante.nuovaStanza(6, area22);
	public Stanza stanza222 = ristorante.nuovaStanza(1, area22);
	
	public TavoloBase tavoloBase1 = ristorante.nuovoTavoloBase(1, stanza1);
	public TavoloBase tavoloBase2 = ristorante.nuovoTavoloBase(1, stanza1);
	public TavoloBase tavoloBase3 = ristorante.nuovoTavoloBase(1, stanza1);
	public TavoloBase tavoloBase4 = ristorante.nuovoTavoloBase(1, stanza11);
	public TavoloBase tavoloBase5 = ristorante.nuovoTavoloBase(1, stanza12);
	public TavoloBase tavoloBase6 = ristorante.nuovoTavoloBase(1, stanza13);
	public TavoloBase tavoloBase7 = ristorante.nuovoTavoloBase(1, stanza22);
	public TavoloBase tavoloBase8 = ristorante.nuovoTavoloBase(1, stanza222);
	public TavoloBase tavoloBase9 = ristorante.nuovoTavoloBase(1, stanza11);

	public TavoloBase tavoloVip1 = ristorante.nuovoTavoloBase(1, stanza222);
	public TavoloBase tavoloVip2 = ristorante.nuovoTavoloBase(1, stanza222);
	public TavoloBase tavoloVip3 = ristorante.nuovoTavoloBase(1, stanza222);
	public TavoloBase tavoloVip4 = ristorante.nuovoTavoloBase(1, stanza22);
	public TavoloBase tavoloVip5 = ristorante.nuovoTavoloBase(1, stanza22);
	public TavoloBase tavoloVip6 = ristorante.nuovoTavoloBase(1, stanza11);
	public TavoloBase tavoloVip7 = ristorante.nuovoTavoloBase(1, stanza12);
	public TavoloBase tavoloVip8 = ristorante.nuovoTavoloBase(1, stanza13);
	public TavoloBase tavoloVip9 = ristorante.nuovoTavoloBase(1, stanza13);
	
	public Ordinazione ord1 = ristorante.nuovaOrdinazione(oggi, "prova", tavoloBase1);
	public Ordinazione ord2 = ristorante.nuovaOrdinazione(oggi, "prova", tavoloBase2);
	public Ordinazione ord3 = ristorante.nuovaOrdinazione(oggi, "prova", tavoloBase3);
	public Ordinazione ord4 = ristorante.nuovaOrdinazione(oggi, "prova", tavoloBase4);
	public Ordinazione ord5 = ristorante.nuovaOrdinazione(oggi, "prova", tavoloBase5);
	public Ordinazione ord6 = ristorante.nuovaOrdinazione(treGiorniFa, "prova", tavoloBase6);
	public Ordinazione ord7 = ristorante.nuovaOrdinazione(treGiorniFa, "prova", tavoloBase1);
	public Ordinazione ord8 = ristorante.nuovaOrdinazione(treGiorniFa, "prova", tavoloVip1);
	public Ordinazione ord9 = ristorante.nuovaOrdinazione(treGiorniFa, "prova", tavoloVip1);
	public Ordinazione ord10 = ristorante.nuovaOrdinazione(dieciGiorniFa, "prova", tavoloVip2);
	public Ordinazione ord11 = ristorante.nuovaOrdinazione(dieciGiorniFa, "prova", tavoloBase6);
	public Ordinazione ord12 = ristorante.nuovaOrdinazione(dieciGiorniFa, "prova", tavoloVip4);
	public Ordinazione ord13 = ristorante.nuovaOrdinazione(dieciGiorniFa, "prova", tavoloVip9);
	
	public Cameriere cameriere1 = ristorante.nuovoCameriere("Prova", "Prova");
	
	public IObsTavolo obsTavolo1 = new ObsTavoloTest();
	public IObsOrd obsOrd1 = new ObsOrdinazioneTest();
	
	
	public void setUp() {
		ristorante.concludiOrdinazione(ord13);
		ristorante.concludiOrdinazione(ord12);
		ristorante.concludiOrdinazione(ord11);
		ristorante.concludiOrdinazione(ord10);
		ristorante.concludiOrdinazione(ord9);
		ristorante.concludiOrdinazione(ord8);
		ristorante.concludiOrdinazione(ord7);
		ristorante.concludiOrdinazione(ord6);
		ristorante.concludiOrdinazione(ord5);
		
		ristorante.nuovoObsOrd(obsOrd1);
		ristorante.nuovoObsTavolo(obsTavolo1);
	}
}
