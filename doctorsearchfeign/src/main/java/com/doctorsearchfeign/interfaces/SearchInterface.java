package com.doctorsearchfeign.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doctorsearchfeign.entity.Doctor;

@FeignClient(value="doctorsearchfeign",url="http://localhost:8090/doctor")
public interface SearchInterface {

	@RequestMapping(method=RequestMethod.GET,value="/getdocs")
	public List<Doctor> getdoc();
		
	
}
