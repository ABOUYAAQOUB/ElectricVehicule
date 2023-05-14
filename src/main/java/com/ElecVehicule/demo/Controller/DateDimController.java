package com.ElecVehicule.demo.Controller;

import com.ElecVehicule.demo.model.DateDim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ElecVehicule.demo.Repository.DateDimRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
public class DateDimController {
	@Autowired
	private DateDimRepository dateDimRepository;
	
	@GetMapping("/dates")
	public List<DateDim>getAll(){
		return this.dateDimRepository.findAll();
	}
	
	@GetMapping("/date/{id}")
	public ResponseEntity<DateDim> getById(@PathVariable long id) {
		return ResponseEntity.ok(this.dateDimRepository.findById(id).get());
	}
	
	@PostMapping("/date")
	public DateDim create(@RequestBody DateDim dateDim) {
		return this.dateDimRepository.save(dateDim);
	}
	@PutMapping("/date/{id}")
	public ResponseEntity<DateDim> update(@PathVariable long id,@RequestBody DateDim dateDim) {
		DateDim dateDim2 = this.dateDimRepository.findById(id).get();
		dateDim2.setYear(dateDim.getYear());
		dateDim2.setMonth(dateDim.getMonth());
		dateDim2.setDay(dateDim.getDay());
		return ResponseEntity.ok(this.dateDimRepository.save(dateDim2));
		
	}
	
	@DeleteMapping("/date/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id){
		
		DateDim dateDim = this.dateDimRepository.findById(id).get();		
		this.dateDimRepository.delete(dateDim);
		Map<String, Boolean> responce = new HashMap<>();
		responce.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
	
}
