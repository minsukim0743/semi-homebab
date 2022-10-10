package com.homebab.users.mypage.model.dao;


import java.util.List;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.mypage.model.dto.MyInfoDTO;

public interface MyInfoPageMapper {

	

	int checkNickName(String nickName);

	int updateUsersWithdrawal(MyInfoDTO memberWithdrawal);

	int updateMyInfoSave(MyInfoDTO myInfoDTO);

	List<UsersMngDTO> selectMember(int loginUserIdx);
	
	
	





}
