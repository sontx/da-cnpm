package com.dutproject.cinemaproject.model.bean;

public class Account {
	private String username;
	private String password;
	private String permission;
	
	public static enum Permission {
		NO_PERMISSION, ACCOUNT_MANAGER, FILM_MANAGER, ROOM_MANAGER, SCHEDULE_MANAGER, TICKET_MANAGER
	}

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
