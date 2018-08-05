package com.bike.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bike.entity.Bike;
import com.bike.repository.BikeRepository;
@Service

public class BikeService implements IBikeService {

	@Autowired
	private BikeRepository bikeRepository;
	public Bike getBikeById(long bikeId) {
		Bike obj = bikeRepository.findById(Id).get();
		return obj;
	}	
	@Override
	public List<Bike> getAllBike(){
		List<Bike> list = new ArrayList<>();
		bikeRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addBike(Bike bike){
	        List<Bike> list = bikeRepository.findByNameAndModel(bike.getName(), bike.getModel()); 	
                  if (list.size() > 0) {
    	          return false;
                } else {
    	          bikeRepository.save(bike);
    	          return true;
                }
	}
	@Override
	public void updateBike(Bike bike) {
		bikeRepository.save(bike);
	}
	@Override
	public void deleteBike(int bikeId) {
		bikeRepository.delete(getBikeById(bikeId));
	}
}
