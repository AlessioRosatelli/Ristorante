package controller;

import model.Ordinazione;
import model.Ristorante;

public class CalcolaOrdinazioniInCorso implements IOperazioneRistorante {

	private Contatore c;
	
	public CalcolaOrdinazioniInCorso(Contatore c) {
		this.c=c;
	}
	
	@Override
	public void applicaOperazione(Ristorante r) {
		for (Ordinazione ord:r.getOrdinazioni())
			if (ord.isInCorso())
				c.incrementa(1);

	}

}
