package com.jorge.proyectoDefinitivo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
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
    @Min(1)
    private Long id;
    @Size(min = 2, max = 200)
    private String nombre;
    @Column(name = "fechaDeCreacion")
    @DateTimeFormat
    private LocalDate fechaCreacion;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "proyecto")
    @Schema(name = "proyecto_id", example = "", required = false)
    @JsonIgnore
    private List<Tarea> tareas = new ArrayList<>();


}
