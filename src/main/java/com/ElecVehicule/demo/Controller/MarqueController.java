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

import com.ElecVehicule.demo.Repository.MarqueRepository;
import com.ElecVehicule.demo.model.Marque;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
public class MarqueController {

	@Autowired
	private MarqueRepository marquerepository;
	
	@GetMapping("/marques")
	public List<Marque>getAll(){
		return this.marquerepository.findAll();
	}
	
	@GetMapping("/marque/{id}")
	public ResponseEntity<Marque> getById(@PathVariable long id) {
		return ResponseEntity.ok(this.marquerepository.findById(id).get());
	}
	
	@PostMapping("/marque")
	public Marque create(@RequestBody Marque marque) {
		return this.marquerepository.save(marque);
	}
	
	@PutMapping("/marque/{id}")
	public ResponseEntity<Marque> update(@PathVariable long id,@RequestBody Marque marque) {
		Marque marque2 = this.marquerepository.findById(id).get();
		marque2.setNom(marque.getNom());
		marque2.setModel(marque.getModel());
		marque2.setModel_annee(marque.getModel_annee());
		marque2.setBase_msrp(marque.getBase_msrp());
		return ResponseEntity.ok(this.marquerepository.save(marque2));
		
	}
	
	@DeleteMapping("/marque/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id){
		
		Marque marque = this.marquerepository.findById(id).get();		
		this.marquerepository.delete(marque);
		Map<String, Boolean> responce = new HashMap<>();
		responce.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
}
