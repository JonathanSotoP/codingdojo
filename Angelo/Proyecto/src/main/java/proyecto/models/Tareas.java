package proyecto.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String Descripcion;
	private String tiempo;
	
	private Date creado;
	private Date actualizado;
	
	
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
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
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
    
    

}
