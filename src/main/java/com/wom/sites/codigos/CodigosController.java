package com.wom.sites.codigos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CodigosController {

    public CodigosService codigosService;

    public CodigosController(CodigosService codigosService) {
        this.codigosService = codigosService;
    }

    @GetMapping("/codigos")
    public List<Codigos> getAllCodigos() {
        return codigosService.getAllCodigos();
    }
    @PostMapping("/codigos")
    public Codigos createCodigo(@RequestBody Codigos codigos) {
        return codigosService.createCodigo(codigos);
    }

    @GetMapping("/codigos/{id}")
    public Codigos getCodigoById(@PathVariable Long id) {
        return codigosService.getCodigoById(id);
    }

    @PutMapping("/codigos/{id}")
    public Codigos updateCodigo(@PathVariable Long id, @RequestBody Codigos codigosDetails) {
        return codigosService.updateCodigo(id, codigosDetails);
    }

    @DeleteMapping("/codigos/{id}")
    public void deleteCodigo(@PathVariable Long id) {
        codigosService.deleteCodigo(id);
    }


}
