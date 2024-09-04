package com.shopusa.server.service;

import com.shopusa.server.dto.ComisionDTO;
import com.shopusa.server.entity.Comision;

import java.util.List;

public interface ComisionService {
    List<Comision> getAllComisiones();
    Comision getComisionById(String id);
    ComisionDTO createComision(ComisionDTO comisionDTO);
    ComisionDTO updateComision(String id, ComisionDTO comisionDTO);
    void deleteComision(String id);
}
