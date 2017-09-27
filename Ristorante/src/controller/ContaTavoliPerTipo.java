package controller;

import java.util.LinkedList;

import model.Ordinazione;
import model.Ristorante;

public class ContaTavoliPerTipo implements IOperazioneRistorante {

	protected Contatore base;
	protected Contatore vip;
	
	public ContaTavoliPerTipo(Contatore base, Contatore vip) {
		this.base=base;
		this.vip=vip;
	}
	
	@Override
	public void applicaOperazione(Ristorante r) {
		IOperazioneSuTavolo op = new DistinguiTavolo(base,vip);
		for (Ordinazione ord : filtraOrdinazioni(r.getOrdinazioni()))
			ord.getTavolo().eseguiOperazione(op);
	}
	
	protected LinkedList<Ordinazione> filtraOrdinazioni(LinkedList<Ordinazione> ordinazioni) {
		return ordinazioni;
	}

}
