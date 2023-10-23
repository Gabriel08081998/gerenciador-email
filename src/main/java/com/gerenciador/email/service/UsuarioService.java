package com.gerenciador.email.service;

import com.gerenciador.email.model.Usuario;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public Iterable<Usuario> buscarTodos();
    public Optional<Usuario> consultarUsuarioId(Long id);
    public void cadastraUsuario(Usuario usuario);
    public void editarUsuario(Long id, Usuario usuario);
    public  void excluirUsuario(Long id);
}
