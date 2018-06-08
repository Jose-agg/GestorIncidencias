package hello;

import static org.junit.Assert.*;
import org.junit.Test;

import manager.entities.IncidenciaMin;

public class IncidenciaMinTest {

	@Test
	public void test() {
		IncidenciaMin im = new IncidenciaMin();
		
		String nombre = "Fuego en Calle Uría";
		String descripcion = "Incendiose la calle";
		String etiqueta = "Fuego";
		String campo = "Temperatura:45";
		Double latitud = 23.362598;
		Double longitud = -32.23658;
		
		im.setNombre(nombre);
		im.setDescripcion(descripcion);
		im.setEtiqueta(etiqueta);
		im.setCampo(campo);
		im.setLatitud(latitud);
		im.setLongitud(longitud);
		
		assertEquals(nombre, im.getNombre());
		assertEquals(descripcion, im.getDescripcion());
		assertEquals(etiqueta, im.getEtiqueta());
		assertEquals(campo, im.getCampo());
		assertEquals(latitud, im.getLatitud());
		assertEquals(longitud, im.getLongitud());
		
	}

}
