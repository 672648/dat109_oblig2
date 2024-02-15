package utilitet.dat109;

import java.util.ArrayList;
import java.util.List;

import Service.oblig2.Reservasjon;
import Service.oblig2.Retur;
import Service.oblig2.Utleie;
import utsted.dat109.UtleieKontorer;

public class Informasjon {
	private List<Reservasjon> reservasjonListe;
	private List<Utleie> utleieListe;
	private Utleie utleie;
	private UtleieKontorer UtleieKontor;
	
	public Informasjon() {
		this.reservasjonListe = new ArrayList();
		this.utleieListe = new ArrayList();
		this.UtleieKontor = new UtleieKontorer();
	}
	
	public void lagUtleie(String regNummer, int kilometerStand) {
		utleie = new Utleie(regNummer, kilometerStand);
		leggTilUtleie(utleie);
	}
	
	private void leggTilUtleie(Utleie utleie) {
		utleieListe.add(utleie);
	}
	
	public void leggTilReservasjon(Reservasjon reservasjon) {
		reservasjonListe.add(reservasjon);
	}
	
	public void opprettRetur(int kilometerStand, String kategori, int antallDager, boolean sammeAdresse) {
		retur = new Retur(kilometerStand, kategori, antallDager, sammeAdresse);
	}
	
	public List<Utleie> getUtleieListe() {
		return this.utleieListe;
	}
}
