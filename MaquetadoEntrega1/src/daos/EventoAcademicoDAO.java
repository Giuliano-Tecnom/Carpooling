package daos;

import java.util.ArrayList;

import modelo.EventoAcademico;

public interface EventoAcademicoDAO extends GenericDAO<EventoAcademico> {
	public ArrayList<EventoAcademico> listActive();
}