package com.ElecVehicule.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ElecVehicule.demo.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	@Query("Select a from Admin a WHERE a.nom=:nom and a.password=:password")
	Optional<Admin> findByUsername(@Param("nom") String nom,@Param("password") String password);
}
