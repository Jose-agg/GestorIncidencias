package asw.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Incidencia {

	@Id @GeneratedValue Long id;
	
	@ManyToOne
	private Agent agent;
	
	private String nombre;
	
	@Column(length=1000)
	private String descripcion;
	
	@OneToOne
	private Location location;
	
	@OneToMany(mappedBy="incidencia")
	private Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
	
	@OneToMany(mappedBy="incidencia")
	private Set<Campo> campos = new HashSet<Campo>(); //propiedad/valor
	
	@Enumerated(EnumType.STRING)
	private Status estado;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(length=1000)
	private String comentarioOperario;
	
	private TipoCampos tipoIncidencia;

	private String entidadAsignada; 
	
	@ManyToOne
	private Operator operadorAsignado;
	
	public Incidencia() {
		
	}
	
	public Incidencia(String nombreInc, Location localizacion, Agent agente, Status status) {
		this.nombre = nombreInc;
		this.location = localizacion;
		this.agent = agente;
		this.estado = status;
		this.entidadAsignada = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Location getLocalizacion() {
		return location;
	}

	public void setLocalizacion(Location localizacion) {
		this.location = localizacion;
	}

	public Set<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> set) {
		this.etiquetas = set;
	}

	public Set<Campo> getCampos() {
		return campos;
	}

	public void setCampos(Set<Campo> campos) {
		this.campos = campos;
	}

	public Status getEstado() {
		return estado;
	}

	public void setEstado(Status estado) {
		this.estado = estado;
	}

	public Date getCaducidad() {
		return fecha;
	}

	public void setCaducidad(Date caducidad) {
		this.fecha = caducidad;
	}

	public String getComentarioOperario() {
		return comentarioOperario;
	}

	public void setComentarioOperario(String comentarioOperario) {
		this.comentarioOperario = comentarioOperario;
	}

	public Operator getOperadorAsignado() {
		return operadorAsignado;
	}

	public void setOperadorAsignado(Operator operadorAsignado) {
		this.operadorAsignado = operadorAsignado;
	}
	
	public void addCampo(Campo c) {
		campos.add( c );
	}
	
	public void addEtiqueta(Etiqueta e) {
		etiquetas.add( e );
	}
	
	public String toStringCampos() {
		String s = "";
		for (Campo cp : campos) 
			s+= cp.toString() + "\t";
		return s;
	}
	
	public String toStringEtiquetas() {
		String s = "";
		for (Etiqueta eq : etiquetas) 
			s+= eq.getValor() + "\t";
		return s;
	}
	
	public TipoCampos getTipoIncidencia() {
		return tipoIncidencia;
	}

	public void setTipoIncidencia() {
		for(Campo campo : campos){
			if(campo.getTipo().equals(TipoCampos.CRITICO)){
				this.tipoIncidencia = TipoCampos.CRITICO;
			}
		}
		if(getTipoIncidencia()==null){
			this.tipoIncidencia = TipoCampos.NO_CRITICO;
		}

	}

	public String getEntidadAsignada() {
		return entidadAsignada;
	}

	public void setEntidadAsignada(String entidadAsignada) {
		this.entidadAsignada = entidadAsignada;
	}
}
