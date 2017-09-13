package controller;

import model.TavoloBase;
import model.TavoloVip;

public class DistinguiTavolo implements IOperazioneSuTavolo {

	private Contatore vip;
	private Contatore base;
	
	public DistinguiTavolo(Contatore base, Contatore vip) {
		this.vip=vip;
		this.base=base;
	}
	
	@Override
	public void applicaOperazione(TavoloBase t) {
		base.incrementa(1);
	}

	@Override
	public void applicaOperazione(TavoloVip t) {
		vip.incrementa(1);
	}

}
