package com.hospital.hospitalroomsservice.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalroomsservice.entities.Rooms;
import com.hospital.hospitalroomsservice.modal.OptionsVO;
import com.hospital.hospitalroomsservice.service.RoomService;

@RestController
@RequestMapping("/filter")
@CrossOrigin(origins = "*")
public class FilterController {
	@Autowired
	RoomService roomService;

	@GetMapping("/rooms")
	public List<OptionsVO> getAllRooms() {
		return roomService.getAllRooms();
	}

	@GetMapping("/room-types")
	public List<OptionsVO> getRoomTypes() {
		return roomService.getAllRoomTypes();
	}

	@GetMapping("/room-status")
	public List<OptionsVO> getAllRoomStatus() {
		return roomService.getAllRoomStatus();
	}

	@GetMapping("/providers")
	public List<OptionsVO> getAllProviders() {
		return roomService.getAllProviders();
	}

	@GetMapping("/providers/date/{date}/session/{session}/provider/{provider}")
	public List<OptionsVO> getAvilableProviders(@PathVariable(value = "date") Date date,
			@PathVariable(value = "session") String session, @PathVariable(value = "provider") int providerId) {
		return roomService.getAvilableProviders(date, session, providerId);
	}
}
