package com.dutproject.cinemaproject.model.dao.schedule.service;

import java.math.BigDecimal;

public interface ITicketService {

	boolean createTicket(int chairId, int scheduleId, BigDecimal price);

}
