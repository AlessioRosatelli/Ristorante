package model;

import controller.IOperazioneSuTavolo;

public abstract class TavoloAbs {
	
	private int numero;
	private boolean occupato;
	
	public TavoloAbs(int numero) {
		this.numero=numero;
		this.setOccupato(false);
	}
	
	public abstract void eseguiOperazione(IOperazioneSuTavolo op);
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public boolean isOccupato() {
		return occupato;
	}
	
	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

}
