package com.shopusa.server.repository;

import com.shopusa.server.entity.Comision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComisionRepository extends JpaRepository<Comision,String> {
    Optional<Comision> findByPlataformaIdAndCategoriaId(String plataformaId, String categoriaId);
}
