package com.shopusa.server.repository;

import com.shopusa.server.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,String> {
}
