package clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue
	private int idUsuario;
	private String usuario;
	private String clave;
	
	
	
	public String getUsuario(){
		return this.usuario;
	}
	public void setUsuario(String st){
		this.usuario=st;
	}
	
	public int getIdUsuario(){
		return this.idUsuario;
	}
	public void setIdUsuario(int id){
		this.idUsuario=id;
	}
	
	public String getClave(){
		return this.clave;
	}
	public void setClave(String clave){
		this.clave=clave;
	}


}
