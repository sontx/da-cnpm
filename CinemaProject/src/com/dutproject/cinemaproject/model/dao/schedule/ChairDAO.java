package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Chair;
import com.dutproject.cinemaproject.model.dao.schedule.reimplemented.ChairJdbc;
import com.dutproject.cinemaproject.model.dao.schedule.service.IChairService;

public class ChairDAO implements IChairService {
	private IChairService chairService = new ChairJdbc();

	@Override
	public List<Chair> getListChairs(int roomId) {
		return chairService.getListChairs(roomId);
	}

}
