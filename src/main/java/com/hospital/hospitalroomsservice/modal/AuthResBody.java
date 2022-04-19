package com.hospital.hospitalroomsservice.modal;

import com.hospital.hospitalroomsservice.entities.User;

public class AuthResBody {
	private boolean authenticated;
	private User user;  

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
