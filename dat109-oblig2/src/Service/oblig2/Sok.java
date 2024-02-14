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

public class Sok implements ISok {

	private UtleieKontorer kontorer;
	private Kunde kunde;

	public Sok(Kunde kunde) {
		kontorer = new UtleieKontorer();
		kunde = kunde;
	}

	@Override
	public List<UtleieKontor> hentKontorListAdresse(String adresse) {
		return kontorer.hentKontorAdresse(adresse);
	}

	@Override
	public void reserver(LocalDate startDato,LocalDate sluttDato, int antallDager, String kategori, String gateAdresse) {
		Reservasjon reservasjon = new Reservasjon(kunde,startDato, sluttDato, antallDager, kategori, gateAdresse);
	}

	@Override
	public void sok(String kategori, LocalDate startDato, LocalDate sluttDato, String adresse) {
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
		kontorer.get(kontorPos).reservert(kategori);
		reserver(startDato, sluttDato, antallDager, kontorer.get(kontorPos).getKategori(kategoriPos), kontorer.get(kontorPos).getAdresse());
		

	}

	public int[] lagDropDown(List<UtleieKontor> kontorer, int antallDager, String[] kategoriArr) {
		Pris pris = new Pris();
		String[] dropDownValg = new String[kontorer.size()*5];

		for (int i = 0; i < kontorer.size(); i++) {
			for(int j = 0; j < 5; j++) {
				int q = i*5+j;
				dropDownValg[q] = kontorer.get(i).getAdresse() + ": " + kontorer.get(i).getKategori(j) + " "
						+ pris.regnPris(kategoriArr[j], antallDager);
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

}
