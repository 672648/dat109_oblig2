package utilitet.dat109;

import java.util.Random;

public class Utilitet {
	public static String[] gateAdresser = {
			"Bergenveien 2",
			"Oslogate 1",
			"Karl Johans gate 10",
			"Trondheimsvei 129",
			"Gardermoen 34",
			"Kristiands vei 20",
			"Balders gate 48",
			"Auglandsveien 40"
			
	};
	
	public static String[] postSteder = {
			"Bergen",
			"Oslo",
			"Trondheim",
			"Kristiandsand",
			"gardermoen"
	};
	
	public static String[] regNr = genererRegNr();
	
	private static String[] genererRegNr() {
		String[] regnr = new String[50];
		Random random = new Random();
		for(int i = 0; i < regnr.length; i++) {
			String nr = "";
			for(int j = 0; j < 8; j++) {
				nr += Math.random()*8;
			}
			char bokstav1 = (char) (random.nextInt(26) + 'A');
			char bokstav2 = (char) (random.nextInt(26) + 'A');
			regnr[i] = String.valueOf(bokstav1) + String.valueOf(bokstav2) + " " + nr;
		}
		return regnr;
	}

	public static String[] merker = {
			"Honda",
			"Mazda",
			"Toyota",
			"Volvo",
			"Saab",
			"BMW",
			"Lamborghini"
	};
	
	public static String[] modeller = {
			"Superbil",
			"Duperbil",
			"Modell 1887",
			"Freshbil",
			"Fokus"
	};
	
	public static String[] farger = {
			"Gul bil",
			"Rød",
			"Grønn",
			"Blå",
			"Svart",
			"Grå",
			"Hvit"
			
	};
}
