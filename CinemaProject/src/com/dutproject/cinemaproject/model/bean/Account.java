package com.dutproject.cinemaproject.model.bean;

public class Account {
	public static final int NO_PERMISSION = 0;
	public static final int ACCOUNT_MANAGER = 1;
	public static final int FILM_MANAGER = 2;
	public static final int ROOM_MANAGER = 3;
	public static final int SCHEDULE_MANAGER = 4;
	public static final int TICKET_MANAGER = 5;

	private int id;
	private String username;
	private String password;
	private int permission;

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Account() {
		// TODO Auto-generated constructor stub
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

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	public static String getPermissionString(int permission) {
		if (permission == ACCOUNT_MANAGER)
			return "Account Manager";
		if (permission == FILM_MANAGER)
			return "Film Manager";
		if (permission == ROOM_MANAGER)
			return "Room Manager";
		if (permission == SCHEDULE_MANAGER)
			return "Schedule Manager";
		if (permission == TICKET_MANAGER)
			return "Ticket Manager";
		return "No Permission";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
