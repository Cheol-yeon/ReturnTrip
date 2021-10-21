package com.returntrip.dao;

import java.util.List;

import com.returntrip.entity.Member;

public interface MemberDao {
	
	Member getMemberData(String id); //관리자로 로그인시 사용자 정보 조회
	
	List<Member> getMemberDatas();
	
	int insertMember(Member member);
	
	int updateMember(Member member);
	
	int deleteMember(String id);
	
}
