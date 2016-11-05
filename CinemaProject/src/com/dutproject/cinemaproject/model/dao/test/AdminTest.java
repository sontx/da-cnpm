package com.dutproject.cinemaproject.model.dao.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.Staff;
import com.dutproject.cinemaproject.model.dao.service.IAdminService;

public class AdminTest implements IAdminService {

	@Override
	public int getNumberOfStaffs() {
		return 3;
	}

	@Override
	public List<Staff> getStaffs(int offset, int count) {
		List<Staff> staffs = new ArrayList<>();
		
		Staff staff = new Staff();
		staff.setId(1);
		staff.setBirthDay(Date.valueOf("1993-3-3"));
		staff.setFullName("tran xuan son");
		staff.setIdentityCard("102120250");
		staff.setPassword("son dep trai");
		staff.setPermission(Account.FILM_MANAGER);
		staff.setPhoneNumber("01647891437");
		staff.setUserName("sontx1");
		staffs.add(staff);
		
		staff = new Staff();
		staff.setId(2);
		staff.setBirthDay(Date.valueOf("1993-3-4"));
		staff.setFullName("tran xuan soan");
		staff.setIdentityCard("102120251");
		staff.setPassword("son lai dep trai");
		staff.setPermission(Account.ROOM_MANAGER);
		staff.setPhoneNumber("01647891438");
		staff.setUserName("sontx2");
		staffs.add(staff);
		
		staff = new Staff();
		staff.setId(3);
		staff.setBirthDay(Date.valueOf("1993-3-5"));
		staff.setFullName("tran so soan");
		staff.setIdentityCard("102120253");
		staff.setPassword("son dep trai lam");
		staff.setPermission(Account.FILM_MANAGER);
		staff.setPhoneNumber("01647891439");
		staff.setUserName("sontx3");
		staffs.add(staff);
		
		return staffs;
	}

	@Override
	public boolean checkExistUserName(String userName) {
		// TODO Auto-generated method stub
		return userName.equals("sontx1");
	}

	@Override
	public boolean checkExistIdentifyCard(String identityCard) {
		// TODO Auto-generated method stub
		return identityCard.equals("123");
	}

	@Override
	public void addStaff(Staff staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Staff getStaff(int staffId) {
		Staff staff = new Staff();
		staff.setId(1);
		staff.setBirthDay(Date.valueOf("1993-3-3"));
		staff.setFullName("tran xuan son");
		staff.setIdentityCard("102120250");
		staff.setPassword("son dep trai");
		staff.setPermission(Account.FILM_MANAGER);
		staff.setPhoneNumber("01647891437");
		staff.setUserName("sontx1");
		return staff;
	}

	@Override
	public Staff getStaffByIdentifyCard(String identityCard) {
		if (identityCard.equals("123")) {
			Staff staff = new Staff();
			staff.setId(1);
			staff.setBirthDay(Date.valueOf("1993-3-3"));
			staff.setFullName("tran xuan son");
			staff.setIdentityCard("102120250");
			staff.setPassword("son dep trai");
			staff.setPermission(Account.FILM_MANAGER);
			staff.setPhoneNumber("01647891437");
			staff.setUserName("sontx1");
			return staff;
		}
		return null;
	}

	@Override
	public void updateStaff(Staff staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStaff(int id) {
		// TODO Auto-generated method stub
		
	}

}
