package clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mensajes")
public class Mensaje {
	@Id
	@GeneratedValue
	private int idMensaje;
	private int idUsuario;
	private String mensaje;
	
	public String getMensaje(){
		return this.mensaje;
	}
	public void setMensaje(String st){
		this.mensaje=st;
	}
	
	public int getIdMensaje(){
		return this.idMensaje;
	}
	public void setIdMensaje(int id){
		this.idMensaje=id;
	}
	
	public int getIdUsuario(){
		return this.idUsuario;
	}
	public void setIdUsuario(int id){
		this.idUsuario=id;
	}
	

}
