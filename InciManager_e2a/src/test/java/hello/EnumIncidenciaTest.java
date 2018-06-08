package hello;

import static org.junit.Assert.*;

import org.junit.Test;

import manager.enumeradoincidencia.EstadoIncidencia;

public class EnumIncidenciaTest {

	@Test
	public void test() {
		assertEquals("ABIERTA", EstadoIncidencia.ABIERTA.toString());
		assertEquals("PROCESANDO", EstadoIncidencia.PROCESANDO.toString());
		assertEquals("CERRADA", EstadoIncidencia.CERRADA.toString());
		assertEquals("ANULADA", EstadoIncidencia.ANULADA.toString());
	}

}
