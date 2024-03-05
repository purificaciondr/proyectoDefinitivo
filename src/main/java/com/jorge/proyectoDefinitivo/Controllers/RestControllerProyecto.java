package com.jorge.proyectoDefinitivo.Controllers;

import com.jorge.proyectoDefinitivo.model.Proyecto;
import com.jorge.proyectoDefinitivo.service.ProyectoTareaService;
import com.jorge.proyectoDefinitivo.service.ServiceProyectoTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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




}
