package Ristorante;

import java.util.Date;

public class Ordinazione {
	private Date data;
	private String prodotti;
	private Tavolo tavolo;
	
	public Ordinazione(Date data,String prodotti,Tavolo tavolo) {
		this.setData(data);
		this.setProdotti(prodotti);
		this.setTavolo(tavolo);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getProdotti() {
		return prodotti;
	}

	public void setProdotti(String prodotti) {
		this.prodotti = prodotti;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

}
