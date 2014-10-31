package clasesqueImplementan;

import clasesDAO.MensajeDAO;
import clasesDAO.UsuarioDAO;

public class FactoryDAO {
	
	public static UsuarioDAO getUsuarioDAO(){
		return new UsuarioDAOhiberJPA();
	}
	
	public static MensajeDAO getMensajeDAO(){
		return new MensajeDAOhiberJPA();
	}

}
