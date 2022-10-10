package com.homebab.users.notice.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.common.pagin.SelectCriteria;
import com.homebab.users.freeboard.model.dao.FreeboardMapper;
import com.homebab.users.freeboard.model.dto.FreeboardDTO;
import com.homebab.users.notice.model.dao.NoticeMapper;
import com.homebab.users.notice.model.dto.NoticeDTO;
import com.homebab.users.suggestion.model.dao.SuggestionMapper;
import com.homebab.users.suggestion.model.dto.SuggestionDTO;

public class NoticeService {

	private NoticeMapper noticeMapper;

	public List<NoticeDTO> selectAllNoticeList(SelectCriteria selectCriteria) {

		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		List<NoticeDTO> noticeList = noticeMapper.selectAllNoticeList(selectCriteria);
		
		sqlSession.close();
		
		return noticeList;
		
	}

	public int selectTotalCount(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		int totalCount = noticeMapper.selectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;	
	}

	public NoticeDTO selectNoticeDetail(int ntcIDx) {
		
		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		NoticeDTO noticeDetail = noticeMapper.selectNoticeDetail(ntcIDx);
		
		sqlSession.close();

		return noticeDetail;
	}
	
}
