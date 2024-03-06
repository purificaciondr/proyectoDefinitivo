package com.jorge.proyectoDefinitivo.service;

import com.jorge.proyectoDefinitivo.exception.ProyectoNotfoundException;
import com.jorge.proyectoDefinitivo.model.Proyecto;
import com.jorge.proyectoDefinitivo.model.Tarea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.jorge.proyectoDefinitivo.service"})
@AutoConfigureTestEntityManager
class ServiceProyectoTareaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProyectoTareaService service;

    @Test
    public void crearProyectoOK () {
        // given
        Proyecto aProyecto = new Proyecto(null, "Puta castaña", LocalDate.now(), null);

        // when
        service.crearProyecto(aProyecto);

        System.out.println(aProyecto);

        // then
        assertThat(aProyecto.getId()).isGreaterThan(0);
    }

    @Test
    public void crearProyectoNOK () {
        // given
        Proyecto aProyecto = new Proyecto(null, "P", LocalDate.now(), null);

        // when
        //service.crearProyecto(aProyecto);

        //System.out.println(aProyecto);

        // then
        Assertions.assertThrows(RuntimeException.class, () -> {
            service.crearProyecto(aProyecto);});
    }

    @Test
    public void anadeTareaAProyectoOK() {
        // given

        Tarea aTarea = new Tarea(null,"Puta vida" ,LocalDate.now(), 5, false,null);

        Proyecto actProject = entityManager.find(Proyecto.class,1L);
        // when
        Proyecto newProject = service.anadeTareaAProyecto(1L, aTarea);

        System.out.println("aProject ++++++ :" + newProject);

        // then
        assertThat(newProject.getTareas().size() == actProject.getTareas().size()+1);

    }

    @Test
    public void anadeTareaAProyectoNOK() {
        // given

        Tarea aTarea = new Tarea(null,"Puta vida" ,LocalDate.now(), 5, false,null);

        // when

        // then
        Assertions.assertThrows(ProyectoNotfoundException.class, () -> {
            service.anadeTareaAProyecto(28L, aTarea);});

    }

}