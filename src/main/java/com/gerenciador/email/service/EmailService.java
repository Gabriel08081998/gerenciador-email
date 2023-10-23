package com.gerenciador.email.service;

import com.gerenciador.email.model.Email;

import java.util.List;

public interface EmailService {
    public Iterable<Email> buscarTodosEmail();

    public Email consultarEmailId(Long id);

    public List<Email> consultarEmailEnviados(String email);
    public List<Email> consultarEmailRecebidos(String email);

    public void cadastraEmail(Email email);

    public void excluirEmail(Long id);
}


