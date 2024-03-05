package com.jorge.proyectoDefinitivo.persistence;


import com.jorge.proyectoDefinitivo.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProyectoJPARepository extends JpaRepository <Proyecto, Long> {

    //public List<Proyecto> findAll() throws RuntimeException;

    //public Proyecto save(Proyecto proyecto) throws RuntimeException;

    //public Proyecto update(Proyecto proyecto) throws RuntimeException;

}
