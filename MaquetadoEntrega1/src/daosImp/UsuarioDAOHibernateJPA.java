package daosImp;

import javax.persistence.Query;

import modelo.Usuario;
import daos.UsuarioDAO;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
	
	public UsuarioDAOHibernateJPA() {
		super();
		this.setPersistentClass(Usuario.class);
	}
	
	public Usuario recuperarUsuario(String usuario) {
		try{
			Query consulta = this.getEntityManager().createQuery("Select e FROM Usuario e where e.usuario = ?");
			consulta.setParameter(1, usuario);
			Usuario resultado = (Usuario) consulta.getSingleResult();
			return resultado;
		}catch(Exception e){
			return null;
		}

	}

}
