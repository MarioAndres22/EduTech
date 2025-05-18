package com.casosemestral.edutech.controller;

import com.casosemestral.edutech.model.EstadoSistema;
import com.casosemestral.edutech.service.EstadoSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado-sistema")
public class EstadoSistemaController {

    @Autowired
    private EstadoSistemaService estadoSistemaService;

    @GetMapping
    public List<EstadoSistema> obtenerTodos() {
        return estadoSistemaService.listarEstado();
    }

    @PostMapping
    public EstadoSistema registrar(@RequestBody EstadoSistema estadoSistema) {
        return estadoSistemaService.registrarEstado(
                estadoSistema.getServicio(),
                estadoSistema.getEstado(),
                estadoSistema.getMensaje()
        );
    }
}

