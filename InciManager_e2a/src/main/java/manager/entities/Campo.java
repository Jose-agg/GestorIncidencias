package manager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Campo {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Incidencia incidencia;

	private String clave;
	private String valor;

	private TipoCampos tipo;

	public Campo() {

	}

	public TipoCampos getTipo() {
		return tipo;
	}

	public void setTipo(TipoCampos tipo) {
		this.tipo = tipo;
	}

	public Campo(String clave, String valor) {
		this.clave = clave;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Incidencia getIncidencia() {
		return incidencia;
	}

	public Campo setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
		return this;
	}

	public String getClave() {
		return clave;
	}

	public Campo setClave(String clave) {
		this.clave = clave;
		return this;
	}

	public String getValor() {
		return valor;
	}

	public Campo setValor(String valor) {
		this.valor = valor;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campo other = (Campo) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return clave + ":" + valor;
	}
}