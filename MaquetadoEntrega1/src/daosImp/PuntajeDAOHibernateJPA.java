package daosImp;

import modelo.Puntaje;
import daos.PuntajeDAO;

public class PuntajeDAOHibernateJPA extends GenericDAOHibernateJPA<Puntaje> implements PuntajeDAO {

	public PuntajeDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Puntaje.class);
	}

}
