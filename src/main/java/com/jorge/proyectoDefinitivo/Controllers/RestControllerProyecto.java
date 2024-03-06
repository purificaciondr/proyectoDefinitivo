package com.jorge.proyectoDefinitivo.Controllers;

import com.jorge.proyectoDefinitivo.model.Proyecto;
import com.jorge.proyectoDefinitivo.model.Tarea;
import com.jorge.proyectoDefinitivo.service.ProyectoTareaService;
import com.jorge.proyectoDefinitivo.service.ServiceProyectoTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/proyectos")
@Validated
public class RestControllerProyecto {

    @Autowired
    private ProyectoTareaService service;

    @PostMapping("")
    public ResponseEntity<Proyecto> createProyecto(
            @RequestBody @Valid Proyecto proyecto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearProyecto(proyecto));
    }

    @PostMapping("/asociarTarea/{pid}")
    public ResponseEntity<Proyecto> anadeTareaAProyecto(@PathVariable("pid") @Min(1) Long id,
            @RequestBody @Valid Tarea tarea
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.anadeTareaAProyecto(id, tarea));
    }




}
