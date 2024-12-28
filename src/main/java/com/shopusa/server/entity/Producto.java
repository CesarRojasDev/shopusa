package com.shopusa.server.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos",uniqueConstraints = {
        @UniqueConstraint(columnNames = "sku")
})
@Data
@NoArgsConstructor
public class Producto {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    @Column(name ="nombre", columnDefinition = "TEXT" )
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
    private Integer stock = 4;
    @Column(name ="descripcion", columnDefinition = "TEXT")
    private String descripcion;
    @Column(name ="caracteristica", columnDefinition = "TEXT")
    private String caracteristica;
    @Column(name ="link", columnDefinition = "TEXT")
    private  String link;
    @ManyToOne
    @JoinColumn(name = "subcategoria_id", nullable = false)
    private SubCategoria subCategoria;
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Imagen> imagenes = new ArrayList<>();
    @JsonProperty("imagenesUrls")
    @Transient  // Para evitar persistirlo en la base de datos
    public List<String> getImagenesUrls() {
        return imagenes.stream()
                .map(Imagen::getUrl)  // Extrae las URLs de las imágenes
                .collect(Collectors.toList());
    }
}
