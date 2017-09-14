package test;

import controller.Contatore;
import controller.IObsTavolo;
import model.TavoloAbs;

public class ObsTavoloTest implements IObsTavolo {
	
	private Contatore c = new Contatore ();

	@Override
	public void update(TavoloAbs t) {
		c.incrementa(1);
	}

	public Contatore getC() {
		return c;
	}

	public void setC(Contatore c) {
		this.c = c;
	}

}
