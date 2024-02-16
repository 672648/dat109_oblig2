package Service.oblig2;

import java.time.LocalDate;

import personer.oblig2.Kunde;

public class Reservasjon {
	
	private Kunde kunde;
	private LocalDate startDato;
	private LocalDate sluttDato;
	private int antallDager;
	private String kategori;
	private String gateAdresse;
	private int id;

	public Reservasjon(Kunde kunde,LocalDate startDato, LocalDate sluttDato, int antallDager, String kategori, String gateAdresse) {
		this.kunde = kunde;
		this.startDato = startDato;
		this.sluttDato = sluttDato;
		this.antallDager = antallDager;
		this.kategori = kategori;
		this.gateAdresse = gateAdresse;
		id = (int) (Math.random()*9999);
	}
	
	public int getId() {
		return id;
	}
	
	public String getGateAdresse() {
		return this.gateAdresse;
	}
	
	public String getKategori() {
		return this.kategori;
	}
	
	public int getAntallDager() {
		return this.antallDager;
	}
}
