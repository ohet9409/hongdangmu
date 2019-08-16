package board.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;
@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	
	
	// 데이터 저장
	public int boardWrite(BoardDTO boardDTO) {
		
		return sessionTemplate.insert("mybatis.boardMapper.boardWrite", boardDTO);
	}
	
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sessionTemplate.selectList("mybatis.boardMapper.boardList", map);
	}
	// 1줄 검색
	public BoardDTO boardView(int seq) {
		
		return sessionTemplate.selectOne("mybatis.boardMapper.boardView", seq);
	}
	// 총 글수 구하기
	public int getTotalA() {
		
		return sessionTemplate.selectOne("mybatis.boardMapper.getTotalA");
	}
	// 조회수 증가
	public int updateHit(int seq) {
		
		return sessionTemplate.update("mybatis.boardMapper.updateHit", seq);
	}
	// 글삭제
	public int boardDelete(int seq) {
		
		return sessionTemplate.delete("mybatis.boardMapper.boardDelete", seq);
	}
	
	public int boardModify(BoardDTO boardDTO) {
		
		return sessionTemplate.update("mybatis.boardMapper.boardModify", boardDTO);		
	}
}





















