package com.dutproject.cinemaproject.model.bo;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.dao.AdminDAO;

public class AdminBO {
	private AdminDAO adminDAO = new AdminDAO();

	public List<AccountProfile> getStaffs(int offset, int count) {
		return adminDAO.getStaffs(offset, count);
	}

	public boolean checkExistUserName(String userName) {
		return adminDAO.checkExistUserName(userName);
	}

	public boolean checkExistIdentifyCard(String identityCard) {
		return adminDAO.checkExistIdentifyCard(identityCard);
	}

	public void addStaff(AccountProfile staff) {
		adminDAO.addStaff(staff);
	}

	public AccountProfile getStaff(int staffId) {
		return adminDAO.getStaff(staffId);
	}

	public AccountProfile getStaffByIdentifyCard(String identityCard) {
		return adminDAO.getStaffByIdentifyCard(identityCard);
	}

	public void updateStaff(AccountProfile staff) {
		adminDAO.updateStaff(staff);
	}

	public void deleteStaff(int id) {
		adminDAO.deleteStaff(id);
	}
}
