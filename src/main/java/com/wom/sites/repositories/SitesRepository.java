package com.wom.sites.repositories;

import com.wom.sites.model.Sites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitesRepository extends JpaRepository<Sites, Long> {

}
