package system.oblig2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Service.oblig2.Reservasjon;
import Service.oblig2.Retur;
import Service.oblig2.Sok;
import Service.oblig2.Utleie;
import personer.oblig2.Ansatt;
import personer.oblig2.Kunde;
import utilitet.dat109.Informasjon;
import utilitet.dat109.Utilitet;
import utsted.dat109.Bil;
import utsted.dat109.UtleieKontor;
import utsted.dat109.UtleieKontorer;

public class SystemBilUtleie {
	private JFrame f;
	private String input;
	private Kunde kunde;
	private Ansatt ansatt;
	private Informasjon info;
	private UtleieKontor kontor;
	private UtleieKontorer kontorer;
	
	public SystemBilUtleie() {
		info = new Informasjon();
	}
	
	public void start() {
		startKontor();
		while (true) {
			opprettBruker();
			input = velgService();
			utforService(input);
		}
	}
	
	private void opprettBruker() {
		f = new JFrame();
		input = JOptionPane.showInputDialog(f, "Velkommen, er du kunde eller ansatt?");
		
		if (input == null) {
			System.exit(0);
		}
		
		boolean kundeEllerAnsatt = true;
		
		do {
			switch(input) {
			case "kunde":
				JOptionPane.showMessageDialog(f, "Kunde er valgt, vennligst fyll inn nødvendig informasjon");;
				kunde = new Kunde();
				kundeEllerAnsatt = false;
				break;
			case "ansatt":
				JOptionPane.showMessageDialog(f, "Ansatt er valgt, trykk 'ok' for å gå videre");
				ansatt = new Ansatt(info.getUtleieKontor());
				kundeEllerAnsatt = false;
				break;
			default:
				input = JOptionPane.showInputDialog(f, "Beklager, men du må skrive om du er 'kunde' eller 'ansatt'");
				
				if (input == null) {
					System.exit(0);
				}
				
				break;
			} 
		}while (kundeEllerAnsatt);
	}
	
	private String velgService() {
		String[] service;
		
		switch (input) {
		case "kunde":
			service = new String[2];
			service[0] = "Reserver bil"; 
			service[1] = "Utleie bil";
			input = (String) JOptionPane.showInputDialog(f, "Service liste", "Velg hvilken service du vil bruke", JOptionPane.QUESTION_MESSAGE, null, service, service[0]);
			
			if (input == null) {
				System.exit(0);
			}
			
			break;
		case "ansatt":
			service = new String[5];
			service[0] = "Reserver bil"; 
			service[1] = "Utleie bil";
			service[2] = "Returner bil";
			service[3] = "Opprett ny kontor";
			service[4] = "Opprett ny bil";
			input = (String) JOptionPane.showInputDialog(f, "Service liste", "Velg hvilken service du vil bruke", JOptionPane.QUESTION_MESSAGE, null, service, service[0]);
			
			switch (input) {
			case "Reserver bil":
				kunde = new Kunde();
				break;
			}
			
			if (input == null) {
				System.exit(0);
			}
			break;
		}
		
		return input;
	}
	
	private void utforService(String input) {
		switch (input) {
		case "Reserver bil":
			reserverBil();
			break;
		case "Utleie bil":
			utleieBil();
			break;
		case "Returner bil":
			returnerBil();
			break;
		case "Opprett ny kontor":
			String[] kontorVerdier = ansatt.opprettKontor();
			lagKontor(kontorVerdier);
			break;
		case "Opprett ny bil":
			lagBil(ansatt.opprettBil());
			break;
		}
	}
	
	private void reserverBil() {
		info.sok();
		JOptionPane.showMessageDialog(f, "Reservasjonen din har blitt bekreftet! \nDin ID er: " + info.leggTilReservasjon());
	}
	
	private void utleieBil() {
		input = JOptionPane.showInputDialog(f, "Skriv inn ID for reservasjonen din");
		int id = Integer.parseInt(input);
		for (int i = 0; i < info.getReservasjonListe().size(); i++) {
			if (id == info.getReservasjonListe().get(i).getId()) {
				Reservasjon reservasjon = info.getReservasjonListe().get(i);
				String adresse = reservasjon.getGateAdresse();
				kontor = info.getKontor(adresse);
				List<Bil> biler = kontor.faListe(reservasjon.getKategori());
				String[] bilListe = new String[biler.size()];
				for (int k = 0; k < biler.size(); k++) {
					bilListe[k] = biler.get(k).getMerke() + " " + biler.get(k).getModell() + " " + biler.get(k).getFarge();
				}
				input = (String) JOptionPane.showInputDialog(f, "Liste over biler", "Velg en bil", JOptionPane.QUESTION_MESSAGE, null, bilListe, bilListe[0]);
				int index = 0;
				for (int n = 0; n < bilListe.length; n++) {
					if (input == bilListe[n]) {
						index = n;
					}
				}
				info.lagUtleie(id, biler.get(index).getRegnr(), biler.get(index).getKm(), biler.get(index).getKategori(), reservasjon.getAntallDager());
				JOptionPane.showMessageDialog(f, "En bil har nå blit utleid");
			} 
		}
	}
	
	private void returnerBil() {
		List<Utleie> utleieListe = info.getUtleieListe();
		String input = JOptionPane.showInputDialog(f, "Skriv inn ID");
		int id = Integer.parseInt(input);
		for (int i = 0; i < utleieListe.size(); i++) {
			if (id == utleieListe.get(i).getId()) {
				input = (String) JOptionPane.showInputDialog(f, "Skriv inn gate adressen til utleiekontoret");
				Bil bil = kontor.hentBilReg(utleieListe.get(i).getRegNummer()); 
				if (input == bil.getUtleiekontor()) {
					ansatt.lagRetur(utleieListe.get(i).getKilometerStand(), utleieListe.get(i).getKategori(), utleieListe.get(i).getAntallDager(), true);
				}
				else {
					ansatt.lagRetur(utleieListe.get(i).getKilometerStand(), utleieListe.get(i).getKategori(), utleieListe.get(i).getAntallDager(), false);
				}
			}
		}
	}
	
	public void lagKontor(String[] kontorVerdier) {
		info.leggTilKontorer(kontorVerdier[0], kontorVerdier[1], Integer.parseInt(kontorVerdier[2]));
		JOptionPane.showMessageDialog(f, "En ny kontor har blitt lagt til");
	}

	public void lagBil(String[] bilVerdier) {
		info.leggTilBil(bilVerdier);
		JOptionPane.showMessageDialog(f, "En ny bil har blitt lagt til");
	}
	
	public void startKontor() { //Generer kontorer og biler for programmet
		for (int i = 0; i < 8; i++) {
			int tilfeldigPoststed = (int) (Math.random() * 5);
			int tilfeldigPostNr = (int) (Math.random() * (9999 - 1000) + 1000);
			kontorer = info.getUtleieKontor();
			kontorer.lagKontorer(Utilitet.gateAdresser[i], Utilitet.postSteder[tilfeldigPoststed], tilfeldigPostNr);
			genererBiler();
		}
	}

	public void genererBiler() {
		for (UtleieKontor kontor : kontorer.hentKontor()) {
			kontor.lagBil(regNr(), merke(), modell(), farge(), kontor.getKategori((int) (Math.random() * 5)), km());
		}
	}

	public String regNr() {
		return Utilitet.regNr[(int) (Math.random() * 50)];
	}
	
	public String modell() {
		return Utilitet.modeller[(int) (Math.random() * 5)];
	}

	public String merke() {
		return Utilitet.merker[(int) (Math.random() * 7)];
	}

	public String farge() {
		return Utilitet.farger[(int) (Math.random() * 7)];
	}

	public String gateAdresse() {
		return Utilitet.gateAdresser[(int) (Math.random() * 8)];
	}

	public int km() {
		return (int) (Math.random() * 500000);
	}
	
	//Trenger dette bare for JUnit
	public Informasjon getInformasjon() {
		return info;
	}
}