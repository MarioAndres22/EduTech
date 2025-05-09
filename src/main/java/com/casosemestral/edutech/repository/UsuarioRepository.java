package com.casosemestral.edutech.repository;

import com.casosemestral.edutech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByApellido(String Apellido);

    List<Usuario> findByCorreo(String Correo);

    List<Usuario> findByNombreAndApellido(String Nombre , String Apellido);



}
