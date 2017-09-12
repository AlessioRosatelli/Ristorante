package controller;



import model.Contatore;
import model.Ordinazione;
import model.Ristorante;

public class PreferenzaVip implements IOperazioneRistorante {

	private Contatore base;
	private Contatore vip;
	private boolean preferenza = false;
	
	public PreferenzaVip(Contatore base, Contatore vip) {
		this.base=base;
		this.vip=vip;
	}
	@Override
	public void applicaOp(Ristorante r) {
		IOperazioneSuTavolo op = new DistinguiTavolo(base,vip);
		for (Ordinazione ord : r.getOrdinazioni())
			if (ord.ultimaSettimana())
				ord.getTavolo().eseguiOperazione(op);

		this.preferenza=vip.getValore()>=base.getValore();
	}
	public boolean getPreferenzaVip() {
		return preferenza;
	}
	
}
