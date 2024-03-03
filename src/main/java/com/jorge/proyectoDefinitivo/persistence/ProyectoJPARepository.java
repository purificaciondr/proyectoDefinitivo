package com.jorge.proyectoDefinitivo.persistence;


import com.jorge.proyectoDefinitivo.model.Proyecto;

import java.util.List;

public interface ProyectoJPARepository {

    public List<Proyecto> findAll() throws RuntimeException;

    public Proyecto save(Proyecto proyecto) throws RuntimeException;

    public Proyecto update(Proyecto proyecto) throws RuntimeException;

}
