package controller;



import java.util.Date;

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
		Date oggi = new Date();
		Date settimanaFa = new Date( oggi.getTime() - 7*24*3600 );
		for (Ordinazione ord : new FiltraOrdinazioniPerData(r.getOrdinazioni(), settimanaFa, oggi).filtra())
			ord.getTavolo().eseguiOperazione(op);

		this.preferenza=vip.getValore()>=base.getValore();
	}
	public boolean getPreferenzaVip() {
		return preferenza;
	}
	
}
