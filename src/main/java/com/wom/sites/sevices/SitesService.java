package com.wom.sites.sevices;

import com.wom.sites.exception.ResourceNotFoundException;
import com.wom.sites.model.Sites;
import com.wom.sites.repositories.SitesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SitesService {

    public SitesRepository sitesRepository;

    public SitesService(SitesRepository sitesRepository) {
        this.sitesRepository = sitesRepository;
    }

    public List<Sites> getAllSites() {
        return sitesRepository.findAll();
    }

    public Sites createSite(Sites sites) {
        return sitesRepository.save(sites);
    }

    public ResponseEntity<Sites> getSiteById(Long id) {
        Sites sites = sitesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Site not exist with id: " + id));
        return ResponseEntity.ok(sites);
    }

    public ResponseEntity<Sites> updateSite(Long id, Sites sitesDetails) {
        Sites sites = sitesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Site not exist with id: " + id));

        sites.setNombre(sitesDetails.getNombre());
        sites.setCodigo(sitesDetails.getCodigo());
        sites.setModelo(sitesDetails.getModelo());
        sites.setFecha(sitesDetails.getFecha());
        sites.setCiudad(sitesDetails.getCiudad());

        Sites updatedSite = sitesRepository.save(sites);
        return ResponseEntity.ok(updatedSite);

    }

    public ResponseEntity<Map<String, Boolean>> deleteSite(Long id) {
        Sites sites = sitesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Site not exist with id: " + id));

        sitesRepository.delete(sites);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }



}
