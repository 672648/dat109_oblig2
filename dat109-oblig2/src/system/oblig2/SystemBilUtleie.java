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
import utilitet.dat109.Informasjon;
import utsted.dat109.UtleieKontorer;

public class SystemBilUtleie {
	private JFrame f;
	private String input;
	private Kunde kunde;
	private Ansatt ansatt;
	private Sok sok;
	private Informasjon info;
	
	public SystemBilUtleie() {
		info = new Informasjon();
		start();
	}
	
	public void start() {
		opprettBruker();
		input = velgService();
		utforService();
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
	
	private void utforService() {
		switch (input) {
		case "reserver bil":
			sok = new Sok(kunde, utleieKontor);
			sok.startSok();
			info.leggTilReservasjon(sok.getReservasjon());
			JOptionPane.showMessageDialog(f, "Reservasjonen din har blitt bekreftet! \nDin ID er: " + sok.getReservasjon().getId(););
			break;
		case "utleie bil":
			input = JOptionPane.showInputDialog(f, "Skriv inn ID for reservasjonen din");
			info.lagUtleie(); //Hent kilometerStand og registreringsnummer
			
			break;
		case "returner bil":
			
			break;
		}
	}
}