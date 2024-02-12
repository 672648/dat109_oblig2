package personer.oblig2;

import Service.oblig2.Reservasjon;

public class Kunde {
	private Reservasjon reserver;
	private String fornavn;
	private String etternavn;
	private String tlf;
	
	public Kunde(String fornavn, String etternavn, String tlf) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.tlf = tlf;
	}
	
	public void reserver() {}
	
	public void leie() {}
	
	public String getFornavn() {
		return this.fornavn;
	}
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public String getEtternavn() {
		return this.etternavn;
	}
	
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public String getTlf() {
		return this.tlf;
	}
	
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
}
