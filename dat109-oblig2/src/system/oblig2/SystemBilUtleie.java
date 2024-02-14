package system.oblig2;

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
import utsted.dat109.UtleieKontorer;

public class SystemBilUtleie {
	private JFrame f;
	private String input;
	private Kunde kunde;
	private Ansatt ansatt;
	private Sok sok;
	private UtleieKontorer utleieKontor;
	private List<Reservasjon> reserver;
	private Utleie utleie;
	private Retur retur;
	
	public SystemBilUtleie() {
		reserver = new ArrayList();
		utleieKontor = new UtleieKontorer();
		start();
	}
	
	public void start() {
		opprettBruker();
		input = velgService();
		
		if (input == null) {
			System.exit(0);
		}
		
		switch (input) {
		case "reserver bil":
			sok = new Sok(kunde, utleieKontor);
			//begynn å filtrer
			//bekreft
			reserver.add(sok.getReservasjon());
			//Skriv melding at reservasjon har blitt bekreftet
			break;
		case "utleie bil":
			//utleie = new Utleie();// hent kilometerstang og registreringsnummer
			break;
		case "returner bil":
			retur = new Retur();
			break;
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
				ansatt = new Ansatt();
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
		switch (input) {
		case "kunde":
			String[] service = new String[3];
			service[0] = "reserver bil"; 
			service[1] = "utleie bil";
			service[2] = "returner bil";
			input = (String) JOptionPane.showInputDialog(f, "Service liste", "Velg hvilken service du vil bruke", JOptionPane.QUESTION_MESSAGE, null, service, service[0]);
			
			if (input == null) {
				System.exit(0);
			}
			
			break;
		case "ansatt":
			break;
		}
		
		return input;
	}
}