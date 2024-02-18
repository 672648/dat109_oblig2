package Service.oblig2;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import utilitet.dat109.Pris;
import utsted.dat109.UtleieKontor;
import utsted.dat109.UtleieKontorer;

public class Sok extends Pris {

	private UtleieKontorer kontorer;
	private LocalDate startDato;
	private String kategori;
	private String gateAdresse;
	private LocalDate sluttDato;
	private int antallDager;

	public Sok(UtleieKontorer utleiekontorer) {
		kontorer = utleiekontorer;
		
	}

	private List<UtleieKontor> hentKontorListAdresse(String adresse) {
		if(adresse.equals("")) {
			return kontorer.hentKontor();
		}
		return kontorer.hentKontorAdresse(adresse);
	}

	/*public void reserver(LocalDate startDato,LocalDate sluttDato, int antallDager, String kategori, String gateAdresse) {
		reservasjon = new Reservasjon(kunde,startDato, sluttDato, antallDager, kategori, gateAdresse);
	}*/
	
	/*public Reservasjon getReservasjon() {
		return reservasjon;
	}*/
	
	public void startSok() {
		JFrame f = new JFrame();
		
		String startDatoString = JOptionPane.showInputDialog(f, "Skriv inn start dato \n YYYY-MM-DD");
		LocalDate startDato = sjekkDato(startDatoString);
		
		String sluttDatoString = JOptionPane.showInputDialog(f, "Skriv inn slutt dato \n YYYY-MM-DD");
		LocalDate sluttDato = sjekkDato(sluttDatoString);
		
		String adresse = JOptionPane.showInputDialog(f, "skriv inn adresse \n ex: Bergenveien 2");
		
		sok(startDato, sluttDato, adresse);
	}
	
	public LocalDate sjekkDato(String dato) {
		String regex = "\\d{4}-\\d{2}-\\d{2}";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dato);
		if(dato.equalsIgnoreCase("") || !matcher.matches()) {
			return LocalDate.now();
		}
		return LocalDate.parse(dato);
	}

	private void sok(LocalDate startDato, LocalDate sluttDato, String adresse) {
		
		List<UtleieKontor> kontorer = hentKontorListAdresse(adresse);
		int antallDager = (int) ChronoUnit.DAYS.between(startDato, sluttDato);
		
		String[] kategoriArr = new String[] {"A", "B", "C", "D" , "E"};
		
		//Bytt til Kontor pos
		int[] pos = lagDropDown(kontorer, antallDager, kategoriArr);
		int kontorPos = pos[0];
		int kategoriPos = pos[1];
		//kontorer.get(kontorPos).reservert(kategori);//kanskje fjerne denne linjen
		if(kontorer.get(kontorPos).getAntall(kategoriPos) == 0) {
			startSok();
		}
		this.startDato = startDato;
		this.sluttDato = sluttDato;
		this.antallDager = antallDager;
		this.kategori = kontorer.get(kontorPos).getKategori(kategoriPos);
		this.gateAdresse = kontorer.get(kontorPos).getAdresse();

	}

	private int[] lagDropDown(List<UtleieKontor> kontorer, int antallDager, String[] kategoriArr) {
		String[] dropDownValg = new String[kontorer.size()*5];

		for (int i = 0; i < kontorer.size(); i++) {
			for(int j = 0; j < 5; j++) {
				int q = i*5+j;
				dropDownValg[q] = kontorer.get(i).getAdresse() + ": Pris : "
						+ regnPris(kategoriArr[j], antallDager) + " antall:" + kontorer.get(i).getAntall(j) + 
						" i " + kontorer.get(i).getKategori(j);
			}
		}
		JFrame frame = new JFrame();
		String valgt = (String) JOptionPane.showInputDialog(frame, "Liste av valg", "Velg modell å reservere", JOptionPane.QUESTION_MESSAGE, null, dropDownValg, dropDownValg[0]);
		
		return posForValg(valgt, dropDownValg);
	}
	
	private int[] posForValg(String valgt, String[] muligheter) {
		int[] pos = new int[2];
		int posMulig = 0;
		for(int i = 0; i < muligheter.length; i++) {
			if(muligheter[i].contains(valgt)) {
				posMulig = i;
			}
		}
		pos[0] = posMulig/5;
		pos[1] = posMulig % 5;
		return pos;
	}
	
	public LocalDate getStartDato() {
		return startDato;
	}

	public String getKategori() {
		return kategori;
	}

	public LocalDate getSluttDato() {
		return sluttDato;
	}

	public int getAntallDager() {
		return antallDager;
	}

	public String getGateAdresse() {
		return gateAdresse;
	}

}
