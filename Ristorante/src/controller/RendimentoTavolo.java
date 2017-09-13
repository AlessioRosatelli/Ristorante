package controller;

import model.TavoloBase;
import model.TavoloVip;

public class RendimentoTavolo implements IOperazioneSuTavolo {

	private Contatore c;
	
	public RendimentoTavolo(Contatore contatore) {
		this.c=contatore;
	}
	
	@Override
	public void applicaOperazione(TavoloBase t) {
		c.incrementa(1);
	}

	@Override
	public void applicaOperazione(TavoloVip t) {
		c.incrementa(2);
	}

}
