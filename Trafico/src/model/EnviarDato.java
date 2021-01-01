package model;

import java.io.Serializable;

public class EnviarDato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String idSensor;
	String sDato;
	String sIp;

	public String getIdSensor() {
		return idSensor;
	}

	public void setIdSensor(String idSensor) {
		this.idSensor = idSensor;
	}

	public String getsIp() {
		return sIp;
	}

	public void setsIp(String sIp) {
		this.sIp = sIp;
	}

	public String getsDato() {
		return sDato;
	}

	public void setsDato(String sDato) {
		this.sDato = sDato;
	}

	@Override
	public String toString() {
		return "EnviarDato [idSensor=" + idSensor + ", sDato=" + sDato + ", sIp=" + sIp + "]";
	}

}
