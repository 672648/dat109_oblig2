package utsted.dat109;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import utilitet.dat109.Adresse;

public class UtleieKontor {

	private List<Bil> biler;
	private Kategori kategori;
	private Adresse adresse;
	
	public UtleieKontor(String gateAdresse, String postSted, int postNummer) {
		this.biler = new ArrayList<Bil>();
		this.kategori = new Kategori();
		this.adresse = new Adresse(gateAdresse, postSted, postNummer);
	}
	
	public List<Bil> faListe(String kategori /*LocalDate startDato*/ /*, LocalDate sluttDato*/) {
		List<Bil> soket = biler;
		/*if(startDato == null) {
			startDato = LocalDate.now();
		}
		if(sluttDato == null) {
			sluttDato = startDato.plusDays(1);
		}
		
		for(Bil bil : biler) {
			if(!(bil.sjekkStartDato(sluttDato) && bil.sjekkSluttDato(startDato))) {
				soket.add(bil);
			}
		}
		if(soket.size() == 1){
			reservert(soket.get(0).getRegNr());
		}*/
		
		if(kategori != null) {
			soket = biler.stream().filter(bil -> bil.getKategori().equals(kategori)).toList();
		}
		return soket;
	}
	
	public Bil hentBilReg(String reg) {
		return biler.stream().filter(bil -> bil.getRegnr().equals(reg)).toList().get(0));
	}
	
	public String getKategori(int teller) {
		String kategoriStr = kategori.getKategori(teller);
		return kategoriStr;
	}
	//Legg til kilimeter her!!!!!!
	public void lagBil(String regnr, String merke, String modell, String farge, String kategori, int km) {
		Bil bil = new Bil(regnr, merke, modell, farge, kategori, adresse.getGateAdresse(), km );
		biler.add(bil);
		
		switch(kategori) {
		case "A":
			this.kategori.inkAntallA();
			break;
			
		case "B":
			this.kategori.inkAntallB();
			break;
			
		case "C":
			this.kategori.inkAntallC();
			break;
			
		case "D":
			this.kategori.inkAntallD();
			break;
			
		case "E":
			this.kategori.inkAntallE();
			break;
		}
		
		
	}
	
	public String getAdresse() {
		return adresse.getGateAdresse();
	}
	
	public void reservert(String kategori) {
		
		switch(kategori) {
		case "A":
			this.kategori.dekAntallA();
			break;
			
		case "B":
			this.kategori.dekAntallB();
			break;
			
		case "C":
			this.kategori.dekAntallC();
			break;
			
		case "D":
			this.kategori.dekAntallD();
			break;
			
		case "E":
			this.kategori.dekAntallE();
			break;
		}
		
	}
	
	public String getAntall(int teller) {
		String kategoriStr = kategori.getAntall(teller);
		return kategoriStr;
	}
}
