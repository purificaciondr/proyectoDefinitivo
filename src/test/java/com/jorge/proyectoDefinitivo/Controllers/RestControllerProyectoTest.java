package com.jorge.proyectoDefinitivo.Controllers;

import com.jorge.proyectoDefinitivo.exception.ProyectoNotfoundException;
import com.jorge.proyectoDefinitivo.model.Proyecto;
import com.jorge.proyectoDefinitivo.model.Tarea;
import com.jorge.proyectoDefinitivo.service.ProyectoTareaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.jorge.proyectoDefinitivo.Controllers",
        "com.jorge.proyectoDefinitivo.service"})
@AutoConfigureTestEntityManager
class RestControllerProyectoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RestControllerProyecto controller;

    @Test
    public void crearProyectoOK() {
        // given
        Proyecto aProyecto = new Proyecto(null, "Puta castaña", LocalDate.now(), null);

        // when
        ResponseEntity<Proyecto> response = controller.createProyecto(aProyecto);

        System.out.println(aProyecto);

        // then
        //assertThat(aProyecto.getId()).isGreaterThan(0);
        assertThat(response.getStatusCode().value())
                .isEqualTo(HttpStatus.CREATED.value());

        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isGreaterThan(0);
    }

    @Test
    public void crearProyectoNOK() {
        // given
        Proyecto aProyecto = new Proyecto(null, "P", LocalDate.now(), null);

        // when


        // then

        Assertions.assertThrows(RuntimeException.class, () -> {
            ResponseEntity<Proyecto> response = controller.createProyecto(aProyecto);

        });

    }

    @Test
    public void anadirTareaProyectoOK() {
        // given
        Tarea aTarea = new Tarea(null,"Puta vida" ,LocalDate.now(), 5, false,null);

        // when
        ResponseEntity<Proyecto> response = controller.anadeTareaAProyecto(1L, aTarea);


        // then
        assertThat(response.getStatusCode().value())
                .isEqualTo(HttpStatus.CREATED.value());

        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTareas()).isNotNull();
    }

    @Test
    public void anadirTareaProyectoNOK() {
        // given
        Tarea aTarea = new Tarea(null,"Puta vida" ,LocalDate.now(), 5, false,null);

        // when


        // then

        Assertions.assertThrows(ProyectoNotfoundException.class, () -> {
            ResponseEntity<Proyecto> response = controller.anadeTareaAProyecto(17L, aTarea);

        });

    }

    @Test
    public void obtenerListaTareasProyectoOK() {
        // given

        // when
        ResponseEntity<List<Tarea>> response = controller.obtenerListaTareasProyecto(1L);


        // then
        assertThat(response.getStatusCode().value())
                .isEqualTo(HttpStatus.OK.value());

        assertThat(response.getBody()).isNotNull();
    }


}