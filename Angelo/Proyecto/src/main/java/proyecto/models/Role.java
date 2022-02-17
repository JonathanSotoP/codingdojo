package proyecto.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	
	@ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name="users_role",
			joinColumns = @JoinColumn(name="role_id"),
			inverseJoinColumns= @JoinColumn(name="user_id")
			)
	private List<User> usuarios;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<User> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
