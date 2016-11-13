package com.dutproject.cinemaproject.model.bean;

import java.math.BigDecimal;

public class Ticket {
	private int ticketId;
	private int scheduleId;
	private int chairId;
	private BigDecimal price;
	private String state;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int ticketId, int scheduleId, int chairId, BigDecimal price, String state) {
		super();
		this.ticketId = ticketId;
		this.scheduleId = scheduleId;
		this.chairId = chairId;
		this.price = price;
		this.state = state;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public int getChairId() {
		return chairId;
	}
	public void setChairId(int chairId) {
		this.chairId = chairId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal bigDecimal) {
		this.price = bigDecimal;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
