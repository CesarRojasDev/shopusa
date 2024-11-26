package com.shopusa.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "imagenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "url", nullable = false)
    private String url;  // URL de la imagen en Cloudinary
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
}
