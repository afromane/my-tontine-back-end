package com.dompet.tontineonline.service;

import com.dompet.tontineonline.entity.TypeTontine;

import java.util.List;
import java.util.Optional;

public interface TypeTontineService {

    public void  create(TypeTontine typeTontine);
    public List<TypeTontine> findAll();
    public TypeTontine findById(Long id);
    public  void update (Long id, TypeTontine typeTontine);

    public void remove (TypeTontine typeTontine);
    public TypeTontine findByLabel(String label);

}
