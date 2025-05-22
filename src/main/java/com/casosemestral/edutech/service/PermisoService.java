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

    // Crear un permiso
    public Permiso crear(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    // Obtener todos los permisos
    public List<Permiso> obtenerTodos() {
        return permisoRepository.findAll();
    }

    // Obtener un permiso por ID
    public Permiso obtenerPorId(Long id) {
        return permisoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso no encontrado"));
    }

    // Actualizar un permiso
    public Permiso actualizar(Long id, Permiso permisoActualizado) {
        Permiso permisoExistente = obtenerPorId(id);
        permisoExistente.setNombre(permisoActualizado.getNombre());
        return permisoRepository.save(permisoExistente);
    }

    // Eliminar un permiso
    public void eliminar(Long id) {
        permisoRepository.deleteById(id);
    }
}