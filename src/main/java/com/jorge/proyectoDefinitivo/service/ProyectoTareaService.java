package com.jorge.proyectoDefinitivo.service;


import com.jorge.proyectoDefinitivo.exception.ProyectoNotfoundException;
import com.jorge.proyectoDefinitivo.exception.TareaNotfoundException;
import com.jorge.proyectoDefinitivo.model.Proyecto;
import com.jorge.proyectoDefinitivo.model.Tarea;

import java.util.List;

public interface ProyectoTareaService {

    public Proyecto crearProyecto(Proyecto proyecto) throws RuntimeException;

    public Proyecto anadeTareaAProyecto(Long idProyecto, Tarea tarea) throws ProyectoNotfoundException, RuntimeException;

    public List<Proyecto> obtenerProyectos() throws ProyectoNotfoundException, RuntimeException;

    public List<Tarea> obtenerTareasDelProyecto(Long idProyecto) throws ProyectoNotfoundException, RuntimeException;

    public Tarea marcarTareaHecha(Long idTarea) throws TareaNotfoundException, RuntimeException;

}
