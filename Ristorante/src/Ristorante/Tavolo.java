package Ristorante;

public class Tavolo {
	
	private int numero;
	private String tipo;
	private boolean occupato;
	
	public Tavolo(int numero,String tipo) {
		this.numero=numero;
		this.tipo=tipo;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isOccupato() {
		return occupato;
	}
	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	

}
