package daosImp;

import modelo.Usuario;
import daos.UsuarioDAO;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
	
	public UsuarioDAOHibernateJPA() {
		super();
		this.setPersistentClass(Usuario.class);
	}

}
