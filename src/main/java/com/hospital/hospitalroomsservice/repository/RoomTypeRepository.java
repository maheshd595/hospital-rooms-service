package com.hospital.hospitalroomsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalroomsservice.entities.RoomType; 

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long>{ 
}
