package com.dompet.tontineonline.repository;

import com.dompet.tontineonline.entity.TypeTontine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTontineRepository extends JpaRepository<TypeTontine, Long> {
}
