package utsted.dat109;

import java.time.LocalDate;
import java.util.List;

public abstract class AUtleieKontor {
	
	private static List<UtleieKontor> kontorer;
	
	abstract List<Bil> faListe(String kategori /*,LocalDate startDato, LocalDate sluttDato*/);
	
	abstract void lagBil(String regnr, String merke, String modell, String farge, String kategori);

	public List<UtleieKontor> hentKontorList(String lokasjon){
		if(lokasjon == "") {
			return kontorer;
		}
		return kontorer.stream().filter(kontor -> kontor.getKontorNavn().equals(lokasjon)).toList();
	}
	
	public void lagKontorer(String kontorNavn) {
		UtleieKontor kontor = new UtleieKontor(kontorNavn);
		kontorer.add(kontor);
	}
	
}
