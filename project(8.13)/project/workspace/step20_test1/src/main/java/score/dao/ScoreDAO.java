package score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import score.bean.ScoreDTO;

@Repository
public class ScoreDAO {
	@Autowired
	// application-config.xml: 에서 SqlSessionTemplate을 설정해놨다
	private SqlSessionTemplate sqlTemplate;
	// SQL 명령어들 : mybatis 사용
	
	// 성적 입력
	public int scoreInput(ScoreDTO dto) {
		
		return sqlTemplate.insert("mybatis.scoreMapper.scoreInput", dto);
	}

	// 성적 삭제
	public int scoreDel(String studNo) {
		
		return sqlTemplate.delete("mybatis.scoreMapper.scoreDel", studNo);
	}

	// 성적 수정
	public int scoreUpdate(ScoreDTO dto) {
		
		return sqlTemplate.update("mybatis.scoreMapper.scoreUpdate", dto);
	}

	// 성적 보기
	public ScoreDTO scoreView(String studNo) {
		
		return sqlTemplate.selectOne("mybatis.scoreMapper.scoreView", studNo);
	}

	// 성적 목록
	public List<ScoreDTO> scoreList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlTemplate.selectList("mybatis.scoreMapper.scoreList", map);
	}

	// 총 글수
	public int scoreCount() {
		
		return sqlTemplate.selectOne("mybatis.scoreMapper.scoreCount");
	}

}
