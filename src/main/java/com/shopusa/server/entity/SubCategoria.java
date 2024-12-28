package com.shopusa.server.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subCategorias",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"categoria_id","nombre","codigo"})
})
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
    private Double pesoGramos;
    @Column(name = "ancho")
    private Double ancho;
    @Column(name = "largo")
    private  Double largo;
    @Column(name = "alto")
    private Double alto;
    @Column(name = "garantia")
    private  String garantia;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    @OneToMany(mappedBy = "subCategoria", cascade = CascadeType.ALL)
    private Set<Producto> productos;
}
