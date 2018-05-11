package br.com.fametro.dap.lucas.observers;

import java.util.Observable;
import java.util.Observer;

import br.com.fametro.dap.lucas.subjects.ClimaDados;

public class Estatisticas implements Observer, ExibeElemento {

	private float temp;
	private float tempMax;
	private float tempMin;
	private float umid;
	private float pressao;
	Observable observable;

	public Estatisticas(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}


	@Override
	public void exibir() {
		System.out.println("\nFUNCEME - Estatisticas: temp. máxima de " + tempMax + " ºC /"
				+ "temp. mínima: " + tempMin + " ºC");

	}

	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof ClimaDados) {
			ClimaDados climaDados = (ClimaDados) obs;
			this.temp = climaDados.getTemp();
			this.umid = climaDados.getUmid();
			this.pressao = climaDados.getPressao();
			exibir();
		}
	}

}
