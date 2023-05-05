package com.wom.sites.controller;

import com.wom.sites.exception.ResourceNotFoundException;
import com.wom.sites.model.Sites;
import com.wom.sites.repositories.SitesRepository;
import com.wom.sites.sevices.SitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class SitesController {

    public SitesService sitesService;

    public SitesController(SitesService sitesService) {
        this.sitesService = sitesService;
    }

    @Autowired
    private SitesRepository sitesRepository;

    @GetMapping("/sites")
    public List<Sites> getAllSites() {
        return sitesService.getAllSites();
    }

    @PostMapping("/sites")
    public Sites createSite(@RequestBody Sites sites) {
        return sitesService.createSite(sites);
    }

    @GetMapping("/sites/{id}")
    public ResponseEntity<Sites> getSiteById(@PathVariable Long id) {
        return sitesService.getSiteById(id);
    }

    @PutMapping("/sites/{id}")
    public ResponseEntity<Sites> updateSite(@PathVariable Long id, @RequestBody Sites sitesDetails) {
        return sitesService.updateSite(id, sitesDetails);
    }

    @DeleteMapping("/sites/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSite(@PathVariable Long id) {
        return sitesService.deleteSite(id);
    }

}
