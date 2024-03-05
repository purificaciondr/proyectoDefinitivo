package com.jorge.proyectoDefinitivo.persistence;

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
@ComponentScan(basePackages = {"com.jorge.proyectoDefinitivo.persistence"})
@AutoConfigureTestEntityManager
class ProyectoJPARepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProyectoJPARepository jpaRepo;

    @Test
    void saveOK() {
        // given
        Proyecto aProyecto = new Proyecto(null, "Puta castaña", LocalDate.now(), null);

        // when
        jpaRepo.save(aProyecto);

        System.out.println(aProyecto);

        // then
        assertThat(aProyecto.getId()).isGreaterThan(0);
    }

    @Test
    void saveNOK() {
        // given
        Proyecto aProyecto = new Proyecto(null, "P", LocalDate.now(), null);

        // when

        // then

        Assertions.assertThrows(RuntimeException.class, () -> {
            jpaRepo.save(aProyecto);

        });
    }

}