package com.sowing.seed.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sowing.seed.model.City;
import com.sowing.seed.model.Farmer;
import com.sowing.seed.model.State;
import com.sowing.seed.service.ICityService;
import com.sowing.seed.service.IStateService;

@RestController

public class FarmerController {
	@Autowired
	IStateService iStateService;
	
	@Autowired
	ICityService iCityService;
	
	private static Map<Integer, Farmer> farmers = new HashMap<>();
	static {
		Farmer f1 = new Farmer();
		f1.setName("ABC");
		f1.setPhone("98777773");
		Farmer f2 = new Farmer();
		f2.setName("XYZ");
		f2.setPhone("32555676");
		farmers.put(1, f1);
		farmers.put(2, f2);

	}

	@RequestMapping(value = "/farmers")
	public ResponseEntity<Object> getAllFarmers() {
		return new ResponseEntity<>(farmers.values(), HttpStatus.OK);

	}

	@RequestMapping(value = "/states")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<Object> getAllStates() {
		
		return new ResponseEntity<>(iStateService.getAllStates(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/states", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<Object> createState(@RequestBody State state) {
		
		iStateService.createState(state);
		return new ResponseEntity<Object>("State added successfully", HttpStatus.CREATED);
	}

	
	@RequestMapping(value = "/cities")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<Object> getAllCities() {
		
		return new ResponseEntity<>(iCityService.getAllCities(),HttpStatus.OK);

	}
	
	@RequestMapping(value = "/cities", method = RequestMethod.POST)
	public ResponseEntity<Object> createCity(@RequestBody City city) {
		
		iCityService.createCity(city);
		return new ResponseEntity<Object>("City added successfully", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/farmers/{id}")
	public ResponseEntity<Object> getFarmerByID(@PathVariable("id") String id) {
		return new ResponseEntity<Object>(farmers.get(Integer.parseInt(id)), HttpStatus.OK);
	}

	@RequestMapping(value = "/farmers", method = RequestMethod.POST)
	public ResponseEntity<Object> createFarmer(@RequestBody Farmer farmer) {
		farmers.put(farmers.size() + 1, farmer);
		return new ResponseEntity<Object>("Farmer added successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/farmers/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateFarmer(@PathVariable("id") String id, @RequestBody Farmer farmer) {
		Farmer updateFarmer = farmers.get(Integer.parseInt(id));
		updateFarmer.setName(farmer.getName());
		updateFarmer.setPhone(farmer.getPhone());
		farmers.put(Integer.parseInt(id), updateFarmer);
		return new ResponseEntity<Object>(farmers.values(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "farmers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletefarmerRecord(@PathVariable("id") String id) {
		farmers.remove(Integer.parseInt(id));
		return new ResponseEntity<Object>("Record deleted successfully", HttpStatus.OK);
	}
}
