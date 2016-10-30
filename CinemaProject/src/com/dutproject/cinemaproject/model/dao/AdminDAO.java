package com.dutproject.cinemaproject.model.dao;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Staff;
import com.dutproject.cinemaproject.model.dao.reimplemented.AdminJdbc;
import com.dutproject.cinemaproject.model.dao.service.IAdminService;
import com.dutproject.cinemaproject.model.dao.test.AdminTest;

public class AdminDAO implements IAdminService {
	// private IAdminService underlyingService = new AdminJdbc();
	private IAdminService underlyingService = new AdminTest();

	@Override
	public int getNumberOfStaffs() {
		return underlyingService.getNumberOfStaffs();
	}

	@Override
	public List<Staff> getStaffs(int offset, int count) {
		return underlyingService.getStaffs(offset, count);
	}
	
	@Override
	public boolean checkExistUserName(String userName) {
		return underlyingService.checkExistUserName(userName);
	}

	public boolean checkExistIdentifyCard(String identityCard) {
		return underlyingService.checkExistIdentifyCard(identityCard);
	}

	public void addStaff(Staff staff) {
		underlyingService.addStaff(staff);
	}

}
