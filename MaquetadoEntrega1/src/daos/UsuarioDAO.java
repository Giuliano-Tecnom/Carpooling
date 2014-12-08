package daos;

import modelo.Usuario;


public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public Usuario recuperarUsuario(String usuario);
}
