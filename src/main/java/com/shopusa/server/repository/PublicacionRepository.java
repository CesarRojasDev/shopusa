package com.shopusa.server.repository;

import com.shopusa.server.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion,String> {
}
