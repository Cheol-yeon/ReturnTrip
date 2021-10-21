package com.returntrip.service;

import java.util.List;

import com.returntrip.dao.MemberDao;
import com.returntrip.entity.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberdao;
	
	
	public MemberServiceImpl(MemberDao memberdao) {
		super();
		this.memberdao = memberdao;
	}

	@Override
	public Member getMemberData(String id) {
		// TODO Auto-generated method stub
		return memberdao.getMemberData(id);
	}

	@Override
	public List<Member> getMemberDatas() {
		// TODO Auto-generated method stub
		return memberdao.getMemberDatas();
	}

	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return memberdao.insertMember(member);
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return memberdao.updateMember(member);
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return memberdao.deleteMember(id);
	}

}
