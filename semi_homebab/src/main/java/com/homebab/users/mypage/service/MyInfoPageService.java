package com.homebab.users.mypage.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.mypage.model.dao.MyInfoPageMapper;
import com.homebab.users.mypage.model.dto.MyInfoDTO;

public class MyInfoPageService {
	
	private MyInfoPageMapper myInfoPageMapper;

	/**
	 * 닉네임 체크 서비스 메소드 
	 * @param nickName
	 * @return
	 */
	public int checkNickName(String nickName) {
		SqlSession sqlSession = getSqlSession();
		
		myInfoPageMapper = sqlSession.getMapper(MyInfoPageMapper.class);
		
		int result = myInfoPageMapper.checkNickName(nickName);
		System.out.println(result);
		sqlSession.close();
		
		return result;
	}

	/**
	 * 회원탈퇴 서비스 메소드 
	 * @param memberWithdrawal
	 * @return
	 */
	public int updateUsersWithdrawal(MyInfoDTO memberWithdrawal) {
		SqlSession sqlSession = getSqlSession();
		
		myInfoPageMapper = sqlSession.getMapper(MyInfoPageMapper.class);
		System.out.println(memberWithdrawal);
		int result = myInfoPageMapper.updateUsersWithdrawal(memberWithdrawal);
		System.out.println(" 매퍼 찍고온 service의 result : " + result);
		
		if(result > 0) {
			
			System.out.println("회원탈퇴 성공하였습니다 ");
			sqlSession.commit();
			
		} else {
			
			System.out.println("회원탈퇴 실패하셨습니다 ");
			sqlSession.rollback();
		}
		
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * 유저 정보저장하기 서비스 메소드 
	 * @param myInfoDTO
	 * @return
	 */
	public int updateMyInfoSave(MyInfoDTO myInfoDTO) {
		
		SqlSession sqlSession = getSqlSession();
		
		myInfoPageMapper = sqlSession.getMapper(MyInfoPageMapper.class);
		
		System.out.println(myInfoDTO);
		
		int result = myInfoPageMapper.updateMyInfoSave(myInfoDTO);
		
		System.out.println("매퍼 찍고온 withdrawalDTO : " + result );
		
		if(result > 0) {
			
			System.out.println("회원정보 수정에 성공했습니다:) ");
			sqlSession.commit();
			
		} else {
			
			System.out.println("회원정보 수정에 실패하셨습니다 ");
			sqlSession.rollback();
		}
		
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * 유저 정보 조회하기 페이지 서비스 메소
	 * @param loginUserIdx
	 * @return
	 */
	public List<UsersMngDTO> selectMember(int loginUserIdx) {
		
		SqlSession sqlSession = getSqlSession();
		
		myInfoPageMapper = sqlSession.getMapper(MyInfoPageMapper.class);
		
		List<UsersMngDTO> userList = myInfoPageMapper.selectMember(loginUserIdx);
		
		sqlSession.close();
		return userList;
	}
		


}
