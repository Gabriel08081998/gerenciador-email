package com.gerenciador.email.controller;

import com.gerenciador.email.model.Email;
import com.gerenciador.email.service.EmailService;
import com.gerenciador.email.view.EmailDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    // Endpoint para buscar todos os emails
    @GetMapping
    public ResponseEntity<Iterable<Email>> buscarTodosEmail() {
        return ResponseEntity.ok(emailService.buscarTodosEmail());
    }

    // Endpoint para consultar um email por ID
    @GetMapping("/{id}")
    public ResponseEntity<Email> consultarEmailId(@PathVariable Long id) {
        return ResponseEntity.ok(emailService.consultarEmailId(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Email>> consultarEmail(@PathVariable String email) {
        return ResponseEntity.ok(emailService.consultarEmailEnviados(email));
    }

    // Endpoint para cadastrar um novo email
    @PostMapping
    public ResponseEntity<?> enviarEmail(@RequestBody @Valid EmailDTO emailDTO) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.cadastraEmail(email);
        return ResponseEntity.ok(emailDTO);
    }

    // Endpoint para excluir um email por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEmail(@PathVariable Long id) {
        emailService.excluirEmail(id);
        return ResponseEntity.ok().build(); // Retorna uma resposta vazia (sem conteúdo) para indicar que a exclusão foi realizada com sucesso
    }
}

