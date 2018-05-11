package br.com.fametro.dap.lucas.subjects;

import java.util.Observable;

public class ClimaDados extends Observable {

	private float temp;
	private float umid;
	private float pressao;

	public ClimaDados(float temp, float umid, float pressao) {
		this.temp = temp;
		this.umid = umid;
		this.pressao = pressao;
	}

	public void medidasAlteradas() {
		setChanged();
		notifyObservers();
	}

	public float getTemp() {
		return temp;
	}

	public float getUmid() {
		return umid;
	}

	public float getPressao() {
		return pressao;
	}

}
