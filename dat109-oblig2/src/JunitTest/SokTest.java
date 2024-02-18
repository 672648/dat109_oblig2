package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import Service.oblig2.Sok;
import personer.oblig2.Ansatt;
import system.oblig2.SystemBilUtleie;
import utilitet.dat109.Informasjon;
import utsted.dat109.UtleieKontorer;

class SokTest {

	@Test
	void test() {
		SystemBilUtleie bilSystem = new SystemBilUtleie();
		bilSystem.startKontor();
		Informasjon info = bilSystem.getInformasjon();
		//trenger system istedet når jeg får siste versjon
		info.sok();
		//Dette returnere ingenting men vil være godkjent hvis alt ble valgt
	}

}
