package com.dompet.tontineonline.repository;

import com.dompet.tontineonline.entity.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembreRepository extends JpaRepository<Membre,Long> {
    Optional<Membre> findByEmail(String email);
}
