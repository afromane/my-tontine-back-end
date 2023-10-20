package com.dompet.tontineonline.service;

import com.dompet.tontineonline.entity.TypeTontine;
import com.dompet.tontineonline.exception.EntityAlreadyExistsException;
import com.dompet.tontineonline.exception.EntityNotFoundException;
import com.dompet.tontineonline.repository.TypeTontineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeTontineServiceImpl implements TypeTontineService {

    @Autowired
    private TypeTontineRepository typeTontineRepository;
    public void create(TypeTontine typeTontine) {
        TypeTontine tontine = this.findByLabel(typeTontine.label);
        this.typeTontineRepository.save(tontine);
    }

    public List<TypeTontine> findAll() {

        Optional<List<TypeTontine>> optionalTypeTontines = Optional.of(this.typeTontineRepository.findAll());
        return optionalTypeTontines.orElseThrow(
                ()-> new EntityNotFoundException("Not Found")
        );
    }

    public TypeTontine findById(Long id) {
        Optional<TypeTontine> optionalTypeTontine = this.typeTontineRepository.findById(id);
        return optionalTypeTontine.orElseThrow(
                ()-> new EntityNotFoundException("Not found")
        ) ;
    }
    public TypeTontine findByLabel(String label) {
        Optional<TypeTontine> optionalTypeTontine = this.typeTontineRepository.findByLabel(label);
        return optionalTypeTontine.orElseThrow(
                ()-> new EntityAlreadyExistsException("Conflict")
        ) ;
    }

    public void update(Long id, TypeTontine typeTontine) {
        TypeTontine optionalTypeTontine = this.findById(id);
        optionalTypeTontine.amount = typeTontine.amount;
        optionalTypeTontine.isActive = typeTontine.isActive;
        optionalTypeTontine.isRequired = typeTontine.isRequired;
        optionalTypeTontine.label = typeTontine.label;

        this.typeTontineRepository.save(optionalTypeTontine);
    }

    public void remove(TypeTontine typeTontine) {
        this.typeTontineRepository.delete(typeTontine);

    }
}
