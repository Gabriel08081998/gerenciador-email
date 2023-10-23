package com.gerenciador.email.service.impl;



import com.gerenciador.email.model.Email;
import com.gerenciador.email.repository.EmailRepository;
import com.gerenciador.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    // Método para buscar todos os emails
    @Override
    public Iterable<Email> buscarTodosEmail() {
        return emailRepository.findAll();
    }

    // Método para consultar um email por ID
    @Override
    public Email consultarEmailId(Long id) {
        // Procura um email pelo ID
        Optional<Email> email = emailRepository.findById(id);
        return email.get(); // Retorna o email encontrado (certifique-se de tratar casos onde o email pode não existir)
    }
    @Override
    public List<Email> consultarEmailEnviados(String email) {
        // Procura um email pelo ID
        List<Email> emailRet = emailRepository.findByRemetente(email);
        return emailRet; // Retorna o email encontrado (certifique-se de tratar casos onde o email pode não existir)
    }
    @Override
    public List<Email> consultarEmailRecebidos(String email) {
        // Consultar emails pelo endereço de destino usando o EmailRepository
        return emailRepository.findByDestino(email);
    }

    // Método para cadastrar um novo email
    @Override
    public void cadastraEmail(Email email) {
        salvarEmail(email); // Chama o método para salvar o email no banco de dados
    }

    // Método para excluir um email por ID
    @Override
    public void excluirEmail(Long id) {
        emailRepository.deleteById(id); // Remove o email com o ID especificado do banco de dados
    }

    // Método privado para salvar um email no banco de dados
    private void salvarEmail(Email email) {
        emailRepository.save(email); // Salva o email no banco de dados
    }
}

