package com.homebab.admin.blacklist.controller;

public class split {

public static void main(String[] args) {
		
		String parameter = "81?memberIdx=125?cmtIdx=123";
		
		String[] arrIdx = parameter.split("\\?");
		
		String rcpIdx = arrIdx[0];
		
		String paramMemberIdx = arrIdx[1];
		String[] arrMemberIdx = paramMemberIdx.split("\\=");
		String memberIdx = arrMemberIdx[1];
		
		String paramCmtIdx = arrIdx[2];
		String[] arrCmtIdx = paramCmtIdx.split("\\=");
		String cmtIdx = arrCmtIdx[1];
		
		
	
		System.out.println("rcpIdx " + rcpIdx);
		System.out.println("memberIdx " + memberIdx);
		System.out.println("cmtIdx " + cmtIdx);
		
		


	}
}
