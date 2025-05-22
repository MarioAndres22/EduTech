package com.casosemestral.edutech.repository;

import com.casosemestral.edutech.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {


    Set<Permiso> findAllByIdIn(Set<Long> permisosIds);
}
