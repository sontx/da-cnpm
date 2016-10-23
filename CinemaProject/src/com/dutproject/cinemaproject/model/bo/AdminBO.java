package com.dutproject.cinemaproject.model.bo;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Staff;
import com.dutproject.cinemaproject.model.dao.AdminDAO;

public class AdminBO {
	private AdminDAO adminDAO = new AdminDAO();

	public List<Staff> getStaffs(int offset, int count) {
		return adminDAO.getStaffs(offset, count);
	}
}
