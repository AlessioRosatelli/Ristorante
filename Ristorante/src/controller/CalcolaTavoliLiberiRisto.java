package controller;

import java.util.LinkedList;

import model.Ristorante;
import model.TavoloAbs;

public class CalcolaTavoliLiberiRisto implements IOperazioneRistorante {

	private Contatore c;
	
	public CalcolaTavoliLiberiRisto(Contatore c) {
		this.c=c;
	}
	@Override
	public void applicaOperazione(Ristorante r) {
		LinkedList<TavoloAbs> tavoli = r.getTavoli();
		for (TavoloAbs t:tavoli)
			if(!t.isOccupato())
				c.incrementa(1);
	}

}
