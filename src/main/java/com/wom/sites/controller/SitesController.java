package com.wom.sites.controller;

import com.wom.sites.exception.ResourceNotFoundException;
import com.wom.sites.model.Sites;
import com.wom.sites.repositories.SitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class SitesController {

    @Autowired
    private SitesRepository sitesRepository;

    @GetMapping("/sites")
    public List<Sites> getAllSites() {
        return sitesRepository.findAll();
    }

    @PostMapping("/sites")
    public Sites createSite(@RequestBody Sites sites) {
        return sitesRepository.save(sites);
    }

    @GetMapping("/sites/{id}")
    public ResponseEntity<Sites> getSiteById(@PathVariable Long id) {
        Sites sites = sitesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Site not exist with id: " + id));
        return ResponseEntity.ok(sites);
    }

    @PutMapping("/sites/{id}")
    public ResponseEntity<Sites> updateSite(@PathVariable Long id, @RequestBody Sites sitesDetails) {
        Sites sites = sitesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Site not exist with id: " + id));

        sites.setNombre(sitesDetails.getNombre());
        sites.setCodigo(sitesDetails.getCodigo());
        sites.setModelo(sitesDetails.getModelo());
        sites.setFecha(sitesDetails.getFecha());
        sites.setCiudad(sitesDetails.getCiudad());

        Sites updatedSite = sitesRepository.save(sites);
        return ResponseEntity.ok(updatedSite);

    }

    @DeleteMapping("/sites/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSite(@PathVariable Long id) {
        Sites sites = sitesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Site not exist with id: " + id));

        sitesRepository.delete(sites);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

}
