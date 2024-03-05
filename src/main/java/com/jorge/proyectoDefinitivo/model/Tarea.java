package com.jorge.proyectoDefinitivo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long id;
    @Size(min = 2, max = 200)
    private String descripcion;
    @DateTimeFormat
    private LocalDate fechaLimite;
    @Min(1)
    private Integer orden;
    private boolean completada;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "proyecto_id")
    @ToString.Exclude
    @Schema(name = "proyecto_id", example = "", required = false)
    private Proyecto proyecto;


}
