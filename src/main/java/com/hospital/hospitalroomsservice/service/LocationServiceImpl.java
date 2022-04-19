package com.hospital.hospitalroomsservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalroomsservice.entities.Location;
import com.hospital.hospitalroomsservice.entities.Rooms;
import com.hospital.hospitalroomsservice.modal.LocationsVO;
import com.hospital.hospitalroomsservice.modal.RoomsVO;
import com.hospital.hospitalroomsservice.repository.LocationRepository;
import com.hospital.hospitalroomsservice.repository.RoomsRepository;

@Service
public class LocationServiceImpl implements LocationService{
	@Autowired
    LocationRepository locationRepository;
	
	@Autowired
    RoomsRepository roomRepository;
	
	@Override
	public List<LocationsVO> getLocaitonsAndRooms() {
		List<Location> locations = locationRepository.findAll();
		List<LocationsVO> returnVOs = new ArrayList<LocationsVO>();
		for (Location location : locations) {
			LocationsVO locationVO = new LocationsVO();
			locationVO.setValue(location.getId());
			locationVO.setLabel(location.getName());
			List<Rooms> rooms = roomRepository.findByLocationId(location.getId());
			for (Rooms room : rooms) {
				RoomsVO roomsVO = new RoomsVO();
				roomsVO.setValue(room.getId());
				roomsVO.setLabel(room.getName());
				locationVO.addRooms(roomsVO);
			}
			returnVOs.add(locationVO);
		}
		return returnVOs;
	}

}
