package com.dutproject.cinemaproject.model.dao.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.dao.service.IAdminService;

public class AdminTest implements IAdminService {

	@Override
	public int getNumberOfStaffs() {
		return 3;
	}

	@Override
	public List<AccountProfile> getStaffs(int offset, int count) {
		List<AccountProfile> staffs = new ArrayList<>();
		
		
		
		return staffs;
	}
	
	@Override
	public void addStaff(AccountProfile staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStaff(AccountProfile staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStaff(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountProfile getStaffByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountProfile getStaffByIdentityCard(String identityCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountProfile getStaffById(int staffId) {
		// TODO Auto-generated method stub
		return null;
	}

}
