package com.dompet.tontineonline.service;

import com.dompet.tontineonline.entity.Membre;

import java.util.List;

public interface MembreService {

    public void  create(Membre membre);
    public List<Membre> findAll();
    public Membre findById(Long id);
    public  void update (Long id, Membre membre);
    public void remove (Membre membre);
    public Membre findByEmail(String email);
}
