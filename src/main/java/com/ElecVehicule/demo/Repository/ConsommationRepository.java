package com.ElecVehicule.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ElecVehicule.demo.model.Consommation;

public interface ConsommationRepository extends JpaRepository<Consommation, Long>{

}
