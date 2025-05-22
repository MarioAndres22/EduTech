package com.casosemestral.edutech.controller;

import com.casosemestral.edutech.model.Rol;
import com.casosemestral.edutech.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<Rol> crear(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.crear(rol));
    }

    @GetMapping
    public ResponseEntity<List<Rol>> listar() {
        return ResponseEntity.ok(rolService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.obtenerPorId(id));

    }

    @PostMapping("/{id}/permisos")
    public ResponseEntity<Rol> asignarPermisos(
            @PathVariable Long id,
            @RequestBody Set<Long> permisosIds
    ) {
        Rol rol = rolService.asignarPermisos(id, permisosIds);
        return ResponseEntity.ok(rol);
    }
}