package daosImp;

import modelo.Denuncia;
import daos.DenunciaDAO;


public class DenunciaDAOHibernateJPA extends GenericDAOHibernateJPA<Denuncia> implements DenunciaDAO {
	
	public DenunciaDAOHibernateJPA() {
		super();
		this.setPersistentClass(Denuncia.class);
	}

}