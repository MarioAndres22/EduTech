package com.casosemestral.edutech.service;


import com.casosemestral.edutech.model.Permiso;
import com.casosemestral.edutech.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    public List<Permiso> obtenerTodos() {
        return permisoRepository.findAll();
    }

    public Permiso crear(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    public Permiso obtenerPorId(Long id) {
        return permisoRepository.findById(id).orElse(null);
    }
}
