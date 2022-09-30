package com.homebab.users.notice.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.common.pagin.SelectCriteria;
import com.homebab.users.notice.model.dto.NoticeDTO;

public interface NoticeMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<NoticeDTO> selectAllNoticeList(SelectCriteria selectCriteria);

	NoticeDTO selectNoticeDetail(int ntcIDx);

}
