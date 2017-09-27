package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.*;

public class TestContaTavoliPerTipoUltimaSettimana {

	private Inizializzazione init = new Inizializzazione();
	
	@Before
	public void setUp() throws Exception {
		init.setUp();
	}

	@Test
	public void testApplicaOperazione() {
		Contatore base = new Contatore();
		Contatore vip = new Contatore();
		ContaTavoliPerTipoUltimaSettimana pv = new ContaTavoliPerTipoUltimaSettimana(base, vip);
		pv.applicaOperazione(init.ristorante);
		
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloVip1);
		init.ristorante.nuovaOrdinazione(init.oggi, "", init.tavoloBase1);
		
		base.reset();
		vip.reset();
		pv.applicaOperazione(init.ristorante);
		
		assertEquals(8, base.getValore());
		assertEquals(3, vip.getValore());
	}

}
