package com.dutproject.cinemaproject.model.dao.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.AccountProfile;

public interface IAdminService {
	int getNumberOfStaffs();

	List<AccountProfile> getStaffs(int offset, int count);

	boolean checkExistUserName(String userName);

	boolean checkExistIdentifyCard(String identityCard);

	void addStaff(AccountProfile staff);

	AccountProfile getStaff(int staffId);

	AccountProfile getStaffByIdentifyCard(String identityCard);

	void updateStaff(AccountProfile staff);

	void deleteStaff(int id);
}
