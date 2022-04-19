package com.hospital.hospitalroomsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalroomsservice.entities.RoomStatus; 

@Repository
public interface RoomStatusRepository extends JpaRepository<RoomStatus, Long>{ 
}
