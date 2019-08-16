package member.dao;
/* JDBC  작업단계 
 * 1. Driver Loading
 * 2. Connection
 * 3. SQL 작업처리
 * 4. 반환값 처리
 * 5. 접속 종료
 * */


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.bean.MemberDTO;
@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	/* 3. SQL 작업처리
	   4. 반환값 처리 */
	// 데이터 저장
	public int write(MemberDTO memberDTO) {
		
		return sessionTemplate.insert("mybatis.memberMapper.write", memberDTO);
	}
	// 로그인 검사
	public String login(String id, String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		return sessionTemplate.selectOne("mybatis.memberMapper.login", map);
	}
	// ID 데이터 검색 : 존재 확인
	public String isExistId(String id) {
		
		return sessionTemplate.selectOne("mybatis.memberMapper.isExistId", id);
	}
	// ID 데이터 검색 : 1명 데이터
	public MemberDTO selectOne(String id) {
		
		return sessionTemplate.selectOne("mybatis.memberMapper.selectOne", id);
	}	
	// 데이터 수정
	public int modify(MemberDTO memberDTO) {
		
		return sessionTemplate.update("mybatis.memberMapper.modify", memberDTO);
	}
	// 데이터 삭제
	public int delete(String id) {
		
		return sessionTemplate.delete("mybatis.memberMapper.delete", id);
	}
	// 전체 회원 목록 검색
	public List<MemberDTO> selectList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sessionTemplate.selectList("mybatis.memberMapper.selectList", map);
	}
	
	// 총회원수 구하기
	public int getTotalMember() {
		
		return sessionTemplate.selectOne("mybatis.memberMapper.getTotalMember");
	}
	
}









