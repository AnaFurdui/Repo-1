package com.anamaria.magazin.repository;

import com.anamaria.magazin.model.Produse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduseRepository extends JpaRepository<Produse, Long> {

}
