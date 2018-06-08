package asw.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Campo {
	
	@Id @GeneratedValue Long id;
	
	@ManyToOne
	private Incidencia incidencia;
	
	private String clave;
	private String valor;
	private TipoCampos tipo ; 
	
	public Campo() {
		
	}
	
	public Campo(String clave, String valor) {
		this.clave = clave;
		this.valor = valor;
	}
	
	public Campo(String clave, String valor, Incidencia i)
	{
		this(clave, valor);
		this.incidencia = i;
	}
	
	public Campo(String clave, String valor, Incidencia i, TipoCampos tipo)
	{
		this(clave, valor, i);
		this.tipo = tipo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public TipoCampos getTipo() {
		return tipo;
	}
	public void setTipo(TipoCampos tipo) {
		this.tipo = tipo;
	}
	
	public Incidencia getincidencia() {
		return incidencia;
	}
	
	public void setincidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Campo [id=" + id +  " ,clave=" + clave + ", valor=" + valor + "]";
	}
	
	

}
