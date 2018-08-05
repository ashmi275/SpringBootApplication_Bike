package com.bike.service;

import java.util.List;
import com.bike.entity.Bike;

public interface IBikeService {
	
     List<Bike> getAllBike();
     Bike getBikeById(long Id);
     boolean addBike(Bike bike);
     void updateBike(Bike bike);
     void deleteBike(int BikeId);
} 


