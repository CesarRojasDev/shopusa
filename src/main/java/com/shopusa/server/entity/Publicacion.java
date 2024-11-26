package com.shopusa.server.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "publicaciones")
@Data
@NoArgsConstructor
public class Publicacion{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name ="fechaPublicacion")
    private LocalDate fechaPublicacion;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "skuPlataforma")
    private String skuPlataforma;
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "plataforma_id", nullable = false)
    private Plataforma plataforma;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
