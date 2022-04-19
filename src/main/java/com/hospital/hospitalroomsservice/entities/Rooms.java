package com.hospital.hospitalroomsservice.entities;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Rooms {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name; 
    
    private Date creationDate; 
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location", referencedColumnName = "id")
    private Location location; 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	} 

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	} 
}
