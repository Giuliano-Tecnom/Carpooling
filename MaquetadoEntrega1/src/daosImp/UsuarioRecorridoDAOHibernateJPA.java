package daosImp;

import daos.UsuarioRecorridoDAO;

import modelo.UsuarioRecorrido;

public class UsuarioRecorridoDAOHibernateJPA extends GenericDAOHibernateJPA<UsuarioRecorrido> implements UsuarioRecorridoDAO {

	public UsuarioRecorridoDAOHibernateJPA() {
		super();
		this.setPersistentClass(UsuarioRecorrido.class);
	}

	
}
