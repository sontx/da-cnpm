package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.dao.service.IAdminService;

public class AdminJdbc extends JdbcService implements IAdminService {

	@Override
	public int getNumberOfStaffs() {
		String sql = "SELECT COUNT(*) FROM staff";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next())
				return resultSet.getInt(1);
			resultSet.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		return 0;
	}

	@Override
	public List<AccountProfile> getStaffs(int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExistUserName(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistIdentifyCard(String identityCard) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addStaff(AccountProfile staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountProfile getStaff(int staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountProfile getStaffByIdentifyCard(String identityCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStaff(AccountProfile staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStaff(int id) {
		// TODO Auto-generated method stub
		
	}

}
