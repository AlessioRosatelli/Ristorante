package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class TestRistorante {
	
	Inizializzazione init = new Inizializzazione();
	
	@Before
	public void setUp() throws Exception {
		init.setUp();
	}

	@Test
	public void testNuovaArea() {
		assertEquals(init.ristorante.getListaAree().size(), 2);
		Area nuova= init.ristorante.nuovaArea("AleRos");
		assertEquals(init.ristorante.getListaAree().size(),3);
		assertEquals(init.ristorante.getListaAree().getLast(),nuova);
	}

	@Test
	public void testNuovaSottoArea() {
		assertEquals(init.area12.getSottoAree().size(),1);
		Area nuova = init.ristorante.nuovaSottoArea("ALeROs", init.area12);
		assertEquals(init.area12.getSottoAree().size(),2);
		assertEquals(init.area12.getSottoAree().getLast(),nuova);
	}

	@Test
	public void testNuovaStanza() {
		assertEquals(init.area12.getSottoAree().size(),1);
		Stanza nuova = init.ristorante.nuovaStanza(1, init.area12);
		assertEquals(init.area12.getSottoAree().size(),2);
		assertEquals(init.area12.getSottoAree().getLast(),nuova);
	}

	@Test
	public void testNuovoTavoloVip() {
		assertEquals(init.stanza13.getTavoli().size(),3);
		TavoloVip nuovo = init.ristorante.nuovoTavoloVip(4, init.stanza13);
		assertEquals(init.stanza13.getTavoli().size(),4);
		assertEquals(init.stanza13.getTavoli().getLast(), nuovo);
		assertEquals(init.stanza13.getTavoli().getLast().isOccupato(), false);
	}

	@Test
	public void testNuovoTavoloBase() {
		assertEquals(init.stanza13.getTavoli().size(),3);
		TavoloBase nuovo = init.ristorante.nuovoTavoloBase(4, init.stanza13);
		assertEquals(init.stanza13.getTavoli().size(),4);
		assertEquals(init.stanza13.getTavoli().getLast(), nuovo);
		assertEquals(init.stanza13.getTavoli().getLast().isOccupato(), false);
	}

	@Test
	public void testNuovaOrdinazione() {
		assertEquals(init.ristorante.getOrdinazioni().size(), 13);
		Ordinazione nuova = init.ristorante.nuovaOrdinazione(init.oggi, "AleRos",init.tavoloVip9);
		assertEquals(init.ristorante.getOrdinazioni().size(), 14);
		assertEquals(init.ristorante.getOrdinazioni().getLast(),nuova);
		assertEquals(init.ristorante.getOrdinazioni().getLast().getData(),init.oggi);
		assertEquals(init.ristorante.getOrdinazioni().getLast().getProdotti(),"AleRos");
		assertEquals(init.ristorante.getOrdinazioni().getLast().getTavolo(),init.tavoloVip9);
		assertEquals(init.ristorante.getOrdinazioni().getLast().isInCorso(),true);
	}

	@Test
	public void testConcludiOrdinazione() {
		assertEquals(init.ristorante.getOrdinazioni().getFirst().isInCorso(),true);
		assertEquals(init.ristorante.getOrdinazioni().getLast().isInCorso(),false);
		Ordinazione nuova = init.ristorante.nuovaOrdinazione(init.oggi, "AleRos",init.tavoloVip9);
		assertEquals(init.ristorante.getOrdinazioni().getLast().isInCorso(),true);
		init.ristorante.concludiOrdinazione(nuova);
		assertEquals(init.ristorante.getOrdinazioni().getLast().isInCorso(),false);
	}

	@Test
	public void testGetTavoli() {
		assertEquals(init.ristorante.getTavoli().size(),18);
		assertEquals(init.stanza12.getTavoli().size(),2);
		assertEquals(init.area12.getTavoli().size(),2);
		assertEquals(init.area1.getTavoli().size(),11);
		init.ristorante.nuovoTavoloBase(1, init.stanza12);
		assertEquals(init.ristorante.getTavoli().size(),19);
		assertEquals(init.stanza12.getTavoli().size(),3);
		assertEquals(init.area12.getTavoli().size(),3);
		assertEquals(init.area1.getTavoli().size(),12);
	}

	@Test
	public void testNuovoCameriere() {
		assertEquals(init.ristorante.getListaCamerieri().size(), 1);
		init.ristorante.nuovoCameriere("Ale", "Ros");
		assertEquals(init.ristorante.getListaCamerieri().size(), 2);
		assertEquals(init.ristorante.getListaCamerieri().getLast().getCognome(), "Ros");
	}

	@Test
	public void testOrdinazioniInCorso() {
		assertEquals(init.ristorante.ordinazioniInCorso(),4);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloBase1);
		assertEquals(init.ristorante.ordinazioniInCorso(),5);
		init.ristorante.concludiOrdinazione(init.ord1);
		assertEquals(init.ristorante.ordinazioniInCorso(),4);
	}

	@Test
	public void testTavoliLiberiArea() {
		assertEquals(init.ristorante.tavoliLiberiArea(init.area11),2);
		assertEquals(init.ristorante.tavoliLiberiArea(init.area12),2);
		Ordinazione nuova = init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloBase5);
		assertEquals(init.ristorante.tavoliLiberiArea(init.area12),1);
		init.ristorante.concludiOrdinazione(nuova);
		assertEquals(init.ristorante.tavoliLiberiArea(init.area12),2);
	}

	@Test
	public void testTavoliLiberiRistorante() {
		assertEquals(init.ristorante.tavoliLiberiRistorante(),14);
		Ordinazione nuova = init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloBase5);
		assertEquals(init.ristorante.tavoliLiberiRistorante(),13);
		init.ristorante.concludiOrdinazione(nuova);
		assertEquals(init.ristorante.tavoliLiberiRistorante(),14);
	}

	@Test
	public void testCalcolaRendimento() {
		assertEquals(init.ristorante.calcolaRendimento(), 18);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloBase8);
		assertEquals(init.ristorante.calcolaRendimento(), 19);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloVip8);
		assertEquals(init.ristorante.calcolaRendimento(), 21);
		init.ristorante.nuovaOrdinazione(init.dieciGiorniFa, "", init.tavoloVip8);
		assertEquals(init.ristorante.calcolaRendimento(), 23);
	}

	@Test
	public void testPreferenzaVip() {
		assertFalse(init.ristorante.preferenzaVip());
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloVip4);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloVip4);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloVip4);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloVip4);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloVip4);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloVip4);
		assertTrue(init.ristorante.preferenzaVip());
		init.ristorante.nuovaOrdinazione(init.dieciGiorniFa, "", init.tavoloBase6);
		init.ristorante.nuovaOrdinazione(init.dieciGiorniFa, "", init.tavoloBase6);
		assertTrue(init.ristorante.preferenzaVip());
		init.ristorante.nuovaOrdinazione(init.treGiorniFa, "", init.tavoloBase6);
		init.ristorante.nuovaOrdinazione(init.treGiorniFa, "", init.tavoloBase6);
		assertFalse(init.ristorante.preferenzaVip());
	}

	@Test
	public void testRemoveCameriere() {
		assertEquals(init.ristorante.getListaCamerieri().size(),1);
		init.ristorante.removeCameriere(init.cameriere1);
		assertEquals(init.ristorante.getListaCamerieri().size(),0);
	}

	@Test
	public void testNuovoObsOrd() {
		assertEquals(init.ristorante.getObsOrdinazioni().size(),1);
		ObsOrdinazioneTest nuovo = new ObsOrdinazioneTest();
		init.ristorante.nuovoObsOrd(nuovo);
		assertEquals(init.ristorante.getObsOrdinazioni().size(),2);
		assertEquals(init.ristorante.getObsOrdinazioni().getLast(),nuovo);
	}

	@Test
	public void testNuovoObsTavolo() {
		assertEquals(init.ristorante.getObsTavoli().size(),1);
		ObsTavoloTest nuovo = new ObsTavoloTest();
		init.ristorante.nuovoObsTavolo(nuovo);
		assertEquals(init.ristorante.getObsTavoli().size(),2);
		assertEquals(init.ristorante.getObsTavoli().getLast(),nuovo);
	}

	@Test
	public void testNotifyAllTavoloAbs() {
		assertEquals(init.obsTavolo1.getC().getValore(), 0);
		init.ristorante.concludiOrdinazione(init.ord1);
		assertEquals(init.obsTavolo1.getC().getValore(), 1);
		init.ristorante.concludiOrdinazione(init.ord2);
		assertEquals(init.obsTavolo1.getC().getValore(), 2);
	}

	@Test
	public void testNotifyAllOrdinazione() {
		assertEquals(init.obsOrd1.getC().getValore(),0);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloBase1);
		assertEquals(init.obsOrd1.getC().getValore(),1);
	}

}
