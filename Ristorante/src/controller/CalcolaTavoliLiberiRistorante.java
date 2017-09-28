package controller;



import model.Area;
import model.Ristorante;

public class CalcolaTavoliLiberiRistorante implements IOperazioneRistorante {

	private Contatore c;
	
	public CalcolaTavoliLiberiRistorante(Contatore c) {
		this.c=c;
	}
	
	@Override
	public void applicaOperazione(Ristorante r) {
		for (Area a : r.getListaAree()) {
			IOperazioneRistorante op = new CalcolaTavoliLiberiArea(this.c, a);
			op.applicaOperazione(r);
		}		
	}

}
