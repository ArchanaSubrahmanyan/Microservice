package com.doctorsearchapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.doctorsearchapi.entity.Doctor;

@RestController
@RequestMapping("/search")
public class DoctorSearchapiController {

	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/get")
	public List<Doctor> search(){
		
		String url = "http://localhost:8093/doctor/getdocs";
		List output = restTemplate.getForObject(url, List.class);
		return output;
	}
}
