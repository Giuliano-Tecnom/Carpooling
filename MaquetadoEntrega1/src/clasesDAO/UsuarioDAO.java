package clasesDAO;

import java.util.List;

import clases.Usuario;

public interface UsuarioDAO {
	public List<Usuario> cargar();
	public Usuario encontrar(Integer id);
	public Usuario encontrar(String id);
	public void guardar(Usuario u);
}
