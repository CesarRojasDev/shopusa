package com.shopusa.server.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "subCategorias")
@Data
@NoArgsConstructor
public class SubCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "nombre")
    private  String nombre;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "pesoGramos")
    private double pesoGramos;
    @Column(name = "ancho")
    private double ancho;
    @Column(name = "largo")
    private  double largo;
    @Column(name = "alto")
    private double alto;
    @Column(name = "garantia")
    private  String garantia;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    @OneToMany(mappedBy = "subCategoria", cascade = CascadeType.ALL)
    private Set<Producto> productos;
}
