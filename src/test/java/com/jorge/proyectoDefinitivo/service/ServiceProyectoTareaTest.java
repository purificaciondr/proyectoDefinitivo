package com.jorge.proyectoDefinitivo.service;

import com.jorge.proyectoDefinitivo.model.Proyecto;
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

}