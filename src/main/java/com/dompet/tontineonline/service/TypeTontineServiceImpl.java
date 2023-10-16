package com.dompet.tontineonline.service;

import com.dompet.tontineonline.entity.TypeTontine;
import com.dompet.tontineonline.repository.TypeTontineRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeTontineServiceImpl implements TypeTontineService {

    @Autowired
    private TypeTontineRepository typeTontineRepository;
    public void create(TypeTontine typeTontine) {

        this.typeTontineRepository.save(typeTontine);

    }
    public List<TypeTontine> findAll() {
        Optional<List<TypeTontine>> typeTontines = Optional.of(this.typeTontineRepository.findAll());
        return typeTontines.orElseThrow(
                ()-> new EntityNotFoundException("Aucun element")
        );
    }

    public TypeTontine findById(Long id) {
        Optional<TypeTontine> optionalTypeTontine = this.typeTontineRepository.findById(id);
        return optionalTypeTontine.orElseThrow(
                ()->  new EntityNotFoundException("Element non trouvable")
        );
    }

    public void update(Long id, TypeTontine typeTontine) {

       // Optional<TypeTontine> optionalTypeTontine = Optional.ofNullable(this.findById(id));

       // optionalTypeTontine.g
    }

    public void remove(TypeTontine typeTontine) {

    }
}
