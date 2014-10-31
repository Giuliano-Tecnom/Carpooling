package clasesqueImplementan;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clases.EMF;
import clases.Usuario;
import clasesDAO.UsuarioDAO;

public class UsuarioDAOhiberJPA implements UsuarioDAO {

	@Override
	public List<Usuario> cargar() {
		List<Usuario> resultado = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta =  em.createQuery("select u from Usuario u  order by u.usuario");
		resultado = (List<Usuario>)consulta.getResultList();
		em.close();
		return resultado;
	}

	@Override
	public Usuario encontrar(String id) {
		try{
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta =  em.createQuery("select u from Usuario u where u.usuario ='"+id+"'");
		Usuario resul = (Usuario)consulta.getSingleResult();
		return resul;
		}catch(Exception e){
	        return null;
		}
		
	}
	@Override
	public Usuario encontrar(Integer id) {
		try{
		String id2 = id.toString();
		
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta =  em.createQuery("select u from Usuario u where u.usuario ='"+id2+"'");
		Usuario resul = (Usuario)consulta.getSingleResult();
		return resul;
		}catch(Exception e){
	        return null;
		}
		
	}


	@Override
	public void guardar(Usuario u) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(u);
		em.flush();
		etx.commit();
		em.close();

	}

}
