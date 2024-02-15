package personer.oblig2;

import java.util.List;

import Service.oblig2.Retur;
import Service.oblig2.Utleie;
import utilitet.dat109.Utilitet;
import utsted.dat109.UtleieKontor;
import utsted.dat109.UtleieKontorer;

public class Ansatt {

	private UtleieKontorer kontorer;
	private Retur retur;

	public Ansatt(UtleieKontorer kontorer) {
		this.kontorer = kontorer;
	}

	public void startKontor() {
		for (int i = 0; i < 8; i++) {
			int tilfeldigPoststed = (int) Math.random() * 5;
			int tilfeldigPostNr = (int) Math.random() * (9999 - 1000) + 1000;
			kontorer.lagKontorer(Utilitet.gateAdresser[i], Utilitet.postSteder[tilfeldigPoststed], tilfeldigPostNr);
			genererBiler();
		}
	}

	public void genererBiler() {
		for (UtleieKontor kontor : kontorer.hentKontor()) {
			kontor.lagBil(regNr(), merke(), farge(), kontor.getKategori((int) Math.random() * 5), gateAdresse(), km());
		}
	}

	public String regNr() {
		return Utilitet.regNr[(int) Math.random() * Utilitet.regNr.length];
	}

	public String merke() {
		return Utilitet.merker[(int) Math.random() * Utilitet.merker.length];
	}

	public String farge() {
		return Utilitet.farger[(int) Math.random() * Utilitet.farger.length];
	}

	public String gateAdresse() {
		return Utilitet.gateAdresser[(int) Math.random() * Utilitet.gateAdresser.length];
	}

	public int km() {
		return (int) Math.random() * 500000;
	}
	
	public void lagKontor(String gateAdresse, String postSted, int postNummer) {
		kontorer.lagKontorer(gateAdresse, postSted, postNummer);
	}
	
	public void lagBil(String gateAdrese, String regnr, String merke, String modell, String farge, String kategori, int km) {
		kontorer.hentKontorAdresse(gateAdrese).get(0).lagBil(regnr, merke, modell, farge, kategori, km);
	}
	
	public void lagRetur(int km , String kategori, int antallDager, boolean sammeAdresse) {
		retur = new Retur(km, kategori, antallDager, sammeAdresse);
	}
	
	public Retur getRetur() {
		return retur;
	}
}
