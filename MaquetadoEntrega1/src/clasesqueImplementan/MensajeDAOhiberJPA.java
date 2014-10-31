package clasesqueImplementan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clases.EMF;
import clases.Mensaje;
import clases.Usuario;
import clasesDAO.MensajeDAO;


public class MensajeDAOhiberJPA implements MensajeDAO {

	@Override
	public List<Mensaje> cargar() {
		List<Mensaje> resultado = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta =  em.createQuery("select m from Mensaje m");
		resultado = (List<Mensaje>)consulta.getResultList();
		em.close();
		return resultado;
	}

	@Override
	public Mensaje encontrar(int id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta =  em.createQuery("select m from Mensaje m  where m.idMensaje =  ='"+id+"'");
		Mensaje resul = (Mensaje)consulta.getSingleResult();
		return resul;
	}


	@Override
	public void guardar(Mensaje m) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(m);
		em.flush();
		etx.commit();
		em.close();

	}

}
