package com.casosemestral.edutech.service;

import com.casosemestral.edutech.model.Permiso;
import com.casosemestral.edutech.model.Rol;
import com.casosemestral.edutech.repository.PermisoRepository;
import com.casosemestral.edutech.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    // Crear un rol
    public Rol crear(Rol rol) {
        return rolRepository.save(rol);
    }

    // Obtener todos los roles
    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    // Obtener un rol por ID (con manejo de error opcional)
    public Rol obtenerPorId(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    // Actualizar un rol
    public Rol actualizar(Long id, Rol rolActualizado) {
        Rol rolExistente = obtenerPorId(id);
        rolExistente.setNombre(rolActualizado.getNombre());
        return rolRepository.save(rolExistente);
    }

    // Eliminar un rol
    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }

    // Asignar permisos a un rol (relación ManyToMany)
    @Transactional
    public Rol asignarPermisos(Long rolId, Set<Long> permisosIds) {
        Rol rol = obtenerPorId(rolId);
        Set<Permiso> permisos = permisoRepository.findAllByIdIn(permisosIds);
        rol.getPermisos().addAll(permisos); // Agrega los nuevos permisos
        return rolRepository.save(rol);
    }

    // Quitar permisos de un rol
    @Transactional
    public Rol quitarPermisos(Long rolId, Set<Long> permisosIds) {
        Rol rol = obtenerPorId(rolId);
        Set<Permiso> permisos = permisoRepository.findAllByIdIn(permisosIds);
        rol.getPermisos().removeAll(permisos); // Elimina los permisos
        return rolRepository.save(rol);
    }
}