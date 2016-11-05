package com.dutproject.cinemaproject.model.dao;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
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
	public List<AccountProfile> getStaffs(int offset, int count) {
		return underlyingService.getStaffs(offset, count);
	}
	
	@Override
	public boolean checkExistUserName(String userName) {
		return underlyingService.checkExistUserName(userName);
	}

	public boolean checkExistIdentifyCard(String identityCard) {
		return underlyingService.checkExistIdentifyCard(identityCard);
	}

	public void addStaff(AccountProfile staff) {
		underlyingService.addStaff(staff);
	}

	public AccountProfile getStaff(int staffId) {
		return underlyingService.getStaff(staffId);
	}

	public AccountProfile getStaffByIdentifyCard(String identityCard) {
		return underlyingService.getStaffByIdentifyCard(identityCard);
	}

	public void updateStaff(AccountProfile staff) {
		underlyingService.updateStaff(staff);
	}

	public void deleteStaff(int id) {
		underlyingService.deleteStaff(id);
	}

}
