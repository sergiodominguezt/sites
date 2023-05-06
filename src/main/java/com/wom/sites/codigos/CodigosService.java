package com.wom.sites.codigos;

import com.wom.sites.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodigosService {

    public CodigosRepository codigosRepository;

    public CodigosService(CodigosRepository codigosRepository) {
        this.codigosRepository = codigosRepository;
    }

    public Codigos createCodigo(Codigos codigos) {
        return codigosRepository.save(codigos);
    }

    public List<Codigos> getAllCodigos() {
        return codigosRepository.findAll();
    }

    public Codigos getCodigoById(Long id) {
        return codigosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Codigo not exist with id: " + id));
    }

    public Codigos updateCodigo(Long id, Codigos codigosDetails) {
        Codigos codigos = codigosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Codigo not exist with id: " + id));

        codigos.setCodigo(codigosDetails.getCodigo());
        codigos.setModelo(codigosDetails.getModelo());

        Codigos updatedCodigo = codigosRepository.save(codigos);
        return updatedCodigo;
    }
    public void deleteCodigo(Long id) {
        Codigos codigos = codigosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Codigo not exist with id: " + id));

        codigosRepository.delete(codigos);
    }
}
