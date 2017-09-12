package controller;

import model.TavoloBase;
import model.TavoloVip;

public interface IOperazioneSuTavolo {

	public void applicaOperazione(TavoloBase t);
	public void applicaOperazione(TavoloVip t);
	
}
