package com.hospital.hospitalroomsservice.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalroomsservice.entities.AssignedRooms; 

@Repository
public interface AssignedRoomsRepository extends JpaRepository<AssignedRooms, Integer>{ 
	 
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update assigenedrooms set provider= :providerId, status= :roomTypeId where id = :assignRoomId") 
	void updateProviderForRoom(Integer providerId, int assignRoomId, int roomTypeId);
	
	@Query(nativeQuery = true, value ="select distinct provider from assigenedrooms where fromDate= :fromDate and session= :session")
	public List<Integer> getAssingedRoomsByDateAndSesion(Date fromDate, String session);
}
