package asw.test.steps;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import asw.Application;
import asw.entities.Agent;
import asw.services.AgentService;
import asw.services.InsercionDatosService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes=Application.class, loader=SpringBootContextLoader.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class LoginSteps {
  
  @Autowired
  private AgentService aService;
  int cantidadBase;
  
  @Autowired
  InsercionDatosService insDatos;
 
  @Given("^there are no users$")
  public void there_are_no_users() throws Throwable {
	insDatos.init();
    cantidadBase = aService.prueba();
  }

  @When("^I create a user \"([^\"]*)\" with password \"([^\"]*)\"$")
  public void i_create_a_user_with_password(String arg1, String arg2) throws Throwable {
     aService.addAgent(new Agent(arg1, arg2, "1"));
  }

  @Then("^The number of users is (\\d+)$")
  public void the_number_of_users_is(int arg1) throws Throwable {
     assertTrue(aService.prueba()==arg1+cantidadBase);

  }
  

}
