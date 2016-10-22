package com.dutproject.cinemaproject.model.dao.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Staff;

public interface IAdminService {
	int getNumberOfStaffs();

	List<Staff> getStaffs(int offset, int count);
}
