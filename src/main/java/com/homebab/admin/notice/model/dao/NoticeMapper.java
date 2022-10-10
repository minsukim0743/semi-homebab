package com.homebab.admin.notice.model.dao;

import java.util.List;

import com.homebab.admin.notice.model.dto.NoticeDTO;

public interface NoticeMapper {

	List<NoticeDTO> selectNoticeList(NoticeDTO s_noticeList);

	int insertNotice(NoticeDTO noticeList);

	int deleteNotice(NoticeDTO noticeList);

	

}
