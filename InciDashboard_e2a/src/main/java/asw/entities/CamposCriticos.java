package asw.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CamposCriticos {
	
	@Id @GeneratedValue Long id;
	
	private String clave;
	private String valor;
	
	public CamposCriticos() {
		
	}
	
	public CamposCriticos(String clave, String valor) {
		this.clave = clave;
		this.valor = valor;
	}
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

}
