package com.ElecVehicule.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ElecVehicule.demo.model.Caracteristique;

public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, Long>{

}
