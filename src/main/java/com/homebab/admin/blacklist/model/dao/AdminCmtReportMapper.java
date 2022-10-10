package com.homebab.admin.blacklist.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.admin.blacklist.model.dto.AdminCmtReportListDTO;

public interface AdminCmtReportMapper {

	List<AdminCmtReportListDTO> cmtReportSelect();

	int cmtReportTotalCount(Map<String, String> searchMap);

	int adminCommentsDelete(String memberIdx);

}
