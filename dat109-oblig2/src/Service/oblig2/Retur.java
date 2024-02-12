package Service.oblig2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Retur {
	private LocalDate dato;
	private LocalTime klokkeslett;
	private int kilometerStand;
	private int gebyr = 50;
	
	public int regning(Utleie utleie, boolean utleieSted) {
		int regning = 0;
		//TODO - regn ut regningen for kunden og sjekk om bilen er levert på et annet utleiekontor
		
		
		
		//Sjekk om bilen er levert på en annen utleiekontor enn der den var utleid
		//Hvis true, legg på gebyr til regningen
		if (utleieSted) {
			regning = regning + gebyr;
		}
		
		return regning;
	}
}
