package steps;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
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
public class LoginFailedStep {
	
	@Autowired
	IncidenciaService iService;
	IncidenciaMin i ;
	@Autowired
	GetAgentService aService;
	Agent agente ;
	@Autowired
	AgentController aControler;

  
	String agent;
	
	@Then("^El agente no podra enviar incidencias")
	public void El_agente_no_podra_enviar_incidencias() throws Throwable {
//		assertEquals("error", agent);
//		i = new IncidenciaMin("hola" , "hola" , "hola" , "holA:adios");
//		i.setLatitud(7.9);
//		i.setLongitud(7.9);
//		Incidencia incidence = iService.addIncidencia(i);
//		Assert.isNull(incidence);
		
		
	}
	
	@Given("^un Usuario \"([^\"]*)\" Y contraseña \"([^\"]*)\" Y tipo \"([^\"]*)\"$")
	public void un_Usuario_Y_contraseña_Y_tipo(String name , String password, String kind) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//agent = aControler.showInfo(name, password, kind, null);
	}
	

	
	

}