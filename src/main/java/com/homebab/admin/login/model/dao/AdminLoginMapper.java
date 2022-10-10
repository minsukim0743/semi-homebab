package com.homebab.admin.login.model.dao;

import com.homebab.admin.login.model.dto.AdminDTO;

public interface AdminLoginMapper {
	
	String selectEncryptPwd(AdminDTO requestAdmin);

	AdminDTO adminLogin(AdminDTO requestAdmin);

}
