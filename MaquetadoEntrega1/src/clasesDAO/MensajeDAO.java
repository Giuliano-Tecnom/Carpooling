package clasesDAO;



import java.util.List;

import clases.Mensaje;

public interface MensajeDAO {
	public List<Mensaje> cargar();
	public Mensaje encontrar(int id);
	public void guardar(Mensaje m);
}
