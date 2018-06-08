package asw.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private double latitud;

	@NotNull
	private double longitud;

	@OneToOne
	private Incidencia incidencia;

	public Location() {
	}

	public Location(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public Long getId() {
		return id;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public Incidencia getIncidence() {
		return incidencia;
	}

	public void setIncidence(Incidencia incidence) {
		this.incidencia = incidence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((incidencia == null) ? 0 : incidencia.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Location other = (Location) obj;
		if (incidencia == null) {
			if (other.incidencia != null)
				return false;
		} else if (!incidencia.equals(other.incidencia))
			return false;
		return !(Double.doubleToLongBits(latitud) != Double.doubleToLongBits(other.latitud)
				|| (Double.doubleToLongBits(longitud) != Double.doubleToLongBits(other.longitud)));
	}

	@Override
	public String toString() {
		return latitud + "$" + longitud;
	}
}