package hello;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import manager.entities.Agent;
import manager.entities.Campo;
import manager.entities.Etiqueta;
import manager.entities.Incidencia;
import manager.entities.Location;
import manager.entities.Status;

public class IncidenciaTest {

	@Test
	public void toStringKafkatest() {
		Date fecha = new Date();
		Incidencia inc = new Incidencia();
		Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
		etiquetas.add(new Etiqueta().setNombre("Fuego"));
		etiquetas.add(new Etiqueta().setNombre("Parque"));
		Set<Campo> campos = new HashSet<Campo>();
		campos.add(new Campo().setClave("Fuego").setValor("Extremo"));
		campos.add(new Campo().setClave("Temperatura").setValor("Alta"));
		inc.setAgent(new Agent("Juan")).setNombre("Fuego en Oviedo")
				.setDescripcion("El parque San Francisco está quemándose a causa de un cigarrillo mal apagado")
				.setLocalizacion(new Location(43.3616142, -5.8506767)).setEtiquetas(etiquetas).setCampos(campos)
				.setFecha(fecha).setId((long) 1);
		assertEquals("Juan@Fuego en Oviedo@El parque San Francisco está quemándose a causa de un cigarrillo mal apagado"
				+ "@43.3616142$-5.8506767@Fuego$Parque@Temperatura:Alta$Fuego:Extremo@" + fecha.getTime() + "@1",
				inc.toString());
		System.err.println(inc);
	}
	
	@Test
	public void newIncidencia() {
		Agent agente = new Agent();
		String nombreIncidencia = "Fuego en Casa";
		String descripcion = "El fuego ha sido causado por un mechero";
		Location location = new Location();
		
		Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
		etiquetas.add(new Etiqueta());
		etiquetas.add(new Etiqueta());
		Set<Campo> campos = new HashSet<Campo>();
		campos.add(new Campo());
		
		Date date = new Date();
		Status estado = Status.ABIERTO;
		
		String comentarioOperario = "Entidad en proceso de resolución";
		String entidadAsignada = "Agente";
		
		Long id = (long) 1;
		
		Incidencia inc = new Incidencia();
		
		inc.setNombre(nombreIncidencia);
		inc.setDescripcion(descripcion);
		inc.setLocalizacion(location);
		inc.setEtiquetas(etiquetas);
		inc.setCampos(campos);
		inc.setFecha(date);
		inc.setEstado(estado);
		inc.setAgent(agente);
		inc.setComentarioOperario(comentarioOperario);
		inc.setEntidadAsignada(entidadAsignada);
		inc.setId(id);
		
		
		assertEquals(nombreIncidencia, inc.getNombre());
		assertEquals(descripcion, inc.getDescripcion());
		assertEquals(location, inc.getLocalizacion());
		assertEquals(etiquetas, inc.getEtiquetas());
		assertEquals(campos, inc.getCampos());
		assertEquals(date, inc.getFecha());
		assertEquals(estado, inc.getEstado());
		assertEquals(agente, inc.getAgent());
		assertEquals(comentarioOperario, inc.getComentarioOperario());
		assertEquals(entidadAsignada, inc.getEntidadAsignada());
		assertEquals(id, inc.getId());
	}
}