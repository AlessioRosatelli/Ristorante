package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.*;

public class TestCalcolaOrdinazioniInCorso {

	private Inizializzazione init = new Inizializzazione();
	
	@Before
	public void setUp() throws Exception {
		init.setUp();
	}

	@Test
	public void testApplicaOperazione() {
		Contatore prova = new Contatore();
		CalcolaOrdinazioniInCorso coc = new CalcolaOrdinazioniInCorso(prova);
		coc.applicaOperazione(init.ristorante);
		assertEquals(4, prova.getValore());
		init.ristorante.concludiOrdinazione(init.ord1);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloBase1);
		prova.reset();
		coc.applicaOperazione(init.ristorante);
		assertEquals(4, prova.getValore());
	}

}
