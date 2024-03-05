package com.jorge.proyectoDefinitivo.service;

import com.jorge.proyectoDefinitivo.exception.ProyectoNotfoundException;
import com.jorge.proyectoDefinitivo.exception.TareaNotfoundException;
import com.jorge.proyectoDefinitivo.model.Proyecto;
import com.jorge.proyectoDefinitivo.model.Tarea;
import com.jorge.proyectoDefinitivo.persistence.ProyectoJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ServiceProyectoTarea implements ProyectoTareaService{

    @Autowired
    private ProyectoJPARepository repositorio;
    @Override
    public Proyecto crearProyecto(Proyecto proyecto) throws RuntimeException {
       //LocalDate current_Date = new LocalDate();
       //proyecto.setFechaCreacion(current_Date);
        return repositorio.save(proyecto);
    }

    @Override
    public Proyecto anadeTareaAProyecto(Long idProyecto, Tarea tarea) throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public List<Proyecto> obtenerProyectos() throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public List<Tarea> obtenerTareasDelProyecto(Long idProyecto) throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public Tarea marcarTareaHecha(Long idTarea) throws TareaNotfoundException, RuntimeException {
        return null;
    }
}
