package com.shopusa.server.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
public class Producto {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    @Column(name ="nombre" )
    private String nombre;
    @Column(name = "sku")
    private String sku;
    @Column(name ="precioUSD" )
    private Double precioUSD;
    @Column(name ="precioSoles")
    private Double precioSoles;
    @Column(name ="marca" )
    private String marca;
    @Column(name ="modelo" )
    private String modelo;
    @Column(name ="color" )
    private String color;
    @Column(name = "stock")
    private Integer stock;
    @Column(name ="descripcion", columnDefinition = "TEXT")
    private String descripcion;
    @Column(name ="caracteristica")
    private String caracteristica;
    @Column(name ="link", columnDefinition = "TEXT")
    private  String link;
    @ManyToOne
    @JoinColumn(name = "subcategoria_id", nullable = false)
    private SubCategoria subCategoria;
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagen> imagenes = new ArrayList<>();
}
