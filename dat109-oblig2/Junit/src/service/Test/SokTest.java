package service.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import Service.oblig2.Sok;
import ServiceInterfaces.oblig2.ISok;
import utsted.dat109.UtleieKontor;
import utsted.dat109.UtleieKontorer;

class SokTest {

	@Test
	void test() {
		UtleieKontorer kontorer = new UtleieKontorer();
		kontorer.lagKontorer("xd32", "mysen", 1850);
		ISok sok = new Sok();
		List<UtleieKontor> kontorList = kontorer.hentKontor();
		for(int i = 0; i<5; i++) {
			kontorList.get(0).lagBil("10", "noe", "noe", "noe", "A");
			kontorList.get(0).lagBil("10", "noe", "noe", "noe", "B");
			kontorList.get(0).lagBil("10", "noe", "noe", "noe", "C");
			kontorList.get(0).lagBil("10", "noe", "noe", "noe", "D");
			kontorList.get(0).lagBil("10", "noe", "noe", "noe", "E");
		}
		
	assertEquals(sok.lagDropDown(kontorList, 2), 0);
	}

}
