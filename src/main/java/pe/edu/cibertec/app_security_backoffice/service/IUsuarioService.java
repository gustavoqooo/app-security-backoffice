package pe.edu.cibertec.app_security_backoffice.service;

import pe.edu.cibertec.app_security_backoffice.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario buscarUsuarioXNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    List<Usuario> listarUsuario();
    Usuario buscarUsuarioXIdUsuario(Integer idusuario);
}
