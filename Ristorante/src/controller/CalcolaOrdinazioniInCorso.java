package controller;

import model.Contatore;
import model.Ordinazione;
import model.Ristorante;

public class CalcolaOrdinazioniInCorso implements IOperazioneRistorante {

	private Contatore c;
	
	public CalcolaOrdinazioniInCorso(Contatore c) {
		this.c=c;
	}
	
	@Override
	public void applicaOp(Ristorante r) {
		for (Ordinazione ord:r.getOrdinazioni())
			if (ord.isInCorso())
				c.incrementa(1);

	}

}
