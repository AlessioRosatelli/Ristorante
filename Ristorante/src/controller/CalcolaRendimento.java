package controller;

import model.Contatore;
import model.Ordinazione;
import model.Ristorante;

public class CalcolaRendimento implements IOperazioneRistorante {
	
	private Contatore c ;
	
	public CalcolaRendimento(Contatore c) {
		this.c= c;
	}
	

	@Override
	public void applicaOp(Ristorante r) {
		IOperazioneSuTavolo op = new RendimentoTavolo(this.c);
		for (Ordinazione ord:r.getOrdinazioni()) {
			ord.getTavolo().eseguiOperazione(op);
		}
	}

}
