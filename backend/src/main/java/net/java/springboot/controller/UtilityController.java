package net.java.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.exception.ResourceNotFoundException;
import net.java.springboot.model.Utility;
import net.java.springboot.repository.UtilityRepository;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class UtilityController {
	
	@Autowired
	private UtilityRepository utilityRepository;
	
	//get all utility
	@GetMapping("/utility")
	public List<Utility>getAllUtilities(){
		return utilityRepository.findAll();
		
	}
	
	//create utility rest api
	/*@PostMapping("/utility")
	public Utility createUtility(@RequestBody Utility utility) {
		return utilityRepository.save(utility);
	}*/
	@PostMapping("/utility")
	public Utility createUtility(@RequestBody Utility utility) {
		return utilityRepository.save(utility);
	}
	
	//get utility by Id
	@GetMapping("/utility/{id}")
	public ResponseEntity<Utility>getUtilityById(@PathVariable Long id) {
		Utility utility = utilityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utility doess not exist with:"+ id));
		return ResponseEntity.ok(utility);
	}
	
	//update utility rest api
	@PutMapping("/utility/{id}")
	public ResponseEntity<Utility> updateUtility(@PathVariable Long id, @RequestBody Utility utilityDetails){
		Utility utility = utilityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utility ecpens not exist with:"+ id));
		
		utility.setDate(utilityDetails.getDate());
		utility.setExpenseName(utilityDetails.getExpenseName());
		utility.setDescription(utilityDetails.getDescription());
		utility.setAmount(utilityDetails.getAmount());
		
	 	Utility updatedUtility = utilityRepository.save(utility);
		return ResponseEntity.ok(updatedUtility);
	}
	
	//Delete utility rest api
	@DeleteMapping("/utility/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteUtility(@PathVariable Long id){
		Utility uility = utilityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utility not exist with id :"+ id));
		utilityRepository.delete(uility);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	//@GetMapping
	
	

}
