package com.homebab.users.freeboard.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.common.pagin.SelectCriteria;
import com.homebab.users.freeboard.model.dao.FreeboardMapper;
import com.homebab.users.freeboard.model.dto.FreeboardDTO;
import com.homebab.users.freeboard.model.dto.FreeboardFileUploadDTO;

public class FreeboardService {

	private FreeboardMapper freeboardMapper;

	public int selectTotalCount(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		freeboardMapper = sqlSession.getMapper(FreeboardMapper.class);

		int totalCount = freeboardMapper.selectTotalCount(searchMap);

		sqlSession.close();

		return totalCount;
	}

	public List<FreeboardDTO> selectAllFreeboardlist(SelectCriteria selectCriteria) {

		SqlSession sqlSession = getSqlSession();
		freeboardMapper = sqlSession.getMapper(FreeboardMapper.class);
		List<FreeboardDTO> freeboardlist = freeboardMapper.selectAllFreeboardlist(selectCriteria);

		sqlSession.close();

		return freeboardlist;
	}

	public FreeboardDTO selectFreeboardDetail(int fdIdx) {

		SqlSession sqlSession = getSqlSession();
		freeboardMapper = sqlSession.getMapper(FreeboardMapper.class);

		FreeboardDTO freeboardDetail = freeboardMapper.selectFreeboardDetail(fdIdx);

		System.out.println(freeboardDetail);

		sqlSession.close();

		return freeboardDetail;
	}

	public int freeboardInsert(FreeboardDTO freeboard) {

		SqlSession sqlSession = getSqlSession();
		freeboardMapper = sqlSession.getMapper(FreeboardMapper.class);

		int result = 0;

		int freeboardResult = freeboardMapper.freeboardInsert(freeboard);

		System.out.println("Freeboard Result" + freeboardResult);

		List<FreeboardFileUploadDTO> fileList = freeboard.getFileList();

		for (int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setFileIdx(freeboard.getFbIdx());
		}

		int freeboardFileUpload = 0;
		for (int i = 0; i < fileList.size(); i++) {

			freeboardFileUpload += freeboardMapper.freeboardFileInsert(fileList.get(i));
		}

		System.out.println("freeboardFileUpload" + freeboardFileUpload);
		if (freeboardResult > 0 && freeboardFileUpload >= 0) {

			sqlSession.commit();
			result = 1;
		} else {

			sqlSession.rollback();
		}

		sqlSession.close();

		System.out.println("result" + result);
		
		return result;

	}

	public int freeboardUpdate(FreeboardDTO freeboard) {

		SqlSession sqlSession = getSqlSession();
		freeboardMapper = sqlSession.getMapper(FreeboardMapper.class);

		int result = 0;

		int freeboardResult = freeboardMapper.freeboardUpdate(freeboard);
		for (FreeboardFileUploadDTO item : freeboard.getFileList()) {
			freeboardMapper.freeboardFileUpdate(item);
		}
//		int freeboardResult = freeboardMapper.freeboardUpdate(freeboard);

		System.out.println(freeboardResult);

		if (freeboardResult > 0 ) {

			sqlSession.commit();
			result = 1;

		} else {

			sqlSession.rollback();
		}

		sqlSession.close();

		return result;

	}

	public int freeboardDeleteFile(int fbIdx) {

		SqlSession sqlSession = getSqlSession();
		freeboardMapper = sqlSession.getMapper(FreeboardMapper.class);
		FreeboardDTO freeboardDetail = new FreeboardService().selectFreeboardDetail(fbIdx);
		
		int result = 0;		
		
		for (FreeboardFileUploadDTO item : freeboardDetail.getFileList()) {
			freeboardMapper.freeboardDeleteFile(item.getFileIdx());
		}
		
		int deleteResult2 = freeboardMapper.freeboardDelete(fbIdx);
		if (deleteResult2 > 0) {

			sqlSession.commit();
			result = 1;
		} else {
			
			sqlSession.rollback();
		}

		sqlSession.close();

		return result;

	}
}
