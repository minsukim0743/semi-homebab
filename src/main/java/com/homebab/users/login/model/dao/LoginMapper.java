package com.homebab.users.login.model.dao;

import java.util.Map;

import com.homebab.users.login.model.dto.UsersMngDTO;

public interface LoginMapper {

	int loginAdminSelect(Map<String, String> hm);

	String selectEncryptedPwd(Map<String, String> hm);

	UsersMngDTO loginUserSelect(Map<String, String> hm);

	String userSelectEncryptedPwd(Map<String, String> hm);

	int signUpIdCheck(String suId);

	int signUpNickNameCheck(String suNickName);

	UsersMngDTO findId(Map<String, String> hm);

	String selectOneEamil(String pfId);

	int modRandomAuth(Map<String, Object> hm);

	int authNumCheck(Map<String, Object> hm);

	int passwordModify(Map<String, Object> hm);


}
