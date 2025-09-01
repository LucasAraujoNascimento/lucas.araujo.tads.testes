package br.com.cadastro.Usuario.service;

import br.com.cadastro.Usuario.model.Usuario;
import br.com.cadastro.Usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criaUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuarioAtualizado = usuarioExistente.get();
            usuarioAtualizado.setNome(usuario.getNome());
            usuarioAtualizado.setEmail(usuario.getEmail());
            usuarioAtualizado.setSenha(usuario.getSenha());
            usuarioAtualizado.setAdmin(usuario.getAdmin());
            return usuarioRepository.save(usuarioAtualizado);
        }
        return null;
    }

    public List<Usuario> puxaUsuario(){
        return usuarioRepository.findAll();
    }

    public void deletar(Integer id){
        usuarioRepository.deleteById(id);
    }


}
