package hello;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import manager.InciManagerApplication;
import manager.entities.Campo;
import manager.entities.Etiqueta;
import manager.services.IncidenciaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InciManagerApplication.class)
@WebAppConfiguration
public class MinToIncidenceTest {

	@Autowired
	private IncidenciaService incidenciaService;

	@Test
	public void cogerEtiquetas1test() {
		String cad = "luz,fuego,destrucción";
		Set<Etiqueta> etiquetas = incidenciaService.cogerEtiquetas(cad, null);
		assertEquals(3, etiquetas.size());
	}

	@Test
	public void cogerEtiquetas2test() {
		String cad = "luz,luz,destrucción"; // Repetimos 2 etiquetas para comprobar que no se guarda una de ellas
		Set<Etiqueta> etiquetas = incidenciaService.cogerEtiquetas(cad, null);
		assertEquals(2, etiquetas.size());
	}

	@Test
	public void cogerEtiquetas3test() {
		String cad = "fuego";
		Set<Etiqueta> etiquetas = incidenciaService.cogerEtiquetas(cad, null);
		assertEquals(1, etiquetas.size());
	}

	@Test
	public void cogerEtiquetas4test() {
		String cad = "";
		Set<Etiqueta> etiquetas = incidenciaService.cogerEtiquetas(cad, null);
		assertTrue(etiquetas.isEmpty());
	}

	@Test
	public void cogerCampos1test() {
		String cam = "Mundo:Ruina,Temperatura:9000";
		Set<Campo> campos = incidenciaService.cogerCampos(cam, null);
		assertEquals(2, campos.size());
	}

	@Test
	public void cogerCampos2test() {
		String cam = "Mundo:Ruina,Mundo:Feliz"; // La clave se repite por lo que solo habrá un campo
		Set<Campo> campos = incidenciaService.cogerCampos(cam, null);
		assertEquals(1, campos.size());
	}

	@Test
	public void cogerCampos3test() {
		String cam = "Mundo:Ruina,Temperatura:Ruina"; // El valor si puede coincidir
		Set<Campo> campos = incidenciaService.cogerCampos(cam, null);
		assertEquals(2, campos.size());
	}

	@Test
	public void cogerCampos4test() {
		String cam = "";
		Set<Campo> campos = incidenciaService.cogerCampos(cam, null);
		assertTrue(campos.isEmpty());
	}
}