package com.dutproject.cinemaproject.model.bo.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Chair;
import com.dutproject.cinemaproject.model.dao.schedule.ChairDAO;

public class ChairBO {
	private ChairDAO chairDAO = new ChairDAO();

	public List<Chair> getListChairs(int roomId) {
		return chairDAO.getListChairs(roomId);
	}

}
