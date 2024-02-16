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
	
	public int leggTilReservasjon() {
		Reservasjon reservasjon = new Reservasjon(utleieKontor.getSokStartDato(), utleieKontor.getSokSluttDato(),
				utleieKontor.getSokAntallDager(), utleieKontor.getSokKategori(), utleieKontor.getSokAdresse());
		reservasjonListe.add(reservasjon);
		return reservasjon.getId();
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
	public void sok(){
		utleieKontor.sok();
	}
	
	public void leggTilKontorer(String gateAdress, String postSted, int postNummer) {
		utleieKontor.lagKontorer(gateAdress, postSted, postNummer);
	}
	
	public void leggTilBil(String[] bilVerdier) {
		utleieKontor.hentKontorAdresse(bilVerdier[6]).get(0).lagBil(bilVerdier[0], bilVerdier[1], bilVerdier[2], bilVerdier[3], bilVerdier[4], Integer.parseInt(bilVerdier[5]));
	}
}
