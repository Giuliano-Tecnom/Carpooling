package tests;

import java.util.List;

import modelo.Recorrido;
import daosImp.RecorridoDAOHibernateJPA;



public class TestRecorrido {

	public TestRecorrido() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {

		RecorridoDAOHibernateJPA g = new RecorridoDAOHibernateJPA();

		Recorrido e = new Recorrido();
		g.save(e);

		List<Recorrido> l = g.list();
		System.out.println("Se encontraron: " + l.size());
		Recorrido e2 = l.get(0);

		e2.setActivo(true);
		g.update(e2);
		System.out.println("Se modifico correctamente el atributo activo");
		
		Recorrido e3;
		e3 = (Recorrido) g.find(e2.getId());
		
	

		g.delete(e3);

		e3 = (Recorrido) g.find(e2.getId());

		if (e3 == null)
			System.out.println("Se elimino correctamente");

	}
	

}
