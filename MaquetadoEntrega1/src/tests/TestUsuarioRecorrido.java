package tests;

import java.util.List;

import modelo.UsuarioRecorrido;
import daosImp.UsuarioRecorridoDAOHibernateJPA;

public class TestUsuarioRecorrido {

	public TestUsuarioRecorrido() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {

		UsuarioRecorridoDAOHibernateJPA g = new UsuarioRecorridoDAOHibernateJPA();

		UsuarioRecorrido e = new UsuarioRecorrido();
		g.save(e);

		List<UsuarioRecorrido> l = g.list();
		System.out.println("Se encontraron: " + l.size());
		UsuarioRecorrido e2 = l.get(0);

		e2.setActivo(true);
		g.update(e2);
		System.out.println("Se modifico correctamente el atributo activo");
		
		UsuarioRecorrido e3;
		e3 = (UsuarioRecorrido) g.find(e2.getId());

	

		g.delete(e3);

		e3 = (UsuarioRecorrido) g.find(e2.getId());

		if (e3 == null)
			System.out.println("Se elimino correctamente");

	}
}
