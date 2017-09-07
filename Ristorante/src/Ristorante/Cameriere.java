package Ristorante;

public class Cameriere {

	private String nome;
	private String cognome;
	
	public Cameriere(String nome, String cognome) {
		this.nome=nome;
		this.cognome=cognome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
}
