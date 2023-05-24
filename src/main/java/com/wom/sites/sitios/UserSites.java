package com.wom.sites.sitios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UserSites {
    public SitesService sitesService;

    public UserSites(SitesService sitesService) {
        this.sitesService = sitesService;
    }

    @Autowired
    private SitesRepository sitesRepository;
    @PostMapping("/createSite")
    public Sites createSite(@RequestBody Sites sites) {
        return sitesService.createSite(sites);
    }
}
