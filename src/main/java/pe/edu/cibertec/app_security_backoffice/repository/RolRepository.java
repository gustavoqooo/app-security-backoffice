package pe.edu.cibertec.app_security_backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.app_security_backoffice.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    //Select * from rol where nomrol = '' and idrol = 0
    Rol findByNomrol(String nomrol);
}
