package Service.oblig2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ServiceInterfaces.oblig2.ISok;
import personer.oblig2.Kunde;
import utilitet.dat109.Pris;
import utsted.dat109.Bil;
import utsted.dat109.Kategori;
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

	public List<UtleieKontor> hentKontorListAdresse(String adresse) {
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
		String[] kategori = {"A", "B", "C", "D", "E", ""};
		String valgtKategori = (String) JOptionPane.showInputDialog(f, "Liste av valg", "Velg kategori", JOptionPane.QUESTION_MESSAGE, null, kategori, kategori[0]);
		
		LocalDate startDato = LocalDate.parse(JOptionPane.showInputDialog(f, "Skriv inn start dato"));
		LocalDate sluttDato = LocalDate.parse(JOptionPane.showInputDialog(f, "Skriv inn slutt dato"));
		
		String adresse = JOptionPane.showInputDialog(f, "skriv inn adresse");
		
		sok(valgtKategori, startDato, sluttDato, adresse);
	}

	private void sok(String kategori, LocalDate startDato, LocalDate sluttDato, String adresse) {
		List<UtleieKontor> kontorer = hentKontorListAdresse(adresse);
		int antallDager = (int) ChronoUnit.DAYS.between(startDato, sluttDato);
		
		String[] kategoriArr;
		if(kategori.equals("")) {
			kategoriArr = new String[] {"A", "B", "C", "D" , "E"};
		}else {
			kategoriArr = new String[5];
			for(int i = 0; i < 5; i++) {
				kategoriArr[i] = kategori; 
			}
		}
		
		//Bytt til Kontor pos
		int[] pos = lagDropDown(kontorer, antallDager, kategoriArr);
		int kontorPos = pos[0];
		int kategoriPos = pos[1];
		kontorer.get(kontorPos).reservert(kategori);//kanskje fjerne denne linjen
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
				dropDownValg[q] = kontorer.get(i).getAdresse() + ": " + kontorer.get(i).getKategori(j) + " "
						+ regnPris(kategoriArr[j], antallDager);
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
