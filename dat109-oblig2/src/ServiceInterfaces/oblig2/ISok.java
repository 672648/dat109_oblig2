package ServiceInterfaces.oblig2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import personer.oblig2.Kunde;
import utsted.dat109.Bil;
import utsted.dat109.UtleieKontor;

public interface ISok {
	
	public List<UtleieKontor> hentKontorListAdresse(String adresse);
	public void reserver(LocalDate startDato,LocalDate sluttDato, int antallDager, String kategori, String gateAdresse);
	public void sok(String kategori, LocalDate startDato, LocalDate sluttDato, String adresse);
	public int[] lagDropDown(List<UtleieKontor> kontorer, int antallDager,String[] kategoriArr);
}