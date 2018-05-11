package br.com.fametro.dap.lucas.observers;

import java.util.Observable;
import java.util.Observer;

import br.com.fametro.dap.lucas.subjects.ClimaDados;

public class PrevisaoTempo implements Observer, ExibeElemento {

	private float temp;
	private float umid;
	private float pressao;
	Observable observable;

	public PrevisaoTempo(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void exibir() {

		System.out.println("\nFUNCEME - Previsão do Tempo para amanhã: " + temp + " ºC / " + umid + "% de umidade / "
				+ pressao + " de pressão atmosferica");
	}

	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof ClimaDados) {
			ClimaDados climaDados = (ClimaDados) obs;
			this.temp = climaDados.getTemp() + 10;
			this.umid = climaDados.getUmid() + 10;
			this.pressao = climaDados.getPressao() + 10;
			exibir();
		}
	}

}
