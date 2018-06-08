package alltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import bd.BdTest;
import hello.*;
import junit.framework.JUnit4TestAdapter;
import selenium.InciManagerTests;
import steps.CucumberTest;

import org.junit.runners.Suite;

@RunWith(Suite.class)
@SuiteClasses({ BdTest.class, AgentTest.class, CampoTest.class, CheckTest.class, EnumIncidenciaTest.class,
		EtiquetaTest.class, IncidenciaMinTest.class, IncidenciaTest.class, LocationTest.class, MinToIncidenceTest.class,
		InciManagerTests.class, CucumberTest.class })
public class AllTests {
	public static JUnit4TestAdapter suite() {
		return new JUnit4TestAdapter(AllTests.class);
	}
}