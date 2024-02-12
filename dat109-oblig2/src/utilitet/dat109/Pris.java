package utilitet.dat109;

public class Pris {
	private int dagsPrisA = 100;
	private int dagsPrisB = 100;
	private int dagsPrisC = 100;
	private int dagsPrisD = 100;
	private int dagsPrisE = 100;
	
	public Pris() {
		
	}
	
	public int regnPris(String kategori ,int antallDager) {
		int sumPris = 0;
		
		switch (kategori) 
		{
		case "A":
			sumPris = dagsPrisA * antallDager;
			break;
		case "B":
			sumPris = dagsPrisB * antallDager;
			break;
		case "C":
			sumPris = dagsPrisC * antallDager;
			break;
		case "D":
			sumPris = dagsPrisD * antallDager;
			break;
		case "E":
			sumPris = dagsPrisE * antallDager;
			break;
		}
		
		return sumPris;
	}
}
