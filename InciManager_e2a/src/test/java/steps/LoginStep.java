package steps;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import manager.InciManagerApplication;
import manager.controllers.AgentController;
import manager.entities.Agent;
import manager.entities.Incidencia;
import manager.entities.IncidenciaMin;
import manager.services.GetAgentService;
import manager.services.IncidenciaService;


@ContextConfiguration(classes=InciManagerApplication.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
@ActiveProfiles("test")
public class LoginStep {
	
	@Autowired
	IncidenciaService iService;
	IncidenciaMin i ;
	@Autowired
	GetAgentService GetAgentService;
	Agent agent ;
	@Autowired
	AgentController aControler;

  

	
	@Then("^El agente podra enviar incidencias")
	public void El_agente_podra_enviar_incidencias() throws Throwable {
		i = new IncidenciaMin("hola" , "hola" , "hola" , "holA:adios");
		i.setLatitud(7.9);
		i.setLongitud(7.9);
		Incidencia incidence = iService.addIncidencia(i);
		Assert.notNull(incidence);
		GetAgentService.elimnarAgent(agent.getId());
		
	}
	
	@Given("^un Agente \"([^\"]*)\" Y contraseña \"([^\"]*)\" Y tipo \"([^\"]*)\"$")
	public void un_Agente_Y_contraseña_Y_tipo(String name , String password, String kind) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		agent = new Agent();
		String nombreUsuario = "Pepe";
		Long kindcode = 1L;
		String dni = "345567678Ghgjfgjfgh";
		String nombre = "Daniel";
		String apellidos = "Suarez";
		String email = "danisua@uniovi.es";
		agent.setUsername(nombreUsuario);
		agent.setPassword(password);
		agent.setKind(kind);
		agent.setKindCode(kindcode);
		agent.setDni(dni);
		agent.setNombre(nombre);
		agent.setApellidos(apellidos);
		agent.setEmail(email);
		GetAgentService.addAgent(agent);
		
		String agente = aControler.showInfo(name, password, kind, null);
		assertEquals("index", agente);
		//GetAgentService.elimnarAgent(agent.getId());
	}

	
	

}