package tests;

import java.util.List;

import modelo.Usuario;
import daosImp.UsuarioDAOHibernateJPA;

public class TestUsuario {

	public TestUsuario() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		UsuarioDAOHibernateJPA g = new UsuarioDAOHibernateJPA();

		Usuario e = new Usuario();
		g.save(e);

		List<Usuario> l = g.list();
		System.out.println("Se encontraron: " + l.size());
		Usuario e2 = l.get(0);

		e2.setActivo(false);
		g.update(e2);

		Usuario e3;
		e3 = (Usuario) g.find(e2.getId());

	

		g.delete(e3);

		e3 = (Usuario) g.find(e2.getId());

		if (e3 == null)
			System.out.println("Se elimino correctamente");

	}
	
}

