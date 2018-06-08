package asw.services;

import java.util.HashSet;
import java.util.Set;
//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.entities.Agent;
import asw.entities.Campo;
import asw.entities.CamposCriticos;
import asw.entities.Etiqueta;
import asw.entities.Incidencia;
import asw.entities.Location;
import asw.entities.Operator;
import asw.entities.Status;
import asw.entities.TipoCampos;

@Service
public class InsercionDatosService 
{
	
	@Autowired
	private AgentService agentsService;
	
	@Autowired
	private OperadorService operadoresService;
	
	@Autowired
	private IncidenceService inciService;
	
	@Autowired
	private RolesService rolesService;
	
	@Autowired
	private CamposCriticosService ccService;
	
	/**
	 * Esta clase no seria necesaria despues del despliegue
	 * ya que seran los propios modulos los que se encarguen de
	 * rellenar con datos las base de datos
	 */
	@SuppressWarnings("serial")
	//@PostConstruct
	public void init() {
		// Creamos los agentes y operarios y los añadimos a la bbdd
		//String contrasena, String nombreUsuario, String kind, long kindCode, String dni, String nombre,
		//String apellidos, String email) 
		Agent agente1 = new Agent("123456","Carmena", "Entity", 1, "111111Z", "Carmena", "Ramirez", "carmena@hotmail.com");
		Agent agente2 = new Agent("123456","JoseLuis", "Entity", 1, "211111Z", "JoseLuis", "Martinez", "joseLuis@hotmail.com");
		Agent agente3 = new Agent("123456","Alberta", "Entity", 1, "311111Z", "Alberta", "Martinez", "alberta@hotmail.com");
		
		agentsService.addAgent( agente1 );
		agentsService.addAgent( agente2 );
		agentsService.addAgent( agente3 );
		
		Operator op1 = new Operator("Pablo", "123456"); 
		op1.setRole(rolesService.getRoles()[1]);
		Operator op2 = new Operator("Pepe", "123456");
		op2.setRole(rolesService.getRoles()[0]);
		Operator op3 = new Operator("Juan", "123456"); 
		op3.setRole(rolesService.getRoles()[0]);
		
		operadoresService.addOperator( op1 );
		operadoresService.addOperator( op2 );
		operadoresService.addOperator( op3 );
		
		// Creo localizaciones
		Location l1 = new Location(12.1023, 33.100);
		Location l2 = new Location(-45.90003, 11.933);
		Location l3 = new Location(-31.9503, 31.9373);
		Location l4 = new Location(-1.094, -33.02);
		Location l5 = new Location(49.0239, -49.7199);
		Location l6 = new Location(0.94851, -5.0911);
		inciService.addLocation(l1);
		inciService.addLocation(l2);
		inciService.addLocation(l3);
		inciService.addLocation(l4);
		inciService.addLocation(l5);
		inciService.addLocation(l6);
		
		// Creamos las incidencias
		Incidencia inc1 = new Incidencia("Incidencia 1", l1, agente1, Status.ABIERTO);
		Incidencia inc2 = new Incidencia("Incidencia 2", l2, agente1, Status.CERRADO);
		Incidencia inc3 = new Incidencia("Incidencia 3", l3, agente2, Status.ANULADA);
		Incidencia inc4 = new Incidencia("Incidencia 4", l4, agente2, Status.ABIERTO);
		Incidencia inc5 = new Incidencia("Incidencia 5", l5, agente3, Status.EN_PROCESO);
		Incidencia inc6 = new Incidencia("Incidencia 6", l6, agente3, Status.ABIERTO);
				
		// Creamos campos para incidencias y los añadimos a la bbdd
		Campo c1 = new Campo("propiedad", "valor");
		c1.setTipo(TipoCampos.NO_CRITICO);
		Campo c2 = new Campo("nombre", "pablo");
		c2.setTipo(TipoCampos.NO_CRITICO);
		Campo c3 = new Campo("apellido", "diaz");
		c3.setTipo(TipoCampos.NO_CRITICO);
		Campo c4 = new Campo("ciudad", "gijon");
		c4.setTipo(TipoCampos.NO_CRITICO);
		Campo c5 = new Campo("estudia", "informatica");
		c5.setTipo(TipoCampos.NO_CRITICO);
		Campo c6 = new Campo("curso", "tercero");
		c6.setTipo(TipoCampos.NO_CRITICO);
		Campo c7 = new Campo("lugar", "oviedo");
		c7.setTipo(TipoCampos.NO_CRITICO);
		Campo c8 = new Campo("prueba", "valor prueba");
		c8.setTipo(TipoCampos.NO_CRITICO);
		Campo c9 = new Campo("propiedad", "de otra prueba");
		c9.setTipo(TipoCampos.NO_CRITICO);
		Campo c10 = new Campo("asignatura", "ASW");
		c10.setTipo(TipoCampos.NO_CRITICO);
		
		Set<Campo> campos1 = new HashSet<Campo>() {{ add(c1); add(c2); }};
		Set<Campo> campos2 = new HashSet<Campo>() {{ add(c3); }};
		Set<Campo> campos3 = new HashSet<Campo>() {{ add(c4); add(c5); add(c6); }};
		Set<Campo> campos4 = new HashSet<Campo>() {{ add(c7); }};
		Set<Campo> campos5 = new HashSet<Campo>() {{ add(c8); }};
		Set<Campo> campos6 = new HashSet<Campo>() {{ add(c9); add(c10); }};
				
		inciService.addCampos( campos1 );
		inciService.addCampos( campos2 );
		inciService.addCampos( campos3 );
		inciService.addCampos( campos4 );
		inciService.addCampos( campos5 );
		inciService.addCampos( campos6 );
		
		// Creamos etiquetas
		Etiqueta e1 = new Etiqueta("prueba");
		Etiqueta e2 = new Etiqueta("prueba2");
		Etiqueta e3 = new Etiqueta("prueba3");
		Etiqueta e4 = new Etiqueta("prueba4");
		Etiqueta e5 = new Etiqueta("prueba5");
		Etiqueta e6 = new Etiqueta("prueba6");
		
		Set<Etiqueta> etiquetas1 = new HashSet<Etiqueta>() {{ add(e1); add(e2); }};
		Set<Etiqueta> etiquetas2 = new HashSet<Etiqueta>() {{ add(e3); add(e4); }};
		Set<Etiqueta> etiquetas3 = new HashSet<Etiqueta>() {{ add(e5); add(e6); }};
		
		inciService.addEtiqueta(etiquetas1);
		inciService.addEtiqueta(etiquetas2);
		inciService.addEtiqueta(etiquetas3);
		
		// Asignamos campos a incidencias
		inciService.addCamposAIncidencia(inc1, campos1);
		inciService.addCamposAIncidencia(inc2, campos2);
		inciService.addCamposAIncidencia(inc3, campos3);
		inciService.addCamposAIncidencia(inc4, campos4);
		inciService.addCamposAIncidencia(inc5, campos5);
		inciService.addCamposAIncidencia(inc6, campos6);
		
		// Asignamos etiquetas a incidencias
		inciService.addEtiquetasAIncidencia(inc1, etiquetas1);
		inciService.addEtiquetasAIncidencia(inc3, etiquetas2);
		inciService.addEtiquetasAIncidencia(inc6, etiquetas3);
		
		// Actualizamos incidencias en la bbdd
		inciService.addIncidence( inc1 );
		inciService.addIncidence( inc2 );
		inciService.addIncidence( inc3 );
		inciService.addIncidence( inc4 );
		inciService.addIncidence( inc5 );
		inciService.addIncidence( inc6 );
		
		// Actualizamos las localizaciones
		l1.setIncidence(inc1);
		l2.setIncidence(inc2);
		l3.setIncidence(inc3);
		l4.setIncidence(inc4);
		l5.setIncidence(inc5);
		l6.setIncidence(inc6);
		
		inciService.addLocation( l1 );
		inciService.addLocation( l2 );
		inciService.addLocation( l3 );
		inciService.addLocation( l4 );
		inciService.addLocation( l5 );
		inciService.addLocation( l6 );
		
		// Actualizamos los campos
		inciService.addCampos( campos1 );
		inciService.addCampos( campos2 );
		inciService.addCampos( campos3 );
		inciService.addCampos( campos4 );
		inciService.addCampos( campos5 );
		inciService.addCampos( campos6 );
		
		// Actualizamos las etiquetas
		inciService.addEtiqueta(etiquetas1);
		inciService.addEtiqueta(etiquetas2);
		inciService.addEtiqueta(etiquetas3);
		
		// Actualizamos las incidencias que han mandado los agentes
		agente1.addIncidencia(inc1);
		agente1.addIncidencia(inc2);
		agente2.addIncidencia(inc3);
		agente2.addIncidencia(inc4);
		agente3.addIncidencia(inc5);
		agente3.addIncidencia(inc6);
		agentsService.actualizarAgente(agente1);
		agentsService.actualizarAgente(agente2);
		agentsService.actualizarAgente(agente3);
		
		// Actualizamos las incidencias asignadas a operarios
		inc1.setOperadorAsignado( op2 );
		inc2.setOperadorAsignado( op2 );
		inc3.setOperadorAsignado( op2 );
		inc4.setOperadorAsignado( op2 );
		inc5.setOperadorAsignado( op3 );
		inc6.setOperadorAsignado( op3 );
		
		// Actualizamos las incidencias a NO CRÍTICAS
		inc1.setTipoIncidencia();
		inc2.setTipoIncidencia();
		inc3.setTipoIncidencia();
		inc4.setTipoIncidencia();
		inc5.setTipoIncidencia();
		inc6.setTipoIncidencia();
		
		inciService.addIncidence( inc1 );
		inciService.addIncidence( inc2 );
		inciService.addIncidence( inc3 );
		inciService.addIncidence( inc4 );
		inciService.addIncidence( inc5 );
		inciService.addIncidence( inc6 );
		
		op2.addIncidencia(inc1);
		op2.addIncidencia(inc2);
		op2.addIncidencia(inc3);
		op2.addIncidencia(inc4);
		op3.addIncidencia(inc5);
		op3.addIncidencia(inc6);
		operadoresService.actualizarOperario( op1 ); // no es realmente necesario
		operadoresService.actualizarOperario( op2 );
		operadoresService.actualizarOperario( op3 );
		
		// Creo y añado campos críticos
		ccService.addCampoCritico(new CamposCriticos("Temperatura", "Extrema"));
		ccService.addCampoCritico(new CamposCriticos("Fuego", "Llamaradas"));
		ccService.addCampoCritico(new CamposCriticos("Lluvia", "Intensa"));
	}
	
}

