package com.member.model;

import java.util.List;

public interface Member_Interface {
	public void insert(MemberVO memberVO);
	public void delete(int memberNo);
	public void update(MemberVO memberVO);
	public MemberVO findByPrimaryKey(Integer member_no);
	public List<MemberVO> getAll();
	public MemberVO findById(String member_id);
	public List<MemberVO> findGoogleById(String member_GoogleId);
}
