package com.dutproject.cinemaproject.model.bo;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Staff;
import com.dutproject.cinemaproject.model.dao.AdminDAO;

public class AdminBO {
	private AdminDAO adminDAO = new AdminDAO();

	public List<Staff> getStaffs(int offset, int count) {
		return adminDAO.getStaffs(offset, count);
	}

	public boolean checkExistUserName(String userName) {
		return adminDAO.checkExistUserName(userName);
	}

	public boolean checkExistIdentifyCard(String identityCard) {
		return adminDAO.checkExistIdentifyCard(identityCard);
	}

	public void addStaff(Staff staff) {
		adminDAO.addStaff(staff);
	}

	public Staff getStaff(int staffId) {
		return adminDAO.getStaff(staffId);
	}

	public Staff getStaffByIdentifyCard(String identityCard) {
		return adminDAO.getStaffByIdentifyCard(identityCard);
	}

	public void updateStaff(Staff staff) {
		adminDAO.updateStaff(staff);
	}
}
