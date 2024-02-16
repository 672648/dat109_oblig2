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
import utsted.dat109.Bil;
import utsted.dat109.UtleieKontor;
import utsted.dat109.UtleieKontorer;

public class SystemBilUtleie {
	private JFrame f;
	private String input;
	private String adresse;
	private Kunde kunde;
	private Ansatt ansatt;
	private Sok sok;
	private Informasjon info;
	private UtleieKontor kontor;
	
	public SystemBilUtleie() {
		info = new Informasjon();
		start();
	}
	
	public void start() {
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
				ansatt.startKontor();
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
			kunde = new Kunde();
			reserverBil();
			break;
		case "Utleie bil":
			utleieBil();
			break;
		case "Returner bil":
			returnerBil();
			break;
		case "Opprett kontor":
			opprettKontor();
			break;
		case "Opprett bil":
			opprettBil();
			break;
		}
	}
	
	private void reserverBil() {
		sok = new Sok(kunde, info.getUtleieKontor());
		sok.startSok();
		System.out.println(sok.getReservasjon().getId());
		info.leggTilReservasjon(sok.getReservasjon());
		JOptionPane.showMessageDialog(f, "Reservasjonen din har blitt bekreftet! \nDin ID er: " + sok.getReservasjon().getId());
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
	
	private void opprettKontor() {
		adresse = JOptionPane.showInputDialog(f, "Skriv inn gate adresse");
		String postSted = JOptionPane.showInputDialog(f, "Skriv inn poststed");
		String postNummer = JOptionPane.showInputDialog(f, "Skriv inn postnummer");
		int postNr = Integer.parseInt(postNummer);
		ansatt.lagKontor(adresse, postSted, postNr);
	}
	
	private void opprettBil() {
		adresse = JOptionPane.showInputDialog(f, "Skriv inn gate adresse");
		String regNummer = JOptionPane.showInputDialog(f, "Skriv inn registreringsnummer");
		String merke = JOptionPane.showInputDialog(f, "Skriv inn gate merke");
		String modell = JOptionPane.showInputDialog(f, "Skriv inn modell");
		String farge = JOptionPane.showInputDialog(f, "Skriv inn gate farge");
		String kategori = JOptionPane.showInputDialog(f, "Skriv inn gate kategori");
		String kilometerStand = JOptionPane.showInputDialog(f, "Skriv inn kilometerstand");
		int km = Integer.parseInt(kilometerStand);
		ansatt.lagBil(adresse, regNummer, merke, modell, farge, kategori, km);
	}
}