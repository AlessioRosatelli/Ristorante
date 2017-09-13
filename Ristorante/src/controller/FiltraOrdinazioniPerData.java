package controller;

import java.util.Date;
import java.util.LinkedList;

import model.*;

public class FiltraOrdinazioniPerData {

	private LinkedList<Ordinazione> ordinazioniDaFiltrare;
	private Date dataInizio;
	private Date dataFine;
	
	public FiltraOrdinazioniPerData(LinkedList<Ordinazione> ordinazioniDaFiltrare, Date dataInizio, Date dataFine) {
		this.setOrdinazioniDaFiltrare(ordinazioniDaFiltrare);
		this.setDataFine(dataFine);
		this.setDataInizio(dataInizio);
	}

	public LinkedList<Ordinazione> filtra(){
		LinkedList<Ordinazione> ordinazioniFiltrate = new LinkedList<Ordinazione>();
		for(Ordinazione ord: this.ordinazioniDaFiltrare)
			if(ord.getData().after(dataInizio) && ord.getData().before(dataFine))
				ordinazioniFiltrate.add(ord);
		return ordinazioniFiltrate;
	}
	
	public LinkedList<Ordinazione> getOrdinazioniDaFiltrare() {
		return ordinazioniDaFiltrare;
	}

	public void setOrdinazioniDaFiltrare(LinkedList<Ordinazione> ordinazioniDaFiltrare) {
		this.ordinazioniDaFiltrare = ordinazioniDaFiltrare;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	
}
