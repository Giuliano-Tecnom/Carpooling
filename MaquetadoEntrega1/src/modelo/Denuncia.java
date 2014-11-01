package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Denuncia implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long id;
	private String descripcion = null;
	private Date fecha = null;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario dirigida;
	
	private static final long serialVersionUID = 3389132037727561760L;

	public Denuncia() {
		// TODO Auto-generated constructor stub
	}

	public Denuncia(String descripcion, Date fecha) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
