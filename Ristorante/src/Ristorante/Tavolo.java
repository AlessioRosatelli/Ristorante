package Ristorante;

public class Tavolo {

	private int numero;
	private String tipo;
	
	public Tavolo(int numero) {
		this.numero=numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero=numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
