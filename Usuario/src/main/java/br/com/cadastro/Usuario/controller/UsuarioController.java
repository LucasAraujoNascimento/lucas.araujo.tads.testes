package br.com.cadastro.Usuario.controller;

import br.com.cadastro.Usuario.model.Usuario;
import br.com.cadastro.Usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/criar")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.criaUsuario(usuario);
    }

    @GetMapping("/listar")
    public List<Usuario> getUsuario(){
        return usuarioService.puxaUsuario();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
        if (usuarioAtualizado != null) {
            return ResponseEntity.ok(usuarioAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletUsuario(@PathVariable Integer id){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
