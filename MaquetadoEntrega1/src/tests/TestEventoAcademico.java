package tests;

import java.util.List;

import modelo.EventoAcademico;
import daosImp.EventoAcademicoDAOHibernateJPA;

public class TestEventoAcademico {

	public TestEventoAcademico() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		EventoAcademicoDAOHibernateJPA g = new EventoAcademicoDAOHibernateJPA();

		EventoAcademico e = new EventoAcademico();
		g.save(e);

		List<EventoAcademico> l = g.list();
		System.out.println("Se encontraron: " + l.size());
		EventoAcademico e2 = l.get(0);

		e2.setActivo(true);
		g.update(e2);
		System.out.println("Se modifico correctamente el atributo activo");
		EventoAcademico e3;
		e3 = (EventoAcademico) g.find(e2.getId());

	

		g.delete(e3);

		e3 = (EventoAcademico) g.find(e2.getId());

		if (e3 == null)
			System.out.println("Se elimino correctamente");

	}
	
}
