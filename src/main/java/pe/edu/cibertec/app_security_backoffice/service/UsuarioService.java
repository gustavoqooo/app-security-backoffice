package pe.edu.cibertec.app_security_backoffice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.app_security_backoffice.model.bd.Rol;
import pe.edu.cibertec.app_security_backoffice.model.bd.Usuario;
import pe.edu.cibertec.app_security_backoffice.repository.RolRepository;
import pe.edu.cibertec.app_security_backoffice.repository.UsuarioRepository;
import pe.edu.cibertec.app_security_backoffice.util.RandomPassword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private RandomPassword randomPassword;

    @Override
    public Usuario buscarUsuarioXNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setPassword(randomPassword.generar(7));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(
                usuario.getNombres(),usuario.getApellidos(),
                usuario.getActivo(),usuario.getIdusuario()
        );
    }
    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }
    @Override
    public Usuario buscarUsuarioXIdUsuario(Integer idusuario) {
        return usuarioRepository.findById(idusuario).orElse(null);
    }
}
