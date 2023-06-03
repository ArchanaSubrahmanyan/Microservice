package com.doctor.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.entity.Doctor;
import com.doctor.repository.DoctorRepo;



@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorRepo doctorRepo;
	
	@PostMapping("/createdoc")
	public ResponseEntity<Doctor> createdoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<>(doctorRepo.save(doctor),HttpStatus.CREATED);
	}
	
	@GetMapping("/getdocs")
	public ResponseEntity<List<Doctor>> getalldocs(){
		
		return ResponseEntity.ok().body(doctorRepo.findAll());
	}
	
	@GetMapping("/getdocbyid/{id}")
	public ResponseEntity<Optional<Doctor>> getdocbyId(@PathVariable Long id){
		
		Optional<Doctor> docop= doctorRepo.findById(id);
		if(docop.isPresent()) {
			return ResponseEntity.ok().body(doctorRepo.findById(id));
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
}
}
