package com.shopusa.server.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "url", nullable = false, columnDefinition = "TEXT")
    private String url;  // URL de la imagen en Cloudinary
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
}
