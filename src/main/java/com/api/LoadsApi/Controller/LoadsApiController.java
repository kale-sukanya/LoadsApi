package com.api.LoadsApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.LoadsApi.entity.LoadsEntity;
import com.api.LoadsApi.exception.ResourseNotFoundException;
import com.api.LoadsApi.repository.LoadsRepository;
import java.util.*;

@RestController
//@RequestMapping("/loadsApi/v1")
public class LoadsApiController {
	
	@Autowired
	private LoadsRepository loadsRepository;
	
	//Get all Loads
	@GetMapping("/loads")
	public List<LoadsEntity> getLoads(){
		return this.loadsRepository.findAll();
	}
	
	//Get Load by Id
	@GetMapping("/loads/{loadsId}")
	public ResponseEntity<LoadsEntity> getLoadsById(@PathVariable(value = "loadsId") Long loadsId)
			throws ResourseNotFoundException {
		LoadsEntity load = loadsRepository.findById(loadsId)
				.orElseThrow(() -> new ResourseNotFoundException("Loads with lith Id :: does not exist"+ loadsId));
		return ResponseEntity.ok().body(load);
	}
	
	//Post new Load detail
	@PostMapping("/loads")
	public LoadsEntity createLoads(@RequestBody LoadsEntity load) {
		return this.loadsRepository.save(load);
	}
		
	//Update existing record
	@PutMapping("/loads/{loadsId}")
	public ResponseEntity<LoadsEntity> updateLoads(@PathVariable(value = "loadsId") Long loadsId, 
			@Validated @RequestBody LoadsEntity LoadDetails) throws ResourseNotFoundException{
		LoadsEntity load = loadsRepository.findById(loadsId)
				.orElseThrow(() -> new ResourseNotFoundException("Loads with lith Id :: does not exist"+ loadsId));
		load.setLoadId(LoadDetails.getLoadId());
		load.setLoadingPoint(LoadDetails.getLoadingPoint());
		load.setUnloadingPoint(LoadDetails.getUnloadingPoint());
		load.setProductType(LoadDetails.getProductType());
		load.setTruckType(LoadDetails.getTruckType());
		load.setNoOfTruck(LoadDetails.getNoOfTruck());
		load.setWeight(LoadDetails.getWeight());
		load.setShipperId(LoadDetails.getShipperId());
		load.setDate(LoadDetails.getDate());
		
		return ResponseEntity.ok(this.loadsRepository.save(load));
		
	}
	//Delete any record
	@DeleteMapping("/loads/{loadsId}")
	public Map<String, Boolean> deleteLoad(@PathVariable(value = "loadsId") Long loadsId) throws ResourseNotFoundException{
		
		LoadsEntity load = loadsRepository.findById(loadsId)
				.orElseThrow(() -> new ResourseNotFoundException("Loads with lith Id :: does not exist"+ loadsId));
		
		this.loadsRepository.delete(load);	
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		
		return response;
	}
}
