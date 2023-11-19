package com.anamaria.magazin.services;

import com.anamaria.magazin.model.Produse;
import com.anamaria.magazin.repository.ProduseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProduseServices {

    @Autowired
    private ProduseRepository produseRepository;

    @Autowired
    public ProduseServices(ProduseRepository produseRepository) {
        this.produseRepository = produseRepository;
    }

    public void adaugaProdus(String denumire, int cantitate, float pret)
    {
        Produse produs = new Produse(denumire, cantitate, pret);
        produseRepository.save(produs);
    }

    public List<Produse> findAll()
    {
        return produseRepository.findAll();
    }

    public void updateProdus(int id, String denumire, int cantitate, float pret)
    {
        Optional<Produse> produse = produseRepository.findById(Long.valueOf(id));
        Produse produs = produse.get();
        produs.setPret(pret);
        produs.setCantitate(cantitate);
        produs.setDenumire(denumire);

        produseRepository.save(produs);
    }

    public void deleteProdus(int id)
    {
        Optional<Produse> produse = produseRepository.findById(Long.valueOf(id));
        Produse produs = produse.get();

        produseRepository.delete(produs);
    }
}
