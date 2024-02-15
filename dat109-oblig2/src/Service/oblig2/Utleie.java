package Service.oblig2;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utleie {
	private int id;
	private String kredittNummer;
	private String regNummer;
	private String kategori;
	private int antallDager;
	private int kilometerStand;
	private LocalDate dato;
	private LocalTime tid;
	private JFrame f;
	
	public Utleie(int id, String regNummer, int kilometerStand, String kategori, int antallDager) {
		this.id = id;
		this.kredittNummer = JOptionPane.showInputDialog(f, "Skriv inn kredittnummer");
		this.regNummer = regNummer;
		this.kategori = kategori;
		this.antallDager = antallDager;
		this.kilometerStand = kilometerStand;
		this.dato = LocalDate.now();
		this.tid = LocalTime.now();
	}
	
	public int getId() {
		return this.id;
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
	
	public int getAntallDager() {
		return this.antallDager;
	}
	
	public String getKategori() {
		return this.kategori;
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
