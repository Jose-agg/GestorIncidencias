package hello;

import static org.junit.Assert.*;

import org.junit.Test;

import manager.entities.Campo;
import manager.entities.Incidencia;
import manager.entities.TipoCampos;

public class CampoTest {

	@Test
	public void test() {
		Campo campo = new Campo();
		
		Long id = 1L;
		Incidencia i = new Incidencia();
		
		String clave = "Temperatura";
		String valor = "45 ºC";
		TipoCampos tipo = TipoCampos.CRITICO;
		
		campo.setId(id);
		campo.setIncidencia(i);
		campo.setClave(clave);
		campo.setValor(valor);
		campo.setTipo(tipo);
		assertEquals(id, campo.getId());
		assertEquals(i, campo.getIncidencia());
		assertEquals(clave, campo.getClave());
		assertEquals(valor, campo.getValor());
		assertEquals(tipo, campo.getTipo());
		
		assertEquals(clave + ":" + valor, campo.toString());
		
	}

}
