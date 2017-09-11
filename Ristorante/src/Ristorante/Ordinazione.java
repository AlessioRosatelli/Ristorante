package Ristorante;

import java.util.Date;

public class Ordinazione {
	
	private Date data;
	private String prodotti;
	private TavoloAbs tavolo;
	private boolean inCorso;
	
	public Ordinazione(Date data,String prodotti,TavoloAbs tavolo) {
		this.setData(data);
		this.setProdotti(prodotti);
		this.setTavolo(tavolo);
		this.setInCorso(true);
		this.tavolo.setOccupato(true);
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

	public TavoloAbs getTavolo() {
		return tavolo;
	}

	public void setTavolo(TavoloAbs tavolo) {
		this.tavolo = tavolo;
	}

	public boolean isInCorso() {
		return inCorso;
	}

	public void setInCorso(boolean inCorso) {
		this.inCorso = inCorso;
	}

}
