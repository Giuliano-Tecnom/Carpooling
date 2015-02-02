package daosImp;


import java.util.ArrayList;

import javax.persistence.Query;

import modelo.EventoAcademico;
import modelo.Usuario;
import daos.EventoAcademicoDAO;

public class EventoAcademicoDAOHibernateJPA extends GenericDAOHibernateJPA<EventoAcademico> implements EventoAcademicoDAO {

	public EventoAcademicoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(EventoAcademico.class);
	}
	
	public ArrayList<EventoAcademico> listActive(){
		try{
			Query consulta = this.getEntityManager().createQuery("Select e FROM EventoAcademico e where e.activo = ?");
			consulta.setParameter(1, true);
			return (ArrayList<EventoAcademico>) consulta.getResultList();
		}catch(Exception e){
			return null;
		}
	
	}
}
