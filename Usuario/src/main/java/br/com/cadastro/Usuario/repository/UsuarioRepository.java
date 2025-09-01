package br.com.cadastro.Usuario.repository;

import br.com.cadastro.Usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
