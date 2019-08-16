package goods_board.controller;

import java.util.List;

import goods_board.bean.Goods_boardDTO;


public interface Goods_boardService {
	public int boardWrite(Goods_boardDTO boardDTO);
	public int boardDelete(int num);
	public int updateRC(int num);
	public int updateIC(int num);
	public int boardModify(Goods_boardDTO boardDTO);
	public Goods_boardDTO boardView(int num);
	public List<Goods_boardDTO> boardList(int startNum, int endNum);
	public int getTotalA();
	public List<Goods_boardDTO> list();
}
