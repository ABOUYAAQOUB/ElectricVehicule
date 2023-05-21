package com.ElecVehicule.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElecVehicule.demo.Repository.AdminRepository;
import com.ElecVehicule.demo.model.Admin;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;

	@PostMapping("/admin")
	public Admin create(@RequestBody Admin admin) {
		return this.adminRepository.save(admin);
	}
	
	@PostMapping("/admin/login")
	public ResponseEntity<Admin> login(@RequestBody Admin admin){
		Admin admin2 = this.adminRepository.findByUsername(admin.getNom(), admin.getPassword()).orElse(null);
		return ResponseEntity.ok(admin2);
	}
}
