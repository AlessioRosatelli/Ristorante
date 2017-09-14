package test;

import controller.Contatore;
import controller.IObsOrd;
import model.Ordinazione;

public class ObsOrdinazioneTest implements IObsOrd {
	
	private Contatore c= new Contatore();

	@Override
	public void update(Ordinazione ord) {
		c.incrementa(1);

	}

	public Contatore getC() {
		return c;
	}

	public void setC(Contatore c) {
		this.c = c;
	}

}
