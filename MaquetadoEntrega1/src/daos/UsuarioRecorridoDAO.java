package daos;

import java.util.ArrayList;

import modelo.Recorrido;
import modelo.UsuarioRecorrido;

public interface UsuarioRecorridoDAO extends GenericDAO<UsuarioRecorrido> {

	public ArrayList<UsuarioRecorrido> getRecorridosDeUnUsuario(Long id);
	
	public ArrayList<UsuarioRecorrido> getRecorridosTodos(Long id);
}
