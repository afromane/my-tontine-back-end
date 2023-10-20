package com.dompet.tontineonline.service;

import com.dompet.tontineonline.entity.Membre;
import com.dompet.tontineonline.entity.TypeTontine;
import com.dompet.tontineonline.exception.EntityAlreadyExistsException;
import com.dompet.tontineonline.exception.EntityNotFoundException;
import com.dompet.tontineonline.repository.MembreRepository;
import com.dompet.tontineonline.repository.TypeTontineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembreServiceImpl implements  MembreService{
    @Autowired
    private MembreRepository membreRepository;
    public void create(Membre membre) {
        Membre optional = this.findByEmail(membre.email);
        this.membreRepository.save(optional);
    }


    public List<Membre> findAll() {

        Optional<List<Membre>> optionalTypeTontines = Optional.of(this.membreRepository.findAll());
        return optionalTypeTontines.orElseThrow(
                ()-> new EntityNotFoundException("Not Found")
        );
    }

    public Membre findById(Long id) {
        Optional<Membre> optionalMembre = this.membreRepository.findById(id);
        return optionalMembre.orElseThrow(
                ()-> new EntityNotFoundException("Not found")
        ) ;
    }
    public Membre findByEmail(String email) {
        Optional<Membre> optionalMembre = this.membreRepository.findByEmail(email);
        return optionalMembre.orElseThrow(
                ()-> new EntityAlreadyExistsException("Conflict")
        ) ;
    }

    public void update(Long id, Membre membre) {

    }

    public void remove(Membre membre) {
        this.membreRepository.delete(membre);

    }
}
