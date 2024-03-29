package utsted.dat109;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bil {
	private String regnr;
	private String merke;
	private String modell;
	private String farge;
	private String kategori;
	private String gateAdresse;
	private int km;

	public Bil(String regnr, String merke, String modell, String farge, String kategori, String gateAdresse, int km) {
		this.regnr = regnr;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.kategori = kategori;
		this.gateAdresse = gateAdresse;
		this.km = km;
	}

	
	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public String getUtleiekontor() {
		return gateAdresse;
	}

	public void setUtleiekontor(String gateAdresse) {
		this.gateAdresse = gateAdresse;
	}
	
	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

}
