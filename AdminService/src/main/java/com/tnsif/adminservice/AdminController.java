package com.tnsif.adminservice;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/adminservice")
	public List<Admin> getAll(){
		return service.getAllAdmins();
	}
	
	@GetMapping("/adminservice/{id}")
	public ResponseEntity<Admin> getById(@PathVariable Integer id) {
		try {
			Admin ad = service.getById(id);
			return new ResponseEntity<Admin>(ad,HttpStatus.OK);
		}catch(NoResultException e) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
		
	@PostMapping("/adminservice")
	public void save(@RequestBody Admin ad) {
		service.createAdmin(ad);
	}
	
	@PutMapping("/adminservice/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id, @RequestBody Admin update_a) {
		try {
			Admin admin = service.getById(id);

			admin.setUsername(update_a.getUsername());
			admin.setMobile(update_a.getMobile());
			admin.setEmail(update_a.getEmail());
			admin.setDesignation(update_a.getDesignation());
			admin.setAddress(update_a.getAddress());
			service.updateAdmin(admin);
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
		}catch(NoResultException e){
			return new ResponseEntity<Admin>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/adminservice/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteAdmin(id);
	}

}
