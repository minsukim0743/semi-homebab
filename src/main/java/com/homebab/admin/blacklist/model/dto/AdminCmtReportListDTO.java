package com.homebab.admin.blacklist.model.dto;

import com.homebab.admin.member.model.dto.AdminMemberMngDTO;

public class AdminCmtReportListDTO {
	
	private AdminBlacklistCmtReportDTO cmtReportDTO;
	private AdminBlacklistMemberDTO amDTO;
	private AdminBlacklistFbCommentsDTO fbCommentsDTO;
	private AdminBlacklistRcpCommentsDTO rcpCommentsDTO;
	private AdminMemberMngDTO adminMemberMngDTO;
	
	public AdminCmtReportListDTO() {}

	public AdminCmtReportListDTO(AdminBlacklistCmtReportDTO cmtReportDTO, AdminBlacklistMemberDTO amDTO,
			AdminBlacklistFbCommentsDTO fbCommentsDTO, AdminBlacklistRcpCommentsDTO rcpCommentsDTO,
			AdminMemberMngDTO adminMemberMngDTO) {
		super();
		this.cmtReportDTO = cmtReportDTO;
		this.amDTO = amDTO;
		this.fbCommentsDTO = fbCommentsDTO;
		this.rcpCommentsDTO = rcpCommentsDTO;
		this.adminMemberMngDTO = adminMemberMngDTO;
	}

	public AdminBlacklistCmtReportDTO getCmtReportDTO() {
		return cmtReportDTO;
	}

	public void setCmtReportDTO(AdminBlacklistCmtReportDTO cmtReportDTO) {
		this.cmtReportDTO = cmtReportDTO;
	}

	public AdminBlacklistMemberDTO getAmDTO() {
		return amDTO;
	}

	public void setAmDTO(AdminBlacklistMemberDTO amDTO) {
		this.amDTO = amDTO;
	}

	public AdminBlacklistFbCommentsDTO getFbCommentsDTO() {
		return fbCommentsDTO;
	}

	public void setFbCommentsDTO(AdminBlacklistFbCommentsDTO fbCommentsDTO) {
		this.fbCommentsDTO = fbCommentsDTO;
	}

	public AdminBlacklistRcpCommentsDTO getRcpCommentsDTO() {
		return rcpCommentsDTO;
	}

	public void setRcpCommentsDTO(AdminBlacklistRcpCommentsDTO rcpCommentsDTO) {
		this.rcpCommentsDTO = rcpCommentsDTO;
	}

	public AdminMemberMngDTO getAdminMemberMngDTO() {
		return adminMemberMngDTO;
	}

	public void setAdminMemberMngDTO(AdminMemberMngDTO adminMemberMngDTO) {
		this.adminMemberMngDTO = adminMemberMngDTO;
	}

	@Override
	public String toString() {
		return "AdminCmtReportListDTO [cmtReportDTO=" + cmtReportDTO + ", amDTO=" + amDTO + ", fbCommentsDTO="
				+ fbCommentsDTO + ", rcpCommentsDTO=" + rcpCommentsDTO + ", adminMemberMngDTO=" + adminMemberMngDTO
				+ "]";
	}
	
}
