package daosImp;

import modelo.Recorrido;
import daos.RecorridoDAO;

public class RecorridoDAOHibernateJPA extends GenericDAOHibernateJPA<Recorrido> implements RecorridoDAO  {

	public RecorridoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Recorrido.class);
	}

}
