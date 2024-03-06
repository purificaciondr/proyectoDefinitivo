package com.jorge.proyectoDefinitivo.persistence;

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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.jorge.proyectoDefinitivo.persistence"})
@AutoConfigureTestEntityManager
class TareaJPARepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TareaJPARepository jpaRepo;

    @Test
    void saveOK() {
        // given
        Proyecto aProject = entityManager.find(Proyecto.class,1L);


        System.out.println("aProject +++++ : " + aProject);

        Tarea aTarea = new Tarea(null, "Nueva tarea", LocalDate.now(), 3, false,aProject);

        // when
        jpaRepo.save(aTarea);

        System.out.println(aTarea);

        // then
        assertThat(aTarea.getId()).isGreaterThan(0);
    }

    @Test
    void saveNOK() {
        // given
        Proyecto aProject = entityManager.find(Proyecto.class,1L);
        Tarea aTarea = new Tarea(null, "N", LocalDate.now(), 3, false,aProject);

        // when

        // then

        Assertions.assertThrows(RuntimeException.class, () -> {
            jpaRepo.save(aTarea);

        });
    }

    @Test
    void listaTareasProyectoOK() {
        // given

        // when
        List<Tarea> listaTareas = jpaRepo.findByProyecto_idOrderByOrdenAsc(2L);
        System.out.println("ListaTares ++++++ : " + listaTareas);

        // then
        assertThat(listaTareas.size() > 0);
    }

}