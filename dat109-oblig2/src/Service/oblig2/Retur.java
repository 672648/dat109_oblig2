package Service.oblig2;

import java.time.LocalDate;
import utilitet.dat109.Pris;
import java.time.LocalTime;

public class Retur extends Pris{
	private LocalDate dato;
	private LocalTime klokkeslett;
	private int kilometerStand;
	
	public int regning(Utleie utleie, boolean utleieSted) {
		if (utleieSted) {
			int regning = regnPris("hei", 3);
		}
		
	}
}
