package utilitet.dat109;

import java.util.ArrayList;
import java.util.List;

import Service.oblig2.Reservasjon;
import Service.oblig2.Retur;
import Service.oblig2.Utleie;
import utsted.dat109.UtleieKontor;
import utsted.dat109.UtleieKontorer;

public class Informasjon {
	private List<Reservasjon> reservasjonListe;
	private List<Utleie> utleieListe;
	private Utleie utleie;
	private UtleieKontorer utleieKontor;
	
	public Informasjon() {
		this.reservasjonListe = new ArrayList();
		this.utleieListe = new ArrayList();
		this.utleieKontor = new UtleieKontorer();
	}
	
	public void lagUtleie(int id, String regNummer, int kilometerStand, String kategori, int antallDager) {
		utleie = new Utleie(id, regNummer, kilometerStand, kategori, antallDager);
		leggTilUtleie(utleie);
	}
	
	private void leggTilUtleie(Utleie utleie) {
		utleieListe.add(utleie);
	}
	
	public void leggTilReservasjon(Reservasjon reservasjon) {
		reservasjonListe.add(reservasjon);
	}
	
	public UtleieKontor getKontor(String adresse) {
		return utleieKontor.hentKontorAdresse(adresse).get(0);
	}
	
	public List<Reservasjon> getReservasjonListe() {
		return this.reservasjonListe;
	}
	
	public List<Utleie> getUtleieListe() {
		return this.utleieListe;
	}
	
	public UtleieKontorer getUtleieKontor() {
		return this.utleieKontor;
	}
}
