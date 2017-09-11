package Ristorante;

public class TavoloBase extends TavoloAbs {

	public TavoloBase(int numero) {
		super(numero);
	}

	@Override
	public void eseguiOperazione(IOperazioneSuTavolo op) {
		op.applicaOperazione(this);
	}

}
