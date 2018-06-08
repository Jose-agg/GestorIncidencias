package manager.entities;

public class IncidenciaMin {

	private String nombre;
	private String descripcion;
	private String etiqueta;
	private String campo;
	private Double latitud;
	private Double longitud;

	public IncidenciaMin(String nombre, String descripcion, String etiqueta, String campo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.etiqueta = etiqueta;
		this.campo = campo;
	}

	public IncidenciaMin() {

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

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
}