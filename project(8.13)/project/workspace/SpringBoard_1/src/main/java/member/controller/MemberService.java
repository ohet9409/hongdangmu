package member.controller;

import java.util.List;

import member.bean.MemberDTO;

public interface MemberService {
	int write(MemberDTO memberDTO);
	String login(String id, String pwd);
	String isExistId(String id);
	MemberDTO selectOne(String id);
	int modify(MemberDTO memberDTO);
	int delete(String id);
	List<MemberDTO> selectList(int startNum, int endNum);
	int getTotalMember();
}
