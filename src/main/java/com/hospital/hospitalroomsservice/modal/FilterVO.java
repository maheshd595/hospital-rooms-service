package com.hospital.hospitalroomsservice.modal;

import java.util.Date;
import java.util.List;

public class FilterVO { 
	
	private Date startDate;
	private Date endDate;
	private List<String> weeks;
	private List<String> sessions;
	private List<Integer> roomStatus;
	private List<Integer> roomTypes;
	private List<Integer> locations;
	private List<Integer> rooms;
	private List<Integer> providers;  
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<String> getWeeks() {
		return weeks;
	}

	public void setWeeks(List<String> weeks) {
		this.weeks = weeks;
	}

	public List<String> getSessions() {
		return sessions;
	}

	public void setSessions(List<String> sessions) {
		this.sessions = sessions;
	} 

	public List<Integer> getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(List<Integer> roomStatus) {
		this.roomStatus = roomStatus;
	}

	public List<Integer> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<Integer> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public List<Integer> getLocations() {
		return locations;
	}

	public void setLocations(List<Integer> locations) {
		this.locations = locations;
	}

	public List<Integer> getRooms() {
		return rooms;
	}

	public void setRooms(List<Integer> rooms) {
		this.rooms = rooms;
	}

	public List<Integer> getProviders() {
		return providers;
	}

	public void setProviders(List<Integer> providers) {
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "FilterVO [startDate=" + startDate + ", endDate=" + endDate + ", weeks=" + weeks + ", sessions="
				+ sessions + ", roomStatus=" + roomStatus + ", roomTypes=" + roomTypes + ", locations=" + locations
				+ ", rooms=" + rooms + ", providers=" + providers + "]";
	} 
	
}
