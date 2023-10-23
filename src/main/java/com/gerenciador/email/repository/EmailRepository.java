package com.gerenciador.email.repository;


import com.gerenciador.email.model.Email;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailRepository extends CrudRepository <Email, Long> {
    List<Email> findByRemetente(String email);
    List<Email> findByDestino(String email);
}