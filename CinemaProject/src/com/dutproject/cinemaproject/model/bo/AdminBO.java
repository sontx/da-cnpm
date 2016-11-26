package com.dutproject.cinemaproject.model.bo;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.dao.AdminDAO;

public class AdminBO {
	private AdminDAO adminDAO = new AdminDAO();

	public List<AccountProfile> getStaffs(int offset, int count, String keyword) {
		return adminDAO.getStaffs(offset, count, keyword);
	}

	public boolean checkExistUserName(String userName) {
		return adminDAO.getStaffByUserName(userName) != null;
	}

	public boolean checkExistIdentifyCard(String identityCard) {
		return adminDAO.getStaffByIdentityCard(identityCard) != null;
	}

	public void addStaff(AccountProfile staff) {
		adminDAO.addStaff(staff);
	}

	public AccountProfile getStaff(int staffId) {
		return adminDAO.getStaffById(staffId);
	}

	public void updateStaff(AccountProfile staff) {
		adminDAO.updateStaff(staff);
	}

	public void deleteStaff(int id) {
		adminDAO.deleteStaff(id);
	}

	public AccountProfile getStaffByIdentityCard(String identityCard) {
		return adminDAO.getStaffByIdentityCard(identityCard);
	}
}
