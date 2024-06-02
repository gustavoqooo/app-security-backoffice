package pe.edu.cibertec.app_security_backoffice.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.app_security_backoffice.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Select * from usuario where nomusuario = ''
    Usuario findByNomusuario(String nomusuario);

    //Llamar a stored procedure
    //@Query(value = "{call spActualizarUsuario(:nombres,:apellidos,:activo,:idusuario)}",
    // nativeQuery = true)
    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET nombres=:nombres, apellidos=:apellidos, " +
            "activo=:activo where idusuario=:idusuario",
            nativeQuery = true)
    void actualizarUsuario(@Param("nombres") String nombres,
                           @Param("apellidos") String apellidos,
                           @Param("activo") Boolean activo,
                           @Param("idusuario") Integer idusuario);
}
