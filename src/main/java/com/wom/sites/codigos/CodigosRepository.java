package com.wom.sites.codigos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodigosRepository extends JpaRepository<Codigos, Long> {
}
