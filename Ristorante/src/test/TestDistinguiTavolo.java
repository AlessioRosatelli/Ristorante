package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.TavoloBase;
import model.TavoloVip;

import controller.*;

public class TestDistinguiTavolo {

	private TavoloBase tb = new TavoloBase(1);
	private TavoloVip tv = new TavoloVip(1);
	
	@Test
	public void testApplicaOperazioneTavoloBase() {
		Contatore base = new Contatore();
		Contatore vip = new Contatore();
		DistinguiTavolo dt = new DistinguiTavolo(base, vip);
		dt.applicaOperazione(tb);
		assertEquals(1, base.getValore());
		assertEquals(0, vip.getValore());
		dt.applicaOperazione(tb);
		assertEquals(2, base.getValore());
		assertEquals(0, vip.getValore());
	}

	@Test
	public void testApplicaOperazioneTavoloVip() {
		Contatore base = new Contatore();
		Contatore vip = new Contatore();
		DistinguiTavolo dt = new DistinguiTavolo(base, vip);
		dt.applicaOperazione(tv);
		assertEquals(0, base.getValore());
		assertEquals(1, vip.getValore());
		dt.applicaOperazione(tv);
		assertEquals(0, base.getValore());
		assertEquals(2, vip.getValore());
	}

}
