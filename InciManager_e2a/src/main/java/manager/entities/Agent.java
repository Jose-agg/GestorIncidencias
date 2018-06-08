package manager.entities;

import java.util.HashSet;
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
	private Long id;

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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "agent")
	private Set<Incidencia> incidencias = new HashSet<Incidencia>();

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

	public Agent() {

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

	public Agent(long id, String password, String kind, long kindCode, String dni, String nombre, String apellidos,
			String email, String nombreUsuario) {
		this(password, nombreUsuario, kind, kindCode, dni, nombre, apellidos, email);
		this.id = id;
	}

	public String getUsername() {
		return nombreUsuario;
	}

	public void setUsername(String username) {
		this.nombreUsuario = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Set<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Long getKindCode() {
		return kindCode;
	}

	public void setKindCode(Long kindCode) {
		this.kindCode = kindCode;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Agent [nombreUsuario=" + nombreUsuario + ", password=" + password + ", kind=" + kind + ", kindCode="
				+ kindCode + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ "]";
	}

}
