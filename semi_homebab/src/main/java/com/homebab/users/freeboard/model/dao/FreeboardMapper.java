package com.homebab.users.freeboard.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.common.pagin.SelectCriteria;
import com.homebab.users.freeboard.model.dto.FreeboardDTO;
import com.homebab.users.freeboard.model.dto.FreeboardFileUploadDTO;

public interface FreeboardMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<FreeboardDTO> selectAllFreeboardlist(SelectCriteria selectCriteria);

	FreeboardDTO selectFreeboardDetail(int fdIdx);

	int freeboardInsert(FreeboardDTO freeboard);
	
	int freeboardFileInsert(FreeboardFileUploadDTO freeboardFileUploadDTO);

	int incrementFreeboardCount(int fdIdx);

	FreeboardDTO selectFreeboardUpdate(int fbIdx);
	
	void freeboardFileUpdate(FreeboardFileUploadDTO item);
	
	int freeboardUpdate(FreeboardDTO freeboard);

	int deleteFile(FreeboardFileUploadDTO freeboardFileUploadDTO);

	int updateInsertFileUpload(FreeboardFileUploadDTO freeboarFile);
	
	int freeboardDeleteFile(int i);

	int freeboardDelete(int fbIdx);






	
	
}
