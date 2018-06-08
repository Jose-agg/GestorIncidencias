package asw.test.steps;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import asw.Application;
import asw.entities.Incidencia;
import asw.entities.Operator;
import asw.services.IncidenceService;
import asw.services.OperadorService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes=Application.class, loader=SpringBootContextLoader.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class OperatorListarIncidenciasSteps {
	@Autowired
	IncidenceService iService;
	
	@Autowired
	OperadorService oService;
	
	List<Incidencia> list = new ArrayList<>() ;
	Operator o ;
	
//	@Autowired
//	InsercionDatosService insDatos;

	@Given("^(\\d+) incidences$")
	public void incidences(int incidences) throws Throwable {
//	  insDatos.init();
	  Operator opPrueba = new Operator("NonAddedOperator2", "pepe2");
	  oService.addOperator( opPrueba );
	  
	  for(int i = 0 ; i< incidences ;i++){
		  Incidencia in = new Incidencia("i"+i,null,null,null);
		  o = oService.getOperatorByName("NonAddedOperator2") ;
		  o.addIncidencia(in) ;
		  in.setOperadorAsignado(o);
		  iService.addIncidence(in );
	  }
	}

	@When("^the operator list it$")
	public void the_operator_list_it() throws Throwable {
		list.addAll(iService.getIncidences() 
				.stream()
				.filter(x -> x.getOperadorAsignado() !=null && x.getOperadorAsignado().getUser().equals(o.getUser()))
				.collect(Collectors.toList()));
	}
	
	@Then("^he see (\\d+) incidences$")
	public void  he_see_incidences(int incidences) throws Throwable {
		assertTrue(list.size() == 3);
	}

}
