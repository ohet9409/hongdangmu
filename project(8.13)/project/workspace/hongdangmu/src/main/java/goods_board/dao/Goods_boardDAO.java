package goods_board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import goods_board.bean.Goods_boardDTO;


@Repository
public class Goods_boardDAO {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	// 데이터 저장
		public int boardWrite(Goods_boardDTO boardDTO) {
			
			return sessionTemplate.insert("mybatis.goods_boardMapper.boardWrite", boardDTO);
		}
		
		public List<Goods_boardDTO> boardList(int startNum, int endNum) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("startNum", startNum);
			map.put("endNum", endNum);
			return sessionTemplate.selectList("mybatis.goods_boardMapper.boardList", map);
		}
		// 1줄 검색
		public Goods_boardDTO boardView(int num) {
			
			return sessionTemplate.selectOne("mybatis.goods_boardMapper.boardView", num);
		}
		// 전체 리스트 검색
		public List<Goods_boardDTO> list() {
					
			return sessionTemplate.selectList("mybatis.goods_boardMapper.list");
		}
		// 총 글수 구하기
		public int getTotalA() {
			
			return sessionTemplate.selectOne("mybatis.goods_boardMapper.getTotalA");
		}
		// 조회수 증가
		public int updateRC(int num) {
			
			return sessionTemplate.update("mybatis.goods_boardMapper.updateRC", num);
		}
		// 관심수 증가
		public int updateIC(int num) {
					
			return sessionTemplate.update("mybatis.goods_boardMapper.updateIC", num);
		}
		// 글삭제
		public int boardDelete(int num) {
			
			return sessionTemplate.delete("mybatis.goods_boardMapper.boardDelete", num);
		}
		
		public int boardModify(Goods_boardDTO boardDTO) {
			
			return sessionTemplate.update("mybatis.goods_boardMapper.boardModify", boardDTO);		
		}
}
