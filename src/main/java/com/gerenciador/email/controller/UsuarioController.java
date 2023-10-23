package com.gerenciador.email.controller;

import com.gerenciador.email.model.Email;
import com.gerenciador.email.model.Usuario;
import com.gerenciador.email.service.EmailService;
import com.gerenciador.email.service.UsuarioService;
import com.gerenciador.email.view.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EmailService emailService;

    // Endpoint para buscar todos os usuários
    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    // Endpoint para consultar um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarUsuarioId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.consultarUsuarioId(id);
        if (!usuario.isPresent()){
            return ResponseEntity.badRequest().body("Usuario nao existe!");
        }
        return ResponseEntity.ok(usuario.get());
    }

    @GetMapping("/emails/enviados/{id}")
    public ResponseEntity<?> consultarEmailEnviados(@PathVariable Long id) {
        List<Email> emails = null;
        Optional<Usuario> usuario = usuarioService.consultarUsuarioId(id);
        if (usuario.isPresent()){
            emails = emailService.consultarEmailEnviados(usuario.get().getEmail());
        }else {
            return ResponseEntity.badRequest().body("Usuario nao existe!");
        }
        return ResponseEntity.ok(emails);
    }
    @GetMapping("/emails/recebidos/{id}")
    public ResponseEntity<?> consultarEmailRecebidos(@PathVariable Long id) {
        List<Email> emails = null;
        Optional<Usuario> usuario = usuarioService.consultarUsuarioId(id);
        if (usuario.isPresent()){
             emails = emailService.consultarEmailRecebidos(usuario.get().getEmail());
        }else {
           return ResponseEntity.badRequest().body("Usuario nao existe!");
        }
        return ResponseEntity.ok(emails);
    }


    // Endpoint para cadastrar um novo usuário
    @PostMapping
    public ResponseEntity<?> cadastraUsuario(@RequestBody @Valid UsuarioDTO usuario) {
        Usuario use = new Usuario();
        BeanUtils.copyProperties(usuario, use);
        usuarioService.cadastraUsuario(use);
        return ResponseEntity.ok(usuario);
    }

    // Endpoint para editar um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuarioService.editarUsuario(id, usuario);
        return ResponseEntity.ok(usuario); // Retorna o usuário com as informações atualizadas
    }

    // Endpoint para excluir um usuário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.ok().build(); // Retorna uma resposta vazia (sem conteúdo) para indicar que a exclusão foi realizada com sucesso
    }
}

