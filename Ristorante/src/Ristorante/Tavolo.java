package Ristorante;

public class Tavolo {
	
	private int numero;
	private boolean isVip;
	private boolean occupato;
	
	public Tavolo(int numero,boolean isVip) {
		this.numero=numero;
		this.isVip=isVip;
		}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isVip() {
		return isVip;
	}
	public void setTipo(boolean isVip) {
		this.isVip=isVip;
	}
	public boolean isOccupato() {
		return occupato;
	}
	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

}
