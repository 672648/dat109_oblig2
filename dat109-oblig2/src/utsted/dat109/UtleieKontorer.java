package utsted.dat109;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Service.oblig2.Sok;

public class UtleieKontorer {
	
	private List<UtleieKontor> kontorer;
	private Sok sok;
	
	public UtleieKontorer() {
		kontorer = new ArrayList<UtleieKontor>();
		sok = new Sok(this);
	}

	public List<UtleieKontor> hentKontorAdresse(String gateAdresse){
		if(gateAdresse == "") {
			return kontorer;
		}
		return kontorer.stream().filter(kontor -> kontor.getAdresse().equals(gateAdresse)).toList();
	}
	
	public void lagKontorer(String gateAdresse, String postSted, int postNummer) {
		UtleieKontor kontor = new UtleieKontor(gateAdresse, postSted, postNummer);
		kontorer.add(kontor);
	}
	
	public List<UtleieKontor> hentKontor(){
		return kontorer;
	}
	
	public String getSokAdresse(){
		return sok.getGateAdresse();
	}
	public LocalDate getSokStartDato() {
		return sok.getStartDato();
	}

	public String getSokKategori() {
		return sok.getKategori();
	}

	public LocalDate getSokSluttDato() {
		return sok.getSluttDato();
	}
	public int getSokAntallDager() {
		return sok.getAntallDager();
	}
	
	public void sok(){
		sok.startSok();
	}
}
