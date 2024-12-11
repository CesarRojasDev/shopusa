package com.shopusa.server.repository;

import com.shopusa.server.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface ProductoRepository extends JpaRepository<Producto,String> {
    Producto findBySku(String sku);
}
