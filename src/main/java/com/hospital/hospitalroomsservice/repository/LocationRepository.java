package com.hospital.hospitalroomsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalroomsservice.entities.Location; 

@Repository
public interface LocationRepository extends JpaRepository<Location , Long>{

}
