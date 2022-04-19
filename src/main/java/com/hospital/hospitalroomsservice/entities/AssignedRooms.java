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
@Table(name = "assigenedrooms")
public class AssignedRooms {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private Date fromDate;
	private Date toDate;
	private String session;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roomId", referencedColumnName = "id")
	private Rooms rooms;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "provider", referencedColumnName = "id")
	private Provider provider;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status", referencedColumnName = "id")
	private RoomStatus roomStatus;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roomType", referencedColumnName = "id")
	private RoomType roomType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	

}
