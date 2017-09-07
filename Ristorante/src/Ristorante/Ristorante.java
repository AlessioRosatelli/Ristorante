package Ristorante;

public class Ristorante {

	private String nome;
	private String indirizzo;
	private long telefono;
	private String email;
	private String direttore;
	
	public Ristorante (String nome, String indirizzo, long telefono, String email,String direttore) {
		this.setNome(nome);
		this.setIndirizzo(indirizzo);
		this.setTelefono(telefono);
		this.setEmail(email);
		this.setDirettore(direttore);
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDirettore() {
		return direttore;
	}

	public void setDirettore(String direttore) {
		this.direttore = direttore;
	}
	
}
