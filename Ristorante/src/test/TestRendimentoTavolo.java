package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.*;
import model.TavoloBase;
import model.TavoloVip;

public class TestRendimentoTavolo {
	
	private TavoloBase tb = new TavoloBase(1);
	private TavoloVip tv = new TavoloVip(1);


	@Test
	public void testApplicaOperazioneTavoloBase() {
		Contatore prova = new Contatore();
		RendimentoTavolo rt = new RendimentoTavolo(prova);
		rt.applicaOperazione(tb);
		assertEquals(1, prova.getValore());
		rt.applicaOperazione(tb);
		assertEquals(2, prova.getValore());
	}

	@Test
	public void testApplicaOperazioneTavoloVip() {
		Contatore prova = new Contatore();
		RendimentoTavolo rt = new RendimentoTavolo(prova);
		rt.applicaOperazione(tv);
		assertEquals(2, prova.getValore());
		rt.applicaOperazione(tv);
		assertEquals(4, prova.getValore());
	}

}
