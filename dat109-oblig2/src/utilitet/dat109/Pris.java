package utilitet.dat109;

public class Pris {
	private int dagsPrisA = 100;
	private int dagsPrisB = 150;
	private int dagsPrisC = 190;
	private int dagsPrisD = 200;
	private int dagsPrisE = 300;
	private int gebyr = 50;
	
	
	protected int regnPris(String kategori ,int antallDager) {
		int sum = 0;
		
		switch (kategori) 
		{
		case "A":
			sum = dagsPrisA * antallDager;
			break;
		case "B":
			sum = dagsPrisB * antallDager;
			break;
		case "C":
			sum = dagsPrisC * antallDager;
			break;
		case "D":
			sum = dagsPrisD * antallDager;
			break;
		case "E":
			sum = dagsPrisE * antallDager;
			break;
		}
		
		return sum;
	}
	
	protected int regnPrisMedGebyr(String kategori, int antallDager) {
		int sum = 0;
		
		switch (kategori) 
		{
		case "A":
			sum = (dagsPrisA * antallDager) + gebyr;
			break;
		case "B":
			sum = (dagsPrisB * antallDager) + gebyr;
			break;
		case "C":
			sum = (dagsPrisC * antallDager) + gebyr;
			break;
		case "D":
			sum = (dagsPrisD * antallDager) + gebyr;
			break;
		case "E":
			sum = (dagsPrisE * antallDager) + gebyr;
			break;
		}
		
		return sum;
	}
}
