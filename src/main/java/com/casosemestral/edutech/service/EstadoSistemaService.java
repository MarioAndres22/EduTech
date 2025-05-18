package com.casosemestral.edutech.service;


import com.casosemestral.edutech.model.EstadoSistema;
import com.casosemestral.edutech.repository.EstadoSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EstadoSistemaService {

    @Autowired
    private EstadoSistemaRepository repository;

    public EstadoSistema registrarEstado(String servicio, String estado, String mensaje){
        EstadoSistema registro = new EstadoSistema();
        registro.setServicio(servicio);
        registro.setEstado(estado);
        registro.setMensaje(mensaje);
        registro.setFechaHora(LocalDateTime.now());

        return repository.save(registro);
    }

    public List<EstadoSistema> listarEstado() {
        return repository.findAll();
    }


}
