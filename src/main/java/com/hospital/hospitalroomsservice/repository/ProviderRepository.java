package com.hospital.hospitalroomsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalroomsservice.entities.Provider; 

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{ 
}
