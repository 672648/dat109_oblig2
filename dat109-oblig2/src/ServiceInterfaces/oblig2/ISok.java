package ServiceInterfaces.oblig2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import personer.oblig2.Kunde;
import utsted.dat109.Bil;
import utsted.dat109.UtleieKontor;

public interface ISok {
	
	public List<UtleieKontor> hentKontorListAdresse(String adresse);
	public List<Bil> hentBilKategori(String kategori, List<UtleieKontor> kontorer);
	public int hentPris();
	public void reserver(Kunde kunde, LocalDateTime dato, int antallDager, String kategori);
	public void sok(String kategori, LocalDate startDato, LocalDate sluttDato, String adresse);
	public int lagDropDown(List<UtleieKontor> kontorer, int antallDager);
}