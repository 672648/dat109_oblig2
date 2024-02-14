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

import ServiceInterfaces.oblig2.ISok;
import personer.oblig2.Kunde;
import utilitet.dat109.Pris;
import utsted.dat109.Bil;
import utsted.dat109.Kategori;
import utsted.dat109.UtleieKontor;
import utsted.dat109.UtleieKontorer;

public class Sok implements ISok {

	private UtleieKontorer kontorer;

	public Sok() {
		kontorer = new UtleieKontorer();
	}

	@Override
	public List<UtleieKontor> hentKontorListAdresse(String adresse) {
		return kontorer.hentKontorAdresse(adresse);
	}

	@Override
	public List<Bil> hentBilKategori(String kategori, List<UtleieKontor> kontorer) {
		List<Bil> bilKategori = new ArrayList();
		for (UtleieKontor kontor : kontorer) {
			bilKategori = kontor.faListe(kategori);
		}
		return bilKategori;
	}

	@Override
	public int hentPris() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reserver(Kunde kunde, LocalDateTime dato, int antallDager, String kategori) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sok(String kategori, LocalDate startDato, LocalDate sluttDato, String adresse) {
		List<UtleieKontor> kontorer = hentKontorListAdresse(adresse);
		int antallDager = (int) ChronoUnit.DAYS.between(startDato, sluttDato);

	}

	public int lagDropDown(List<UtleieKontor> kontorer, int antallDager) {
		Pris pris = new Pris();
		String[] dropDownValg = new String[5];

		for (int i = 0; i < kontorer.size(); i++) {
			for(int j = 0; j < 5; j++) {
				int q = i*5;
				dropDownValg[q] = kontorer.get(i).getKategori(j) + " "
						+ pris.regnPris(kontorer.get(i).getKategori(j), antallDager);
			}
		}

		JComboBox<String> comboBox = new JComboBox<>(dropDownValg);
		comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                int valgtIndex = combo.getSelectedIndex();
                System.out.println("Valgt indeks: " + valgtIndex);
                System.out.println("Valgt verdi: " + dropDownValg[valgtIndex]);
            }
        });
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(comboBox);
		frame.pack();
		frame.setVisible(true);
		return 100;
	}

}
