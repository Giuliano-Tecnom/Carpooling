package tests;

import java.util.List;

import modelo.Mensaje;
import daosImp.MensajeDAOHibernateJPA;

public class TestMensaje {

	public TestMensaje() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		MensajeDAOHibernateJPA g = new MensajeDAOHibernateJPA();

		Mensaje e = new Mensaje();
		g.save(e);

		List<Mensaje> l = g.list();
		System.out.println("Se encontraron: " + l.size());
		Mensaje e2 = l.get(0);

		e2.setActivo(true);
		g.update(e2);
		System.out.println("Se modifico correctamente el atributo activo");
		Mensaje e3;
		e3 = (Mensaje) g.find(e2.getId());

	

		g.delete(e3);

		e3 = (Mensaje) g.find(e2.getId());

		if (e3 == null)
			System.out.println("Se elimino correctamente");

	}
	
}
