package utsted.dat109;

public class Kategori {

	private int antallA;
	private int antallB;
	private int antallC;
	private int antallD;
	private int antallE;

	public Kategori() {
		this.antallA = 0;
		this.antallB = 0;
		this.antallC = 0;
		this.antallD = 0;
		this.antallE = 0;
	}

	public int getAntallA() {
		return antallA;
	}

	public void inkAntallA() {
		this.antallA++;
	}

	public void dekAntallA() {
		this.antallA--;
	}

	public int getAntallB() {
		return antallB;
	}

	public void inkAntallB() {
		this.antallB++;
	}

	public void dekAntallB() {
		this.antallB--;
	}

	public int getAntallC() {
		return antallC;
	}

	public void inkAntallC() {
		this.antallC++;
	}

	public void dekAntallC() {
		this.antallC--;
	}

	public int getAntallD() {
		return antallD;
	}

	public void inkAntallD() {
		this.antallD++;
	}

	public void dekAntallD() {
		this.antallD--;
	}

	public int getAntallE() {
		return antallE;
	}

	public void inkAntallE() {
		this.antallE++;
	}

	public void dekAntallE() {
		this.antallE--;
	}

	public String getKategori(int teller) {
		String kategoriStr = "";

		switch (teller) {
		case 0:
			kategoriStr = "A";
			break;

		case 1:
			kategoriStr = "B";
			break;

		case 2:
			kategoriStr = "C";
			break;

		case 3:
			kategoriStr = "D";
			break;

		case 4:
			kategoriStr = "E";
			break;
		}
		return kategoriStr;
	}
	
	public String getAntall(int teller) {
		String kategoriStr = "";
		switch(teller) {
		case 0:
			kategoriStr = "antall: " + getAntallA() + " i kategori";
			break;
			
		case 1:
			kategoriStr = "antall: " + getAntallB() + " i kategori";
			break;
			
		case 2:
			kategoriStr = "antall: " + getAntallC() + "i kategori";
			break;
			
		case 3:
			kategoriStr = "antall: " + getAntallD() + "i kategori";
			break;
			
		case 4:
			kategoriStr = "antall:" +  getAntallE() + "i kategori";
			break;
		}
	}

}
