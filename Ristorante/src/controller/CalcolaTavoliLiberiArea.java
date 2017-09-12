package controller;

import java.util.LinkedList;

import model.Contatore;
import model.IArea;
import model.Ristorante;
import model.TavoloAbs;

public class CalcolaTavoliLiberiArea implements IOperazioneRistorante {

	private Contatore c;
	private IArea a;
	
	public CalcolaTavoliLiberiArea(Contatore c, IArea a) {
		this.c=c;
		this.a=a;
	}
	@Override
	public void applicaOp(Ristorante r) {
		LinkedList<TavoloAbs> tavoli = a.getTavoli();
		for (TavoloAbs t: tavoli)
			if (!t.isOccupato())
				c.incrementa(1);
	}

}
