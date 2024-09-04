package com.shopusa.server.service;

import com.shopusa.server.dto.ComisionDTO;
import com.shopusa.server.entity.Comision;
import com.shopusa.server.exeption.ComisionNotFoundExeption;
import com.shopusa.server.mapper.ComisionMapper;
import com.shopusa.server.repository.ComisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComisionServiceImpl implements ComisionService{

    @Autowired
    private ComisionRepository comisionRepository;
    private ComisionMapper comisionMapper;
    @Override
    public List<Comision> getAllComisiones() {
        return comisionRepository.findAll();
    }
    @Override
    public Comision getComisionById(String id) {
        return findComisionById(id);
    }
    @Override
    public ComisionDTO createComision(ComisionDTO comisionDTO) {
        Comision comision = comisionMapper.INSTANCE.toComision(comisionDTO);
        Comision savedcomision = comisionRepository.save(comision);
        return comisionMapper.INSTANCE.toComisionDTO(savedcomision);
    }
    @Override
    public ComisionDTO updateComision(String id, ComisionDTO comisionDTO) {
        Comision existingComision = findComisionById(id);
        comisionMapper.INSTANCE.updateComisionFromDto(comisionDTO, existingComision);
        Comision savedComision = comisionRepository.save(existingComision);
        return comisionMapper.INSTANCE.toComisionDTO(savedComision);
    }
    @Override
    public void deleteComision(String id) {
        Comision comision = findComisionById(id);
        comisionRepository.delete(comision);
    }
    private Comision findComisionById(String id) {
        return comisionRepository.findById(id)
                .orElseThrow(() -> new ComisionNotFoundExeption("Comision no encontrada con id " + id));
    }
}
