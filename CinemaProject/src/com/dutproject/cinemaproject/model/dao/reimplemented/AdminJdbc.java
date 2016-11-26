package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.dao.service.IAdminService;

public class AdminJdbc extends JdbcService implements IAdminService {

	@Override
	public int getNumberOfStaffs() {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call admin_getStaffsCount}");
			ResultSet rs = callable.executeQuery();
			if (rs.next())
				return rs.getInt(1);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return 0;
	}

	@Override
	public List<AccountProfile> getStaffs(int offset, int count, String keyword) {
		CallableStatement callable = null;
		try {
			if (keyword == null || "".equals(keyword)) {
				callable = connection.prepareCall("{call admin_getAllStaffs(?,?)}");
			} else {
				callable = connection.prepareCall("{call admin_getStaffs(?,?,?)}");
				callable.setString(3, keyword);
			}
			callable.setInt(1, offset);
			callable.setInt(2, count);
			
			ResultSet rs = callable.executeQuery();
			List<AccountProfile> profiles = new ArrayList<>();
			while (rs.next()) {
				AccountProfile accountProfile = new AccountProfile();
				accountProfile.setId(rs.getString("profileId"));
				accountProfile.setFullName(rs.getString("fullName"));
				accountProfile.setBirthDay(rs.getDate("birthday"));
				accountProfile.setPhoneNumber(rs.getString("phoneNumber"));
				accountProfile.setIdentityCard(rs.getString("identityCard"));
				Account account = new Account(rs.getString("username"), "");
				account.setId(rs.getInt("accountId"));
				account.setPermission(rs.getInt("permission"));
				accountProfile.setAccount(account);
				profiles.add(accountProfile);
			}
			rs.close();
			return profiles;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return null;
	}

	@Override
	public void addStaff(AccountProfile staff) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call admin_addStaff(?,?,?,?,?,?,?,?)}");
			callable.setString(1, staff.getId());
			callable.setString(2, staff.getFullName());
			callable.setString(3, staff.getAccount().getUsername());
			callable.setString(4, staff.getAccount().getPassword());
			callable.setDate(5, staff.getBirthDay());
			callable.setString(6, staff.getPhoneNumber());
			callable.setString(7, staff.getIdentityCard());
			callable.setInt(8, staff.getAccount().getPermission());
			callable.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void updateStaff(AccountProfile staff) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call admin_updateStaff(?,?,?,?,?,?)}");
			callable.setInt(1, staff.getAccount().getId());
			callable.setString(2, staff.getFullName());
			callable.setString(3, staff.getAccount().getPassword());
			callable.setDate(4, staff.getBirthDay());
			callable.setString(5, staff.getPhoneNumber());
			callable.setInt(6, staff.getAccount().getPermission());
			callable.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void deleteStaff(int id) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call admin_deleteStaff(?)}");
			callable.setInt(1, id);
			callable.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public AccountProfile getStaffByUserName(String userName) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call admin_getStaffByUserName(?)}");
			callable.setString(1, userName);
			ResultSet rs = callable.executeQuery();
			if (rs.next()) {
				AccountProfile accountProfile = new AccountProfile();
				accountProfile.setId(rs.getString("profileId"));
				accountProfile.setFullName(rs.getString("fullName"));
				accountProfile.setBirthDay(rs.getDate("birthday"));
				accountProfile.setPhoneNumber(rs.getString("phoneNumber"));
				accountProfile.setIdentityCard(rs.getString("identityCard"));
				Account account = new Account(rs.getString("username"), "");
				account.setId(rs.getInt("accountId"));
				account.setPermission(rs.getInt("permission"));
				accountProfile.setAccount(account);
				rs.close();
				return accountProfile;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return null;
	}

	@Override
	public AccountProfile getStaffByIdentityCard(String identityCard) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call admin_getStaffByIdentityCard(?)}");
			callable.setString(1, identityCard);
			ResultSet rs = callable.executeQuery();
			if (rs.next()) {
				AccountProfile accountProfile = new AccountProfile();
				accountProfile.setId(rs.getString("profileId"));
				accountProfile.setFullName(rs.getString("fullName"));
				accountProfile.setBirthDay(rs.getDate("birthday"));
				accountProfile.setPhoneNumber(rs.getString("phoneNumber"));
				accountProfile.setIdentityCard(rs.getString("identityCard"));
				Account account = new Account(rs.getString("username"), "");
				account.setId(rs.getInt("accountId"));
				account.setPermission(rs.getInt("permission"));
				accountProfile.setAccount(account);
				rs.close();
				return accountProfile;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return null;
	}

	@Override
	public AccountProfile getStaffById(int staffId) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call admin_getStaffById(?)}");
			callable.setInt(1, staffId);
			ResultSet rs = callable.executeQuery();
			if (rs.next()) {
				AccountProfile accountProfile = new AccountProfile();
				accountProfile.setId(rs.getString("profileId"));
				accountProfile.setFullName(rs.getString("fullName"));
				accountProfile.setBirthDay(rs.getDate("birthday"));
				accountProfile.setPhoneNumber(rs.getString("phoneNumber"));
				accountProfile.setIdentityCard(rs.getString("identityCard"));
				Account account = new Account(rs.getString("username"), "");
				account.setId(rs.getInt("accountId"));
				account.setPermission(rs.getInt("permission"));
				accountProfile.setAccount(account);
				rs.close();
				return accountProfile;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return null;
	}

}
