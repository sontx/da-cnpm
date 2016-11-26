package com.dutproject.cinemaproject.model.dao;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.dao.reimplemented.AdminJdbc;
import com.dutproject.cinemaproject.model.dao.service.IAdminService;
import com.dutproject.cinemaproject.model.dao.test.AdminTest;

public class AdminDAO implements IAdminService {
	private IAdminService underlyingService = new AdminJdbc();
	// private IAdminService underlyingService = new AdminTest();

	@Override
	public int getNumberOfStaffs() {
		return underlyingService.getNumberOfStaffs();
	}

	@Override
	public List<AccountProfile> getStaffs(int offset, int count, String keyword) {
		return underlyingService.getStaffs(offset, count, keyword);
	}

	public void addStaff(AccountProfile staff) {
		underlyingService.addStaff(staff);
	}

	public AccountProfile getStaffById(int staffId) {
		return underlyingService.getStaffById(staffId);
	}

	public void updateStaff(AccountProfile staff) {
		underlyingService.updateStaff(staff);
	}

	public void deleteStaff(int id) {
		underlyingService.deleteStaff(id);
	}

	@Override
	public AccountProfile getStaffByUserName(String userName) {
		return underlyingService.getStaffByUserName(userName);
	}

	@Override
	public AccountProfile getStaffByIdentityCard(String identityCard) {
		return underlyingService.getStaffByIdentityCard(identityCard);
	}

}
