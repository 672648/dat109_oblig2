package JunitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

class UtleieTest {
	private int id;
	private String regNummer;
	private String kategori;
	private int antallDager;
	private int kilometerStand;
	private LocalDate dato;
	private LocalTime tid;
	private Utleie utleieTest;
	private JFrame f;
	
	@Test
	void testUtleie() {
		this.id = 12;
		this.regNummer = "1A2B3C4D";
		this.kategori = "A";
		this.antallDager = 3;
		this.kilometerStand = 150;
		
		String input = (String) JOptionPane.showInputDialog(f, "Skriv inn dato:");
		this.dato = LocalDate.parse(input);
		assertEquals(dato, LocalDate.parse("2020-02-20"));
		assertFalse(dato.equals(LocalDate.parse("2020-02-02")));
		
		input = (String) JOptionPane.showInputDialog(f, "Skriv inn tid:");
		this.tid = LocalTime.parse(input);
		assertEquals(tid, LocalTime.parse("16:00:00"));
		assertFalse(tid.equals(LocalTime.parse("15:15:15")));
		
		utleieTest = new Utleie(id, regNummer, kilometerStand, kategori, antallDager);
		assertEquals(utleieTest.getId(), 12);
		assertEquals(utleieTest.getRegNummer(), "1A2B3C4D");
		assertEquals(utleieTest.getKategori(), "A");
		assertEquals(utleieTest.getAntallDager(), 3);
		assertEquals(utleieTest.getKilometerStand(), 150);
		assertEquals(utleieTest.getKredittNummer(), "12341234");
		
		assertFalse(utleieTest.getId() == 10);
		assertFalse(utleieTest.getRegNummer() == "1234");
		assertFalse(utleieTest.getKategori() == "B");
		assertFalse(utleieTest.getAntallDager() == 5);
		assertFalse(utleieTest.getKilometerStand() == 100);
		assertFalse(utleieTest.getKredittNummer() == "1234");
		
		utleieTest.setDato(dato);
		utleieTest.setTid(tid);
		
		assertEquals(utleieTest.getDato(), LocalDate.parse("2020-02-20"));
		assertEquals(utleieTest.getTid(), LocalTime.parse("16:00:00"));
		
		assertFalse(utleieTest.getDato() == LocalDate.parse("2020-02-20"));
		assertFalse(utleieTest.getTid() == LocalTime.parse("12:30:15"));
	}

}
