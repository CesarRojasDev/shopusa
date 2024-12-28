package com.shopusa.server.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comisiones",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"categoria_id", "plataforma_id"})
})
@Data
@NoArgsConstructor
public class Comision {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "valor")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "plataforma_id", nullable = false)
    private Plataforma plataforma;
}
