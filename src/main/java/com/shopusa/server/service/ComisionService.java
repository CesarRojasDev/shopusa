package com.shopusa.server.service;

import java.util.List;

import com.shopusa.server.dto.ComisionDTO;
import com.shopusa.server.entity.Comision;

public interface ComisionService {
    List<Comision> getAllComisiones();
    Comision getComisionById(String id);
    ComisionDTO createComision(ComisionDTO comisionDTO);
    ComisionDTO updateComision(String id, ComisionDTO comisionDTO);
    void deleteComision(String id);
}
