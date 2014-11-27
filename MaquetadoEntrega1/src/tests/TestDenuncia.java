package tests;

import java.util.List;

import modelo.Denuncia;
import daosImp.DenunciaDAOHibernateJPA;

public class TestDenuncia {

	public TestDenuncia() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		DenunciaDAOHibernateJPA g = new DenunciaDAOHibernateJPA();

		Denuncia e = new Denuncia();
		g.save(e);

		List<Denuncia> l = g.list();
		System.out.println("Se encontraron: " + l.size());
		Denuncia e2 = l.get(0);

		e2.setActivo(true);
		g.update(e2);
		System.out.println("Se modifico correctamente el atributo activo");
		Denuncia e3;
		e3 = (Denuncia) g.find(e2.getId());

	

		g.delete(e3);

		e3 = (Denuncia) g.find(e2.getId());

		if (e3 == null)
			System.out.println("Se elimino correctamente");

	}
	
}
