package board.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping(value="/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		modelAndView.setViewName("../board/boardDelete.jsp");
		int su = boardService.boardDelete(seq);
		modelAndView.addObject("su", su);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("seq", seq);
		return modelAndView;
		
	}
	
	@RequestMapping(value="/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		System.out.println("pg = " + pg);
		// 5개씩 목록 보여주기
		// (1, 5)
		// (6, 10)
		// (11, 15)
		// (16, 20)	
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		
		List<BoardDTO> list = boardService.boardList(startNum, endNum);
		
		/* 페이징 처리 (목록은 5줄 씩)
		      총페이지 수 = (총글수 + 4)/5
		    총글수 : 12
		    총페이지수:3		[1][2][3]
		  
		    총글수 : 23
		    총페이지수:5		[1][2][3][4][5]
		*/
		int totalA = boardService.getTotalA();	// 총글수
		int totalP = (totalA + 4) / 5;	// 총페이지수
		System.out.println("totalP = " + totalP);
		/* 페이지는3개씩 끊어서 보여줌
			총페이지수 : 8
				 [1][2][3][다음]
			[이전][4][5][6][다음]
			[이전][7][8]
		*/
		int startPage = (pg-1)/3*3 + 1;	
		int endPage = startPage + 2;
		if(totalP < endPage) endPage = totalP;
		System.out.println("startPage = " + startPage);
		modelAndView.setViewName("../board/boardList.jsp");
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		return modelAndView;
		
	}
	@RequestMapping(value="/board/boardWriteForm.do")
	public ModelAndView boardWriteForm(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		// DB
		modelAndView.setViewName("../board/boardWriteForm.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		// 데이터 처리
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// 한글처리
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");
		System.out.println("id = " + id);
		// DB 처리
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		
		int su = boardService.boardWrite(boardDTO);
		System.out.println("su = " + su);
		// DB
		modelAndView.setViewName("../board/boardWrite.jsp");
		modelAndView.addObject("su", su);
		return modelAndView;
		
	}
	
	@RequestMapping(value="/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		System.out.println("글 상세보기");
		ModelAndView modelAndView = new ModelAndView();
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");
		System.out.println("pg= " + pg);
		System.out.println("seq= " + seq);
		// 조회수 증가
		boardService.updateHit(seq);
		BoardDTO boardDTO = boardService.boardView(seq);
		// DB
		modelAndView.setViewName("../board/boardView.jsp");
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("id", id);
		return modelAndView;
		
	}

	@RequestMapping(value="/board/boardModifyForm.do")
	public ModelAndView boardModiftyForm(HttpServletRequest request) {
		System.out.println("글 수정화면");
		ModelAndView modelAndView = new ModelAndView();
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		System.out.println("pg= " + pg);
		System.out.println("seq= " + seq);
		BoardDTO boardDTO = boardService.boardView(seq);
		// DB
		modelAndView.setViewName("../board/boardModifyForm.jsp");
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		return modelAndView;
		
	}
	
	@RequestMapping(value="/board/boardModify.do")
	public ModelAndView boardModifty(HttpServletRequest request) {
		System.out.println("글 수정");
		ModelAndView modelAndView = new ModelAndView();
		// 데이터
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// 한글 처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		System.out.println("pg= " + pg);
		System.out.println("seq= " + seq);
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// DB
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(seq);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
	
		int su = boardService.boardModify(boardDTO);
		System.out.println("su= " + su);
		// DB
		modelAndView.setViewName("../board/boardModify.jsp");
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		return modelAndView;
		
	}
}
