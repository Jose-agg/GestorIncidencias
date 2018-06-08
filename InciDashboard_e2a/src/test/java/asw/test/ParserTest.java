package asw.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import asw.Application;
import asw.services.InsercionDatosService;
import asw.streamKafka.parser.ParserIncidencia;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class ParserTest 
{
	
	@Autowired
	private ParserIncidencia parserIncidencia;
	
	@Autowired
	private InsercionDatosService insDatos;
	
	@Test
	public void parseadorCampos() {
		insDatos.init();
		
		String incidencia = "Carmena@Fuego en Oviedo@El parque San Francisco esta quemandose a causa de un cigarrillo mal apagado@"
							+ "43.3616142$-5.8506767@Fuego$Parque@Temperatura:Alta$Fuego:Extremo@1521893518784";
		
		String inci_json = parserIncidencia.parseToIncidence(incidencia);
		
		Assert.assertTrue( inci_json.contains("\"nombre_incidencia\" : \"Fuego en Oviedo\"") );
		Assert.assertTrue( inci_json.contains("\"estado\" : \"ABIERTO\"") );
	}
}
