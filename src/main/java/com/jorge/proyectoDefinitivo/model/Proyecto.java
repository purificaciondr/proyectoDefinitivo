package com.jorge.proyectoDefinitivo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @Column(name="fechaDeCreacion")
    private LocalDate fechaCreacion;

    @OneToMany
    @JoinColumn(name = "proyecto_id")
    private List<Tarea> tareas = new ArrayList<>();
}
