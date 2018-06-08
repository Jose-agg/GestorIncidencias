package asw.entities;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Agent {

	@Id
	@GeneratedValue
	Long id;

	@Column(unique = true)
	@NotNull
	private String nombreUsuario;

	@NotNull
	private String password;

	@NotNull
	private String kind;

	private Long kindCode;

	@Column(unique = true)
	private String dni;

	private String nombre;

	private String apellidos;

	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="agent")
	Set<Incidencia> incidencias = new HashSet<Incidencia>();

	
	public Agent() {

	}

	public Agent(String username, String password) {
		this(username);
		this.password = password;
	}

	public Agent(String username) {
		this.nombreUsuario = username;
	}

	public Agent(String username, String password, String kind) {
		this(username, password);
		this.kind = kind;
	}

	public Agent(String contrasena, String nombreUsuario, String kind, long kindCode, String dni, String nombre,
			String apellidos, String email) {
		this(nombreUsuario, contrasena, kind);
		this.kindCode = kindCode;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}

	public String getUser() {
		return nombreUsuario;
	}

	public void setUser(String user) {
		this.nombreUsuario = user;
	}

	public Set<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Set<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setTipo(String tipo) {
		this.kind = tipo;
	}

	public String getTipo() {
		return kind;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Agent other = (Agent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Citizen [ID=" + id + ", nombre=" + nombre + ", email=" + email + ", tipo=" + kind + "]";
	}

	public void crearContraseña() {
		Random random = new Random();

		String pass = "";
		int longitud_pass = random.nextInt(4) + 7;

		for (int i = 0; i < longitud_pass; i++) {
			char caracterRandom = (char) (random.nextInt(26) + 'a'); // caracter de A a Z
			pass += caracterRandom;
		}

		this.password = pass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addIncidencia(Incidencia incidence) {
		this.incidencias.add(incidence);
	}

	public Long getKindCode() {
		return kindCode;
	}

	public void setKindCode(Long kindCode) {
		this.kindCode = kindCode;
	}
}
