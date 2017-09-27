package controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import model.Ordinazione;

public class ContaTavoliPerTipoUltimaSettimana extends ContaTavoliPerTipo implements IOperazioneRistorante {

	public ContaTavoliPerTipoUltimaSettimana(Contatore base, Contatore vip) {
		super(base,vip);
	}
	
	protected LinkedList<Ordinazione> filtraOrdinazioni(LinkedList<Ordinazione> ordinazioni){
		Date oggi = new Date();
		Date settimanaFa = new Date( oggi.getTime() - TimeUnit.DAYS.toMillis(7) );
		return FiltraOrdinazioni.filtraPerData(ordinazioni, settimanaFa, oggi);
	}
	
}
