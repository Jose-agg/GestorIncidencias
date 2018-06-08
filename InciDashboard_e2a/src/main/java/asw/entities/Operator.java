package asw.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TOperator")
public class Operator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String user;
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "operadorAsignado", cascade = CascadeType.ALL)
	private Set<Incidencia> incidencias = new HashSet<>();
	
	private String role;
	
	public Operator() {}
	
	public Operator(String username, String password)
	{
		super();
		this.user = username;
		this.password = password;
	}

	public Operator(String name, String password, Set<Incidencia> incidencias) {
		this(name, password);
		this.incidencias = incidencias;
	}
	
	public Operator(String name, String password,String role) {
		this(name, password);
		this.role=role;
	}
	
	

	public Long getID() {
		return id;
	}

	public void setID(Long iD) {
		id = iD;
	}

	public String getName() {
		return user;
	}

	public void setName(String name) {
		this.user = name;
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
	
	public void setRole(String role) {
		this.role=role;
	}
	
	public String getRole() {
		return role;
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
		Operator other = (Operator) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Operator [id=" + id + ", user=" + user + ", password=" + password + ", incidencias=" + incidencias
				+ ", role=" + role + "]";
	}

	public int getNumeroIncidencias() {
		return incidencias.size();
	}
	
	public void addIncidencia(Incidencia i)
	{
		incidencias.add( i );
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	

}
