package hello;

import static org.junit.Assert.*;

import org.junit.Test;

import manager.util.Check;

public class CheckTest {

	@Test
	public void testCorrecto() {
		assertTrue(Check.validateEmail("usuario@correo.com"));
	}
	
	@Test
	public void testInorrecto() {
		assertFalse(Check.validateEmail("correoincorrecto"));
	}

}
