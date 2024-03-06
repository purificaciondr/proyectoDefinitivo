package com.jorge.proyectoDefinitivo.service;

import com.jorge.proyectoDefinitivo.exception.ProyectoNotfoundException;
import com.jorge.proyectoDefinitivo.exception.TareaNotfoundException;
import com.jorge.proyectoDefinitivo.model.Proyecto;
import com.jorge.proyectoDefinitivo.model.Tarea;
import com.jorge.proyectoDefinitivo.persistence.ProyectoJPARepository;
import com.jorge.proyectoDefinitivo.persistence.TareaJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceProyectoTarea implements ProyectoTareaService{

    @Autowired
    private ProyectoJPARepository repoProyecto;

    @Autowired
    private TareaJPARepository repoTarea;
    @Override
    public Proyecto crearProyecto(Proyecto proyecto) throws RuntimeException {
       //LocalDate current_Date = new LocalDate();
       //proyecto.setFechaCreacion(current_Date);
        return repoProyecto.save(proyecto);
    }

    @Override
    public Proyecto anadeTareaAProyecto(Long idProyecto, Tarea tarea) throws ProyectoNotfoundException, RuntimeException {
        Proyecto aProject = repoProyecto.findById(idProyecto).orElseThrow(() -> new ProyectoNotfoundException("Proyecto no encontrado"));
        tarea.setProyecto(aProject);
        repoTarea.save(tarea);
        return aProject;
    }

    @Override
    public List<Proyecto> obtenerProyectos() throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public List<Tarea> obtenerTareasDelProyecto(Long idProyecto) throws ProyectoNotfoundException, RuntimeException {
        Proyecto aProject = repoProyecto.findById(idProyecto).orElseThrow(() -> new ProyectoNotfoundException("Proyecto no encontrado"));
        return repoTarea.findByProyecto_idOrderByOrdenAsc(idProyecto);
    }

    @Override
    public Tarea marcarTareaHecha(Long idTarea) throws TareaNotfoundException, RuntimeException {
        return null;
    }
}
