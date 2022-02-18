package proyecto.models;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="tarea")
public class Tareas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String descripcion;
	private String tiempo;
	
	private Date creado;
	private Date actualizado;
	
	
	@ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name="users_Tareas",
			joinColumns = @JoinColumn(name="tarea_id"),
			inverseJoinColumns= @JoinColumn(name="user_id")
			)
	private List<User> usuarios;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_id")
	private User usuarioCreador;
	
	
	@PrePersist
    protected void onCreate(){
        this.creado = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.actualizado = new Date();
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public void setDescripcion(String info) {
		descripcion = info;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public Date getCreado() {
		return creado;
	}
	public void setCreado(Date creado) {
		this.creado = creado;
	}
	public Date getActualizado() {
		return actualizado;
	}
	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}
	public List<User> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	public User getUsuarioCreador() {
		return usuarioCreador;
	}
	public void setUsuarioCreador(User usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}
    
    

}
