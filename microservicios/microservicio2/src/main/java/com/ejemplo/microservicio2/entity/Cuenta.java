package com.ejemplo.microservicio2.entity;

import com.ejemplo.microservicio1.entity.Cliente;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Getters y Setters
}
