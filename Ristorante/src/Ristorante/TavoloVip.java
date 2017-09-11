package Ristorante;

public class TavoloVip extends TavoloAbs {

	public TavoloVip(int numero) {
		super(numero);
	}

	@Override
	public void eseguiOperazione(IOperazioneSuTavolo op) {
		op.applicaOperazione(this);
	}

}
