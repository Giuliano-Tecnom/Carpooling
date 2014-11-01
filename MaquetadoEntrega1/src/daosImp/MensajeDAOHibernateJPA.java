package daosImp;

import modelo.Mensaje;
import daos.MensajeDAO;

public class MensajeDAOHibernateJPA extends GenericDAOHibernateJPA<Mensaje> implements MensajeDAO {

	public MensajeDAOHibernateJPA() {
		super();
		this.setPersistentClass(Mensaje.class);
	}

}
