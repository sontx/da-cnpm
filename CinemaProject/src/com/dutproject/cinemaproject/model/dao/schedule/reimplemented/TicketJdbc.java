package com.dutproject.cinemaproject.model.dao.schedule.reimplemented;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;

import com.dutproject.cinemaproject.model.dao.reimplemented.JdbcService;
import com.dutproject.cinemaproject.model.dao.schedule.service.ITicketService;

public class TicketJdbc extends JdbcService implements ITicketService {

	@Override
	public boolean createTicket(int scheduleId, int chairId, BigDecimal price) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_createTicket(?,?,?)}");
			callable.setInt(1, scheduleId);
			callable.setInt(2, chairId);
			callable.setBigDecimal(3, price);
			int i = callable.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != callable) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return false;
	}

}
