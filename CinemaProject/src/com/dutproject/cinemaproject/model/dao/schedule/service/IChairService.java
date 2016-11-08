package com.dutproject.cinemaproject.model.dao.schedule.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Chair;

public interface IChairService {

	List<Chair> getListChairs(int roomId);

}
