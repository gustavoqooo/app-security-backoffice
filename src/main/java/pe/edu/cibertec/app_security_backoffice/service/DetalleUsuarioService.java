package pe.edu.cibertec.app_security_backoffice.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.app_security_backoffice.model.bd.Rol;
import pe.edu.cibertec.app_security_backoffice.model.bd.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarUsuarioXNomUsuario(username);
        return obtenerUsuarioAutenticado(usuario,
                obtenerListaRolesUsuario(usuario.getRoles()));
    }
    private List<GrantedAuthority> obtenerListaRolesUsuario(Set<Rol> listaRoles){
        List<GrantedAuthority> roles = new ArrayList<>();
        for(Rol rol : listaRoles){
            roles.add(new SimpleGrantedAuthority(rol.getNomrol()));
        }
        /*listaRoles.forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNomrol()));
        });*/
        return roles;
    }
    private UserDetails obtenerUsuarioAutenticado(Usuario usuario,
                                                  List<GrantedAuthority> authorityList){
        return new User(usuario.getNomusuario(), usuario.getPassword(), usuario.getActivo(),
                true, true, true,
                authorityList);
    }


}
