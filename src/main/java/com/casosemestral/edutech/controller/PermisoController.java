package com.casosemestral.edutech.controller;


import com.casosemestral.edutech.model.Permiso;
import com.casosemestral.edutech.repository.PermisoRepository;
import com.casosemestral.edutech.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @PostMapping
    public Permiso crear(@RequestBody Permiso permiso) {
        return permisoService.crear(permiso);
    }

    @GetMapping
    public List<Permiso> listar() {
        return permisoService.obtenerTodos();
    }


}
