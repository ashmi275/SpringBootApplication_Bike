package com.bike.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.util.UriComponentsBuilder;
import com.bike.entity.Bike;
import com.bike.service.IBikeService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})

public class BikeController {

	
	@Autowired
	private IBikeService bikeService;
	
	//Fetches article by id
	@GetMapping(value= "bike/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BikeInfo> getBikeById(@PathVariable("id") Integer id) 
	{
		BikeInfo ob = new BikeInfo();
		BeanUtils.copyProperties(bikeService.getBikeById(id), ob);
		return new ResponseEntity<BikeInfo>(ob, HttpStatus.OK);
	}
	
	@GetMapping(value= "bike", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<BikeInfo>> getAllBike() 
	{
		List<BikeInfo> responseBikeList = new ArrayList<>();
		List<Bike> bikeList = bikeService.getAllBike();
		for (int i = 0; i < bikeList.size(); i++) 
	{
			BikeInfo ob = new BikeInfo();
		    BeanUtils.copyProperties(bikeList.get(i), ob);
		    responseBikeList.add(ob);    
	}
		return new ResponseEntity<List<BikeInfo>>(responseBikeList, HttpStatus.OK);
	}
	
	@PostMapping(value= "bike", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> addBike(@RequestBody BikeInfo bikeInfo, UriComponentsBuilder builder) {
		Bike bike = new Bike();
		BeanUtils.copyProperties(bikeInfo, bike);
                boolean flag = bikeService.addBike(bike);
                if (flag == false) {
        	   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/bike/{id}").buildAndExpand(bike.getBikeId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value= "bike", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BikeInfo> updateBike(@RequestBody BikeInfo bikeInfo) {
		Bike bike = new Bike();
		BeanUtils.copyProperties(bikeInfo, bike);		
		bikeService.updateBike(bike);
		
		BikeInfo ob = new BikeInfo();
		BeanUtils.copyProperties(bike, ob);
		return new ResponseEntity<BikeInfo>(ob, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value= "bike/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteBike(@PathVariable("id") Integer id) {
		bikeService.deleteBike(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}
