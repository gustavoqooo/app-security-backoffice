package pe.edu.cibertec.app_security_backoffice.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    private String nomusuario;
    private String email;
    private String password;
    private String nombres;
    private String apellidos;
    private Boolean activo;
    @ManyToMany(cascade = CascadeType.MERGE,
    fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "idusuario"),
    inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles;
}
