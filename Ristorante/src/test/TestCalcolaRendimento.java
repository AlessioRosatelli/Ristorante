package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.*;

public class TestCalcolaRendimento {

	private Inizializzazione init = new Inizializzazione();
	
	@Before
	public void setUp() throws Exception {
		init.setUp();
	}

	@Test
	public void testApplicaOperazione() {
		Contatore prova = new Contatore();
		CalcolaRendimento cr = new CalcolaRendimento(prova);
		cr.applicaOperazione(init.ristorante);
		assertEquals(18, prova.getValore());
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloVip1);
		prova = new Contatore();
		cr = new CalcolaRendimento(prova);
		cr.applicaOperazione(init.ristorante);
		assertEquals(20, prova.getValore());	
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloBase1);
		prova.reset();
		cr.applicaOperazione(init.ristorante);
		assertEquals(21, prova.getValore());	
	}

}
