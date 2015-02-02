package daosImp;

import java.util.ArrayList;

import javax.persistence.Query;

import daos.UsuarioRecorridoDAO;
import modelo.Recorrido;
import modelo.UsuarioRecorrido;

public class UsuarioRecorridoDAOHibernateJPA extends GenericDAOHibernateJPA<UsuarioRecorrido> implements UsuarioRecorridoDAO {

	public UsuarioRecorridoDAOHibernateJPA() {
		super();
		this.setPersistentClass(UsuarioRecorrido.class);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<UsuarioRecorrido> getRecorridosTodos(Long id){
		try{
			Query consulta = this.getEntityManager().createQuery("Select e FROM UsuarioRecorrido e where e.recorrido.activo = true and e.usuario.id <> ?");
			consulta.setParameter(1, id);
			ArrayList<UsuarioRecorrido> recorridos = (ArrayList<UsuarioRecorrido>) consulta.getResultList();
			return recorridos;
		}catch(Exception e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<UsuarioRecorrido> getRecorridosDeUnUsuario(Long id){
		try{
			Query consulta = this.getEntityManager().createQuery("Select e FROM UsuarioRecorrido e where e.recorrido.activo = true and e.usuario.id = ? ");
			consulta.setParameter(1, id);
			ArrayList<UsuarioRecorrido> recorridos = (ArrayList<UsuarioRecorrido>) consulta.getResultList();
			return recorridos;
		}catch(Exception e){
			return null;
		}
	}
	
}
