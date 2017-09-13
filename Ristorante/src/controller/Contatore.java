package controller;

public class Contatore {

	private int valore = 0;
	
	public void incrementa(int incremento) {
		this.valore += incremento;
	}
	
	public int getValore() {
		return valore;
	}
	
}
