package controller;

import java.util.Date;
import java.util.LinkedList;

import model.*;

public class FiltraOrdinazioni {

	public static LinkedList<Ordinazione> filtraPerData(LinkedList<Ordinazione> ordinazioniDaFiltrare, Date dataInizio, Date dataFine){
		LinkedList<Ordinazione> ordinazioniFiltrate = new LinkedList<Ordinazione>();
		for(Ordinazione ord: ordinazioniDaFiltrare)
			if(ord.getData().after(dataInizio) && ord.getData().before(dataFine))
				ordinazioniFiltrate.add(ord);
		return ordinazioniFiltrate;
	}
	
}
