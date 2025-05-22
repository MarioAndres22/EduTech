package com.casosemestral.edutech.service;

import com.casosemestral.edutech.model.Usuario;
import com.casosemestral.edutech.repository.RolRepository;
import com.casosemestral.edutech.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public Optional<Usuario> asignarRol(Long usuarioId, Long rolId) {
        return usuarioRepository.findById(usuarioId)
                .map(usuario -> {
                    rolRepository.findById(rolId).ifPresent(rol ->
                            usuario.getRoles().add(rol)
                    );
                    return usuarioRepository.save(usuario);
                });
    }

}
