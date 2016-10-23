package com.dutproject.cinemaproject.model.dao.test;

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
		staff.setBirthDay("03/03/1993");
		staff.setFullName("tran xuan son");
		staff.setIdentityCard("102120250");
		staff.setPassword("son dep trai");
		staff.setPermission(Account.Permission.FILM_MANAGER);
		staff.setPhoneNumber("01647891437");
		staff.setUserName("sontx1");
		staffs.add(staff);
		
		staff = new Staff();
		staff.setId(2);
		staff.setBirthDay("03/03/1994");
		staff.setFullName("tran xuan soan");
		staff.setIdentityCard("102120251");
		staff.setPassword("son lai dep trai");
		staff.setPermission(Account.Permission.ROOM_MANAGER);
		staff.setPhoneNumber("01647891438");
		staff.setUserName("sontx2");
		staffs.add(staff);
		
		staff = new Staff();
		staff.setId(3);
		staff.setBirthDay("03/03/1995");
		staff.setFullName("tran so soan");
		staff.setIdentityCard("102120253");
		staff.setPassword("son dep trai lam");
		staff.setPermission(Account.Permission.FILM_MANAGER);
		staff.setPhoneNumber("01647891439");
		staff.setUserName("sontx3");
		staffs.add(staff);
		
		return staffs;
	}

}
