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
import com.ElecVehicule.demo.model.Caracteristique;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class CaracteristiqueController {
	@Autowired
	private CaracteristiqueRepository caracteristiqueRepository;
	
	@GetMapping("/caracteristiques")
	public List<Caracteristique>getAll(){
		return this.caracteristiqueRepository.findAll();
	}
	
	@GetMapping("/caracteristiques/{id}")
	public Caracteristique getById(@PathVariable long id) {
		return this.caracteristiqueRepository.findById(id).get();
	}
	
	@PostMapping("/caracteristique")
	public Caracteristique create(@RequestBody Caracteristique caracteristique) {
		return this.caracteristiqueRepository.save(caracteristique);
	}
	
	@PutMapping("/caracteristique/{id}")
	public Caracteristique update(@PathVariable long id,@RequestBody Caracteristique caracteristique) {
		Caracteristique caracteristique2 = this.caracteristiqueRepository.findById(id).get();
		caracteristique2.setElectriqueType(caracteristique.getElectriqueType());
		caracteristique2.setCleanAlternative(caracteristique.getCleanAlternative());
		caracteristique2.setElectricRange(caracteristique.getElectricRange());
		caracteristique2.setElectricUtility(caracteristique.getElectricUtility());
		return this.caracteristiqueRepository.save(caracteristique2);
	}
	
	@DeleteMapping("/caracteristique/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id){
		
		Caracteristique caracteristique = this.caracteristiqueRepository.findById(id).get();		
		this.caracteristiqueRepository.delete(caracteristique);
		Map<String, Boolean> responce = new HashMap<>();
		responce.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
	

}
