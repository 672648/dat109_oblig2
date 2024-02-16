package JunitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

class KundeTest {
	private JFrame f;
	private String fornavn;
	private String etternavn;
	private String tlf;
	
	@Test
	void testKunde() {
		String input = (String) JOptionPane.showInputDialog(f, "Skriv inn fornavn:");
		this.fornavn = input;
		assertEquals(fornavn, "per");
		assertFalse(fornavn.equals("paal"));
		
		input = (String) JOptionPane.showInputDialog(f, "Skriv inn etternavn:");
		this.etternavn = input;
		assertEquals(etternavn, "pedersen");
		assertFalse(etternavn.equals("Knutson"));
		
		input = (String) JOptionPane.showInputDialog(f, "Skriv inn telefonnummer:");
		this.tlf = input;
		assertEquals(tlf, "12345678");
		assertFalse(tlf.equals("87654321"));
	}

}
