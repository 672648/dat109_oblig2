package Service.oblig2;

import java.time.LocalDate;
import utilitet.dat109.Pris;
import java.time.LocalTime;

public class Retur extends Pris{
	private LocalDate dato;
	private LocalTime klokkeslett;
	private int kilometerStand;
	private int regning;
	
	public Retur(int kilometerStand, String kategori, int antallDager, boolean sammeAdresse) {
		this.dato = LocalDate.now();
		this.klokkeslett = LocalTime.now();
		this.kilometerStand = kilometerStand;
		this.regning = regning(kategori, antallDager, sammeAdresse);
	}
	
	private int regning(String kategori, int antallDager, boolean sammeLokasjon) {
		int pris = 0;
		
		if (sammeLokasjon) {
			pris = regnPris(kategori, 3);
		} 
		else {
			pris = regnPrisMedGebyr(kategori, antallDager);
		}
		
		return pris;
	}
	
	public int getRegning() {
		return this.regning;
	}
}
