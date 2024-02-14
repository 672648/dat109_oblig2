package personer.oblig2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Service.oblig2.Reservasjon;

public class Kunde {
	private Reservasjon reserver;
	private String fornavn;
	private String etternavn;
	private String tlf;
	private JFrame f;
	
	public Kunde() {
		String input = JOptionPane.showInputDialog(f, "Skiv inn fornavn:");
		if (input == null) {
			System.exit(0);
		}
		this.fornavn = input;
		
		input = JOptionPane.showInputDialog(f, "Skriv inn etternavn:");
		if (input == null) {
			System.exit(0);
		}
		this.etternavn = input;
		
		input = JOptionPane.showInputDialog(f, "Skriv inn telefonnummer:");
		if (input == null) {
			System.exit(0);
		}
		this.tlf = input;//husk å legge på sjekk for at tlf er int eller behold dette som string
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
