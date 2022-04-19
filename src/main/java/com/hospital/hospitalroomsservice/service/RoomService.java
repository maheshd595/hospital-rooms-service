package com.hospital.hospitalroomsservice.service;

import java.sql.Date;
import java.util.List;

import com.hospital.hospitalroomsservice.modal.AssignProvidersVO;
import com.hospital.hospitalroomsservice.modal.AssignedRoomsVO;
import com.hospital.hospitalroomsservice.modal.FilterVO;
import com.hospital.hospitalroomsservice.modal.OptionsVO;
import com.hospital.hospitalroomsservice.modal.RoomsVO;

public interface RoomService {
	public List<OptionsVO> getAllRooms();
	
	public List<RoomsVO> getRoomsByLocation (String locationIds);
	
	public List<OptionsVO> getAllRoomTypes();
	
	public List<OptionsVO> getAllRoomStatus();
	
	public List<OptionsVO> getAllProviders();
	
	public List<AssignedRoomsVO> getAllAssignedRooms(FilterVO filters);
	
	public String assignProviderToRoom(AssignProvidersVO assignProviders);

	public List<OptionsVO> getAvilableProviders(Date date, String session, int providerId);
}
