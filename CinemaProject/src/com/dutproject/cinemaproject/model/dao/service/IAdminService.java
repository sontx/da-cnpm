package com.dutproject.cinemaproject.model.dao.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.AccountProfile;

public interface IAdminService {
	int getNumberOfStaffs();

	List<AccountProfile> getStaffs(int offset, int count, String keyword);

	AccountProfile getStaffByUserName(String userName);

	AccountProfile getStaffByIdentityCard(String identityCard);

	void addStaff(AccountProfile staff);

	AccountProfile getStaffById(int staffId);

	void updateStaff(AccountProfile staff);

	void deleteStaff(int id);
}
