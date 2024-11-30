package com.shopusa.server.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorias", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nombre")
})
@Data
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Set<SubCategoria> subCategoria;
}
