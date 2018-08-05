package com.bike.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class BikeInfo {

	@JsonInclude(Include.NON_NULL)
    private long bikeId;
@JsonInclude(Include.NON_NULL)
    private String name;
@JsonInclude(Include.NON_NULL)
    private String model;
@JsonInclude(Include.NON_NULL)
private long mileage;

public long getBikeId() {
	return bikeId;
}
public void setBikeId(long bikeId) {
	this.bikeId = bikeId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
} 
public long getMileage() {
	return mileage;
}
public void setMileage(long mileage) {
	this.mileage = mileage;
}
}
