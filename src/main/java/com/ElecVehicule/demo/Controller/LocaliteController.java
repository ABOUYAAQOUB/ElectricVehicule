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

import com.ElecVehicule.demo.Repository.LocaliteRepository;
import com.ElecVehicule.demo.model.Localite;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
public class LocaliteController {
	
	@Autowired
	private LocaliteRepository localiteRepository;
	
	@GetMapping("/localites")
	public List<Localite>getAll(){
		return this.localiteRepository.findAll();
	}
	
	@GetMapping("/localite/{id}")
	public ResponseEntity<Localite> getById(@PathVariable long id){
		return ResponseEntity.ok(this.localiteRepository.findById(id).get());
	}
	
	@PostMapping("/localite")
	public Localite create(@RequestBody Localite localite) {
		System.out.println(localite.getCounty()); 
		return this.localiteRepository.save(localite);
	}
	
	@PutMapping("/localite/{id}")
	public ResponseEntity<Localite> update(@PathVariable long id,@RequestBody Localite localite){
		Localite localite2 = this.localiteRepository.findById(id).get();
		localite2.setCounty(localite.getCounty());
		localite2.setCity(localite.getCity());
		localite2.setCodepostal(localite.getCodepostal());
		localite2.setState(localite.getState());
		return ResponseEntity.ok(this.localiteRepository.save(localite2));
	}
	
	@DeleteMapping("/localite/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id)
	{
		Localite localite = this.localiteRepository.findById(id).get();
		this.localiteRepository.delete(localite);
		Map<String, Boolean> responce = new HashMap<>();
		responce.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
}







