package com.ElecVehicule.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElecVehicule.demo.Repository.CaracteristiqueRepository;
import com.ElecVehicule.demo.Repository.ConsommationRepository;
import com.ElecVehicule.demo.Repository.MarqueRepository;
import com.ElecVehicule.demo.model.Caracteristique;
import com.ElecVehicule.demo.model.Consommation;
import com.ElecVehicule.demo.model.Marque;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
public class ConsommationController {

	@Autowired
	private ConsommationRepository consommationrepository;
	
	@Autowired
	private MarqueRepository marqueRepository;
	
	@Autowired
	private CaracteristiqueRepository caracteristiqueRepository;
	
	@GetMapping("/consommations")
	public List<Consommation>getAll(){
		return this.consommationrepository.findAll();
	}
	
	@GetMapping("/consommation/{id}")
	public ResponseEntity<Consommation> getById(@PathVariable long id) {
		return ResponseEntity.ok(this.consommationrepository.findById(id).get());
	}
	
	@PostMapping("/consommation")
	public Consommation create(@RequestBody Consommation consommation) {
		
		Caracteristique caracteristique = this.caracteristiqueRepository.findById(consommation.getCaracteristique().getId()).orElse(null);
		Marque marque = this.marqueRepository.findById(consommation.getMarque().getId()).orElse(null);
		consommation.setBase_msrp(marque.getBase_msrp());
		consommation.setElectricRange(caracteristique.getElectricRange());
		consommation.setElectriqueType(caracteristique.getElectriqueType());
		return this.consommationrepository.save(consommation);
		
	}
	
	@PutMapping("/consommation/{id}")
	public ResponseEntity<Consommation> update(@PathVariable long id,@RequestBody Consommation consommation) {
		
		Consommation consommation2 = this.consommationrepository.findById(id).orElse(null);
		
		Caracteristique caracteristique = this.caracteristiqueRepository.findById(consommation.getCaracteristique().getId()).orElse(null);
		Marque marque = this.marqueRepository.findById(consommation.getMarque().getId()).orElse(null);
		consommation2.setMarque(consommation.getMarque());
		consommation2.setLocalite(consommation.getLocalite());
		consommation2.setCaracteristique(consommation.getCaracteristique());
		consommation2.setDateDim(consommation.getDateDim());
		consommation2.setBase_msrp(marque.getBase_msrp());
		consommation2.setElectricRange(caracteristique.getElectricRange());
		consommation2.setElectriqueType(caracteristique.getElectriqueType());
		
		return ResponseEntity.ok(this.consommationrepository.save(consommation2));
		
	}
	
	@DeleteMapping("/consommation/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id){
		
		Consommation consommation = this.consommationrepository.findById(id).get();		
		this.consommationrepository.delete(consommation);
		Map<String, Boolean> responce = new HashMap<>();
		responce.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
}
