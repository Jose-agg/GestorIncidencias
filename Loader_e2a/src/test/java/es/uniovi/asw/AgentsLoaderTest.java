package es.uniovi.asw;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.uniovi.asw.business.AgentService;
import es.uniovi.asw.conf.ServicesFactory;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.reader.Loader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AgentsLoaderTest {

	private EntityManagerFactory factory;
	private Loader loader;
	private AgentService agService;

	@Before
	public void setUp()
	{
		agService = ServicesFactory.getAgentService();
		factory = Persistence.createEntityManagerFactory("test");
		loader = new Loader("excel", 
				"src/test/resources/test1.xlsx", 
				"src/test/resources/TiposAgentes.csv");
		
	}

    @Test
    public void test1_LoadFromExcel() throws IOException, BusinessException 
    {
    	// Saca la lista de agentes del fichero Excel
		List<Agent> Agents = loader.readAgents(loader.getFormato(), loader.getFilePathExcel());
		
		Agent ag1 = Agents.get(0);
		assertTrue(ag1.getNombre() != null);
		assertTrue(ag1.getEmail() != null);
		assertTrue(ag1.getNombreUsuario() != null);
		
		Agent ag2 = Agents.get(Agents.size()-1);
		assertTrue(ag2.getNombre() != null);
		assertTrue(ag2.getEmail() != null);
		assertTrue(ag2.getNombreUsuario() != null);
    }

    @Test
    public void test2_FindOnDB() throws BusinessException {
    	EntityManager mapper = factory.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
    	
    	List<Agent> agents = agService.findAllAgents();
    	System.out.println(agents.size());
    	assertTrue(agents.size() > 0);
    	
    	Agent agente = new Agent("Persona1", "sin contrasenia");
    	assertTrue(!agService.isAgentInDatabase( agente )); // busca por nombre de usuario
    	
    	trx.commit();
		mapper.close();
    }
  
    @Test
    public void test3_InsertOnDB() throws BusinessException {
    	EntityManager mapper = factory.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
    	
    	List<Agent> agents_1 = agService.findAllAgents();
    	assertTrue( agents_1.size() > 0);
    	
    	Agent agente = new Agent("PruebaDeTest3", "123456", "Person", 1, "abcdefg120987", "Pepe", "Diaz", "prueba@hotmail.com");
    	agService.insertAgent( agente );
    	
    	List<Agent> agents_2 = agService.findAllAgents();
    	assertTrue( agents_1.size() < agents_2.size());
    	
    	List<Agent> agente_a_borrar = new ArrayList<Agent>();
    	agente_a_borrar.add( agente );
    	agService.deleteAllAgents( agente_a_borrar );
    	
    	List<Agent> agents_3 = agService.findAllAgents();
    	assertTrue( agents_3.size() < agents_2.size());
    	
    	trx.commit();
		mapper.close();
    }
    
}
