package bd;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import manager.InciManagerApplication;
import manager.entities.Agent;
import manager.entities.Campo;
import manager.entities.Etiqueta;
import manager.entities.Incidencia;
import manager.entities.Location;
import manager.services.GetAgentService;
import manager.services.CampoService;
import manager.services.EtiquetaService;
import manager.services.IncidenciaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InciManagerApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class BdTest {

	@Autowired
	GetAgentService agentService;
	@Autowired
	IncidenciaService incidenciaService;
	@Autowired
	EtiquetaService etiquetasService;
	@Autowired
	CampoService campoService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAñadirAgente() throws Exception {

		Agent agent = new Agent();

		String nombreUsuario = "Dani123";
		String password = "123";
		String kind = "Person";
		Long kindcode = 1L;
		String dni = "345567678G";
		String nombre = "Daniel";
		String apellidos = "Suarez";
		String email = "danisua@uniovi.es";

		Incidencia i1 = new Incidencia();
		Incidencia i2 = new Incidencia();

		agent.getIncidencias().add(i1);
		agent.getIncidencias().add(i2);

		agent.setUsername(nombreUsuario);
		agent.setPassword(password);
		agent.setKind(kind);
		agent.setKindCode(kindcode);
		agent.setDni(dni);
		agent.setNombre(nombre);
		agent.setApellidos(apellidos);
		agent.setEmail(email);

		agentService.addAgent(agent);
		Agent a = agentService.buscarAgentePorUsuario(nombreUsuario);
		assertNotNull(a);
		agentService.elimnarAgent(agent.getId());
		assertNull(agentService.buscarAgentePorUsuario(nombreUsuario));
	}

	@Test
	public void testAñadirIncidencia() {
		Incidencia im = new Incidencia();

		im.setNombre("Fuego en Calle Uría");
		im.setDescripcion("Incendiose la calle");

		Etiqueta e1 = new Etiqueta();
		e1.setNombre("Fuego");
		Etiqueta e2 = new Etiqueta();
		e1.setNombre("Agua");

		Set<Etiqueta> listaE = new HashSet<Etiqueta>();
		listaE.add(e1);
		listaE.add(e2);

		Campo c1 = new Campo();
		c1.setClave("Temperatura");
		c1.setValor("45");

		Set<Campo> listaC = new HashSet<Campo>();
		listaC.add(c1);

		Location l = new Location(23.362598, -32.23658);

		im.setEtiquetas(listaE);
		im.setCampos(listaC);
		im.setLocalizacion(l);

		Agent agent = new Agent();

		agent.setUsername("pruebaBD");
		agent.setPassword("PRUEBABD123fght56gfdsf");
		agent.setKind("Entity");
		agent.setKindCode(1L);
		agent.setDni("sdeefdgfstue56hbrs6ywrh5bts");
		agent.setNombre("pruebaBD");
		agent.setApellidos("García");
		agent.setEmail("pruebaBD@uniovi.es");

		agentService.addAgent(agent);

		incidenciaService.setAgent(agent);
		assertEquals(agent, incidenciaService.getAgent());

		Incidencia incidenciaEnviada = incidenciaService.nuevaIncidencia(im);

		assertTrue(im == incidenciaEnviada);

		// Comprobamos que la incidencia fue añadida
		assertNotNull(incidenciaService.getIncidencia(incidenciaEnviada.getId()));

		List<Etiqueta> lista2 = etiquetasService.obtenerEtiquetas(incidenciaEnviada.getId());
		assertNotNull(lista2);

		List<Campo> listaCampos2 = campoService.obtenerCampos(incidenciaEnviada.getId());
		assertNotNull(listaCampos2);

		agentService.elimnarAgent(agent.getId());
	}

}
