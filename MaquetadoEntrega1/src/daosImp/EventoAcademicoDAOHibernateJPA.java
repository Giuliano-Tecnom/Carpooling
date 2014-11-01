package daosImp;


import modelo.EventoAcademico;
import daos.EventoAcademicoDAO;

public class EventoAcademicoDAOHibernateJPA extends GenericDAOHibernateJPA<EventoAcademico> implements EventoAcademicoDAO {

	public EventoAcademicoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(EventoAcademico.class);
	}

}
