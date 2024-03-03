package com.jorge.proyectoDefinitivo.persistence;


import com.jorge.proyectoDefinitivo.model.Tarea;

import java.util.List;

public interface TareaJPARepository {

    public List<Tarea> findByProject(Long idProyecto) throws RuntimeException;


    public Tarea update(Tarea tarea) throws RuntimeException;
}
