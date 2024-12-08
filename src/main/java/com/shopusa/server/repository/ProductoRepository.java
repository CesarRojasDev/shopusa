package com.shopusa.server.repository;

import com.shopusa.server.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto,String> {
}
