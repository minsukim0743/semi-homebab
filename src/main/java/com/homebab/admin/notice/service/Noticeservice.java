package com.homebab.admin.notice.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.homebab.admin.notice.model.dao.NoticeMapper;
import com.homebab.admin.notice.model.dto.NoticeDTO;

public class Noticeservice {

	private NoticeMapper noticeMapper;

	public List<NoticeDTO> selectNoticeList(NoticeDTO s_noticeList) {
		
		SqlSession sqlSqlSession = getSqlSession();
		
		noticeMapper = sqlSqlSession.getMapper(NoticeMapper.class);
		
		List<NoticeDTO> noticeList = noticeMapper.selectNoticeList(s_noticeList);

		sqlSqlSession.close();
		
		return noticeList;
		
		
	
	}

	public int insertNotice(NoticeDTO noticeList) {
		
		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		int result = noticeMapper.insertNotice(noticeList);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int deleteNotice(NoticeDTO noticeList) {
		
		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		int result = noticeMapper.deleteNotice(noticeList);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
}


	

