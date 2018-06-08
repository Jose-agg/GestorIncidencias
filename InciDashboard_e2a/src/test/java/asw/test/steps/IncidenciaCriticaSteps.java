package asw.test.steps;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import asw.Application;
import asw.entities.Campo;
import asw.entities.Incidencia;
import asw.entities.Status;
import asw.entities.TipoCampos;
import asw.services.IncidenceService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes=Application.class, loader=SpringBootContextLoader.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class IncidenciaCriticaSteps {
	
	@Autowired
	IncidenceService iService;
	Incidencia i ;

  
	@Given("^a critic incidence with one critic value$")
	public void a_critic_incidence_with_one_critic_value() throws Throwable {
		
	    Campo c = new Campo("temperatura", "Extrema", null, TipoCampos.CRITICO);
	    Incidencia i = new Incidencia("incP", null, null, Status.CERRADO);
	    Set<Campo> s = new HashSet<Campo>();
	    s.add(c);
	    i.setCampos(s);
	    i.setTipoIncidencia();
	    iService.addIncidence(i);
	}
	
	@When("^I search it$")
	public void i_search_it() throws Throwable {
		 i = iService.getIncidences()
				 .stream()
				 .filter(x -> x.getNombre().equals("incP"))
				 .findFirst()
				 .orElse(null);
	}
	
	@Then("^it had critic state$")
	public void  it_had_critic_state() throws Throwable {
		assertTrue(i.getTipoIncidencia().equals(TipoCampos.CRITICO));
	}

}
