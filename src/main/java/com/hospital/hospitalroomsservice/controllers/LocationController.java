package com.hospital.hospitalroomsservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalroomsservice.entities.Location;
import com.hospital.hospitalroomsservice.modal.LocationsVO;
import com.hospital.hospitalroomsservice.repository.LocationRepository;
import com.hospital.hospitalroomsservice.service.LocationService; 

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "*")
public class LocationController {
	@Autowired
    LocationRepository locationRepository;
	
	@Autowired
	LocationService locationService;

    @GetMapping("/all")
    public List<Location> getAll(){
        return locationRepository.findAll();
    }
    
    @GetMapping("")
    public List<LocationsVO> getLocationsAndRooms()
    { 
    	return locationService.getLocaitonsAndRooms();
    }
}
