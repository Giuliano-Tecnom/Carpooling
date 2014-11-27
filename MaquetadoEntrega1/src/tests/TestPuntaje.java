package tests;

import java.util.List;

import modelo.Puntaje;
import daosImp.PuntajeDAOHibernateJPA;

public class TestPuntaje {

	public TestPuntaje() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		PuntajeDAOHibernateJPA g = new PuntajeDAOHibernateJPA();

		Puntaje e = new Puntaje();
		g.save(e);

		List<Puntaje> l = g.list();
		System.out.println("Se encontraron: " + l.size());
		Puntaje e2 = l.get(0);

		e2.setActivo(true);
		g.update(e2);
		System.out.println("Se modifico correctamente el atributo activo");
		Puntaje e3;
		e3 = (Puntaje) g.find(e2.getId());

	

		g.delete(e3);

		e3 = (Puntaje) g.find(e2.getId());

		if (e3 == null)
			System.out.println("Se elimino correctamente");

	}
	
}
