package Service.oblig2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Utleie {
	private String kredittNummer;
	private String regNummer;
	private int kilometerStand;
	private LocalDate dato;
	private LocalTime tid;
	private Reservasjon resrvasjon;
	
	public Utleie(String kredittNummer, String rgsNummer, int kilometerStand, LocalDate dato, LocalTime tid) {
		this.kredittNummer = kredittNummer;
		this.regNummer = regNummer;
		this.kilometerStand = kilometerStand;
		this.dato = dato;
		this.tid = tid;
	}
	
	public String getKredittNummer() {
		return this.kredittNummer;
	}
	
	public void setKredittNummer(String kredittNummer) {
		this.kredittNummer = kredittNummer;
	}
	
	public String getRegNummer() {
		return this.regNummer;
	}
	
	public void setRegNummer(String rgsNummer) {
		this.regNummer = rgsNummer;
	}
	
	public int getKilometerStand() {
		return this.kilometerStand;
	}
	
	public void setKilometerStand(int kilometerStand) {
		this.kilometerStand = kilometerStand;
	}
	
	public LocalDate getDato() {
		return this.dato;
	}
	
	public void setDato(LocalDate dato) {
		this.dato = dato;
	}
	
	public LocalTime getTid() {
		return this.tid;
	}
	
	public void setTid(LocalTime tid) {
		this.tid = tid;
	}
}
