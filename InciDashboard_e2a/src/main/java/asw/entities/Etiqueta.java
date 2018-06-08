package asw.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Etiqueta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String valor;
	@ManyToOne
	private Incidencia incidencia;
	
	public Etiqueta() {
	}
	
	public Etiqueta(Incidencia incidencia, String valor) {
		super();
		this.incidencia = incidencia;
		this.valor = valor;
	}
	
	public Etiqueta(String valor) {
		this.valor = valor;
	}
	
	
	public Long getId() {
		return id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Incidencia getIncidencia() {
		return incidencia;
	}
	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}
	
	
}