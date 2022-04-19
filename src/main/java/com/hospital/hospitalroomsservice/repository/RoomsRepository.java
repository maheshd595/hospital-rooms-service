package com.hospital.hospitalroomsservice.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalroomsservice.entities.Rooms; 

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long>{
	
	public List<Rooms> findByLocationIdIn(Collection<Integer> locationIds);
	
	public List<Rooms> findByLocationId(int locationId);

}
