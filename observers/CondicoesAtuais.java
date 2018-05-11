package br.com.fametro.dap.lucas.observers;

import java.util.Observable;
import java.util.Observer;

import br.com.fametro.dap.lucas.subjects.ClimaDados;

public class CondicoesAtuais implements Observer, ExibeElemento {

	Observable observable;
	private float temp;
	private float umid;
	private float pressao;

	public CondicoesAtuais(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable obs, Object arg) {
		if(obs instanceof ClimaDados) {
			ClimaDados climaDados = (ClimaDados) obs;
			this.temp = climaDados.getTemp();
			this.umid = climaDados.getUmid();
			this.pressao = climaDados.getPressao();
			exibir();
		}
	}

	public void exibir() {
		System.out.println("FUNCEME - Condições atuais: " + temp + " ºC e " + umid + " de umidade, e " + pressao
				+ " de pressão atmosferica");
	}


}
