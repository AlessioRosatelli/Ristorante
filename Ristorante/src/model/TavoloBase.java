package model;

import controller.IOperazioneSuTavolo;

public class TavoloBase extends TavoloAbs {

	public TavoloBase(int numero) {
		super(numero);
	}

	@Override
	public void eseguiOperazione(IOperazioneSuTavolo op) {
		op.applicaOperazione(this);
	}

}
