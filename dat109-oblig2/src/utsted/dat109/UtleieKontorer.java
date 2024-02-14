package utsted.dat109;

import java.time.LocalDate;
import java.util.List;

public class UtleieKontorer {
	
	private static List<UtleieKontor> kontorer;
	

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
}
