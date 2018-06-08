package hello;

import static org.junit.Assert.*;

import org.junit.Test;

import manager.entities.Etiqueta;
import manager.entities.Incidencia;

public class EtiquetaTest {

	@Test
	public void test() {

		Etiqueta e = new Etiqueta();
		
		Long id = 1L;
		String valor = "123456";
		Incidencia i = new Incidencia();
		
		e.setId(id);
		e.setIncidencia(i);
		e.setNombre(valor);
		
		assertEquals(id, e.getId());
		assertEquals(i, e.getIncidencia());
		assertEquals(valor, e.getNombre());
		
		assertEquals(valor, e.toString());
		
	}

}
