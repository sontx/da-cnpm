package com.dutproject.cinemaproject.model.dao.schedule.reimplemented;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.controller.schedule.ScheduleManagementServlet;
import com.dutproject.cinemaproject.model.bean.schedule.Schedule;
import com.dutproject.cinemaproject.model.dao.reimplemented.JdbcService;
import com.dutproject.cinemaproject.model.dao.schedule.service.IScheduleService;

public class ScheduleJdbc extends JdbcService implements IScheduleService {

	@Override
	public boolean createSchedule(Schedule schedule) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_createSchedule(?, ?, ?, ?)}");
			callable.setInt(1, schedule.getRoomId());
			callable.setInt(2, schedule.getFilmId());
			callable.setInt(3, schedule.getStartTime());
			callable.setInt(4, schedule.getEndTime());
			int i = callable.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return false;
	}

	@Override
	public int getNumOfSchedules() {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_getNumOfSchedules}");
			ResultSet rs = callable.executeQuery();
			int numOfSchedules = 0;
			if (rs.next()) {
				numOfSchedules = rs.getInt("numOfSchedules");
			}
			rs.close();
			return numOfSchedules;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return 0;
	}

	@Override
	public List<Schedule> getListSchedules(int pageNumber) {
		CallableStatement callable = null;
		try {
			int startIndex = 1 + (pageNumber - 1) * ScheduleManagementServlet.MAX_SCHEDULE_PER_PAGE;
			int endIndex = startIndex + ScheduleManagementServlet.MAX_SCHEDULE_PER_PAGE - 1;
			int maxIndex = getNumOfSchedules();
			if (endIndex > maxIndex) {
				endIndex = maxIndex;
			}
			
			callable = connection.prepareCall("{call schedule_getListSchedules(?,?)}");
			callable.setInt(1, startIndex);
			callable.setInt(2, endIndex);
			ResultSet rs = callable.executeQuery();
			List<Schedule> listSchedules = parseResultSetToListSchedules(rs);
			rs.close();
			return listSchedules;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return null;
	}

	private List<Schedule> parseResultSetToListSchedules(ResultSet rs) throws SQLException {
		List<Schedule> listSchedules = new ArrayList<Schedule>();
		while (rs.next()) {
			listSchedules.add(parseResultSetToSchedule(rs));
		}
		return listSchedules;
	}

	private Schedule parseResultSetToSchedule(ResultSet rs) throws SQLException {
		int scheduleId = rs.getInt("scheduleId");
		int roomId = rs.getInt("roomId");
		int filmId = rs.getInt("filmId");
		int startTime = rs.getInt("startTime");
		int endTime = rs.getInt("endTime");
		return new Schedule(scheduleId, filmId, roomId, startTime, endTime);
	}

	@Override
	public boolean deleteScheduleById(int id) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_deleteScheduleById(?)}");
			callable.setInt(1, id);
			int i = callable.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return false;
	}

	@Override
	public boolean updateSchedule(Schedule schedule) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_updateSchedule(?,?,?,?,?)}");
			callable.setInt(1, schedule.getScheduleId());
			callable.setInt(2, schedule.getRoomId());
			callable.setInt(3, schedule.getFilmId());
			callable.setInt(4, schedule.getStartTime());
			callable.setInt(5, schedule.getEndTime());
			int i = callable.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return false;
	}

	@Override
	public Schedule getScheduleById(int id) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_getScheduleById(?)}");
			callable.setInt(1, id);
			ResultSet rs = callable.executeQuery();
			Schedule schedule = null;
			if (rs.next()) {
				schedule = parseResultSetToSchedule(rs);
			}
			rs.close();
			return schedule;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return null;
	}

	@Override
	public int getScheduleId(Schedule schedule) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_getScheduleId(?,?,?,?)}");
			callable.setInt(1, schedule.getRoomId());
			callable.setInt(2, schedule.getFilmId());
			callable.setInt(3, schedule.getStartTime());
			callable.setInt(4, schedule.getEndTime());
			ResultSet rs = callable.executeQuery();
			int scheduleId = 0;
			if (rs.next()) {
				scheduleId = rs.getInt("scheduleId");
			}
			rs.close();
			return scheduleId;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return 0;
	}

}
