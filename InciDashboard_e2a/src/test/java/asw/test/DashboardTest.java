package asw.test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import asw.entities.Agent;
import asw.entities.Campo;
import asw.entities.Incidencia;
import asw.entities.Location;
import asw.entities.Operator;
import asw.entities.Status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DashboardTest {
	
	private Agent a1, a2, a3;
	private Location l1, l2, l3, l4, l5;
	private Incidencia inc1, inc2, inc3, inc4, inc5;
	private Campo c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	
	@Before
	public void setUp() throws Exception {
		//	public Agent(String contrasena, String nombreUsuario, String kind, long kindCode, String dni, String nombre,

		//String apellidos, String email
		
		a1 = new Agent("123456","Pablo", "Entity", 1, "111111Z", "Pablo", "Ramirez", "pablo@hotmail.com");
		a2 = new Agent("123456","Juan", "Entity", 1, "211111Z", "Juan", "Martinez", "juan@hotmail.com");
		a3 = new Agent("123456","Alberta", "Entity", 1, "311111Z", "Alberta", "Martinez", "alberta@hotmail.com");
		
		l1 = new Location(-10.0, 3.0);
		l2 = new Location(10.0, 1.0);
		l3 = new Location(20.0, 2.0);
		l4 = new Location(-99.0, 7.0);
		l5 = new Location(-22, -10.0);
		
		inc1 = new Incidencia("Incidencia 1", l1, a1, Status.ABIERTO);
		inc2 = new Incidencia("Incidencia 2", l2, a2, Status.CERRADO);
		inc3 = new Incidencia("Incidencia 3", l3, a3, Status.ANULADA);
		inc4 = new Incidencia("Incidencia 4", l4, a1, Status.EN_PROCESO);
		inc5 = new Incidencia("Incidencia 5", l5, a3, Status.ANULADA);
		
		a1.addIncidencia(inc1);
		a1.addIncidencia(inc4);
		a2.addIncidencia(inc2);
		a3.addIncidencia(inc3);
		a3.addIncidencia(inc5);
		
		c1 = new Campo("propiedad", "valor", inc1);
		c2 = new Campo("nombre", "pablo", inc1);
		c3 = new Campo("apellido", "diaz", inc1);
		c4 = new Campo("ciudad", "gijon", inc2);
		c5 = new Campo("estudia", "informatica", inc3);
		c6 = new Campo("curso", "tercero", inc3);
		c7 = new Campo("lugar", "oviedo", inc3);
		c8 = new Campo("prueba", "valor prueba", inc4);
		c9 = new Campo("propiedad", "de otra prueba", inc5);
		c10 = new Campo("asignatura", "ASW", inc5);
		
		inc1.addCampo(c1); inc1.addCampo(c2); inc1.addCampo(c3);
		inc2.addCampo(c4);
		inc3.addCampo(c5); inc3.addCampo(c6); inc3.addCampo(c7);
		inc4.addCampo(c8);
		inc5.addCampo(c9); inc5.addCampo(c10);
	}
	
	@Test
	public void testAgentes() {
		Assert.assertTrue(a1.getNombreUsuario() == "Pablo");
		Assert.assertTrue(a2.getNombreUsuario() == "Juan");
		Assert.assertTrue(a3.getNombreUsuario() == "Alberta");
		
		Assert.assertTrue(a1.getTipo() == "Entity");
		Assert.assertTrue(a2.getTipo() == "Entity");
		Assert.assertTrue(a3.getTipo() == "Entity");
		
		Assert.assertTrue(a1.getIncidencias().size() == 2);
		Assert.assertTrue(a2.getIncidencias().size() == 1);
		Assert.assertTrue(a3.getIncidencias().size() == 2);
	}
	
	
	@SuppressWarnings("serial")
	@Test
	public void getIncidenciasOperariosYAgentes() {
		// Creo un operario y le asigno 3 incidencias
		Operator op = new Operator("Pablo", "123456", new HashSet<Incidencia>() {{ add(inc1); 
																				  add(inc2); 
																				  add(inc3); }});

		// Compruebo que tiene tres incidencias asignadas
		Assert.assertTrue(op.getIncidencias().size() == 3);
		
		// Compruebo el estado de sus incidencias
		List<Incidencia> incidences = op.getIncidencias().stream()
														.filter(inc -> inc.getEstado().equals(Status.ABIERTO))
														.collect(Collectors.toList());
		Assert.assertTrue(incidences.size() == 1);
		
		incidences = op.getIncidencias().stream()
				.filter(inc -> inc.getEstado().equals(Status.CERRADO))
				.collect(Collectors.toList());
		Assert.assertTrue(incidences.size() == 1);
		
		incidences = op.getIncidencias().stream()
				.filter(inc -> inc.getEstado().equals(Status.ANULADA))
				.collect(Collectors.toList());
		Assert.assertTrue(incidences.size() == 1);
		
		// Compruebo que el agente 1 ha enviado más incidencias que el agente 2
		Assert.assertTrue(a1.getIncidencias().size() > a2.getIncidencias().size());
	}
	
	@Test
	public void getCamposIncidencias() {
		Assert.assertTrue(c1.getincidencia().equals(inc1));
		Assert.assertTrue(c2.getincidencia().equals(inc1));
		Assert.assertTrue(c5.getincidencia().equals(inc3));
		Assert.assertTrue(c6.getincidencia().equals(inc3));
		Assert.assertTrue(c10.getincidencia().equals(inc5));
		
		Assert.assertTrue(inc1.getCampos().size() == 3);
		Assert.assertTrue(inc2.getCampos().size() == 1);
	}
	
}