package com.casosemestral.edutech.service;

import com.casosemestral.edutech.model.Rol;
import com.casosemestral.edutech.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorId(Long id) {
        return rolRepository.findById(id);
    }

    public interface RolRepository extends JpaRepository<Rol, Long> {
        Optional<Rol> findByNombre(String nombre);
    }

}