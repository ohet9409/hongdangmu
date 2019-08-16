package score.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;
import score.helper.RegexHelper;

@Controller
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(value="/score/scoreWriteForm.do")
	public ModelAndView scoreWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
    	//modelAndView.setViewName("scoreWriteForm.jsp");
    	modelAndView.addObject("display","../score/scoreWriteForm.jsp" );
    	modelAndView.setViewName("/main/index.jsp");
    	
		return modelAndView;
	}
	@RequestMapping(value="/score/scoreWrite.do")
	public ModelAndView scoreWrite(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String studNo = request.getParameter("studNo");
    	String name = request.getParameter("name");
    	String kor_num = request.getParameter("kor");
    	String eng_num = request.getParameter("eng");
    	String mat_num = request.getParameter("mat");
    	
    	int su =0;
    	int kor =0;
    	int eng =0;
    	int mat =0;
    	
    	if(!RegexHelper.getinstance().isNum(kor_num)) {
    		su = -1;
    		
    	}
    	else if(!RegexHelper.getinstance().isNum(eng_num)) {
    		su = -1;
 
    	}
    	
    	else if(!RegexHelper.getinstance().isNum(mat_num)) {
    		su = -1;
    	}
		/*
		 * int eng = 0; if(!(request.getParameter("eng").isEmpty())) { eng =
		 * Integer.parseInt(request.getParameter("eng")); } int mat = 0;
		 * if(!(request.getParameter("mat").isEmpty())) { mat =
		 * Integer.parseInt(request.getParameter("mat")); }
		 */
    	else {
    		kor = Integer.parseInt(kor_num);
    		eng = Integer.parseInt(eng_num);
    		mat = Integer.parseInt(mat_num);
    	int tot = kor + eng + mat;
    	double avg = tot/3.0;
    	
    	ScoreDTO dto = new ScoreDTO();
    	dto.setAvg(avg);
    	dto.setEng(eng);
    	dto.setKor(kor);
    	dto.setMat(mat);
    	dto.setName(name);
    	dto.setStudNo(studNo);
    	dto.setTot(tot);
    	
   
    	su = scoreService.scoreInput(dto);
    	}
    	
    	//request.setAttribute("su", su);
    	System.out.println("su = " + su);
      	ModelAndView modelAndView = new ModelAndView();
    	//modelAndView.setViewName("scoreWrite.jsp");
    	modelAndView.addObject("su", su);
    	modelAndView.addObject("display","../score/scoreWrite.jsp" );
    	modelAndView.setViewName("/main/index.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreView.do")
	public ModelAndView scoreView(HttpServletRequest request) {
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		
		ScoreDTO dto = scoreService.scoreView(studNo);
	
		
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("scoreView.jsp");
    	modelAndView.addObject("dto", dto);
    	modelAndView.addObject("pg", pg);
    	modelAndView.setViewName("/main/index.jsp");
    	modelAndView.addObject("display", "../score/scoreView.jsp");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/score/scoreUpdateForm.do")
	public ModelAndView scoreUpdateForm(HttpServletRequest request) {
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		
		ScoreDTO dto = scoreService.scoreView(studNo);
		
		
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("scoreUpdateForm.jsp");
    	modelAndView.addObject("dto", dto);
    	modelAndView.addObject("pg", pg);
    	modelAndView.addObject("display","../score/scoreUpdateForm.jsp" );
    	modelAndView.setViewName("/main/index.jsp");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/score/scoreUpdate.do")
	public ModelAndView scoreUpdate(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("업");
		int pg = Integer.parseInt(request.getParameter("pg"));
		int su=0;
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		String kor_num = request.getParameter("kor");
		String eng_num= request.getParameter("eng");
		String mat_num= request.getParameter("mat");
		
		if(!RegexHelper.getinstance().isNum(kor_num) && !RegexHelper.getinstance().isInt(kor_num)) {
			su=-1;
		} else if(!RegexHelper.getinstance().isNum(eng_num) ) {
			su=-1;
		} else if(!RegexHelper.getinstance().isNum(mat_num) ) {
			su=-1;
		}else {
		int kor = Integer.parseInt(kor_num);
		int eng = Integer.parseInt(eng_num);
		int mat = Integer.parseInt(mat_num);
		int tot = kor + eng + mat;
		double avg = tot/3.0;
		ScoreDTO dto = new ScoreDTO();
		dto.setAvg(avg);
		dto.setEng(eng);
		dto.setKor(kor);
		dto.setMat(mat);
		dto.setName(name);
		dto.setStudNo(studNo);
		dto.setTot(tot);
		
		
		
		su = scoreService.scoreUpdate(dto);
		}
		ModelAndView modelAndView = new ModelAndView();
    	//modelAndView.setViewName("scoreUpdate.jsp");
    	modelAndView.addObject("su", su);
    	modelAndView.addObject("pg", pg);
    	modelAndView.addObject("studNo", studNo);
    	modelAndView.addObject("display","../score/scoreUpdate.jsp" );
    	modelAndView.setViewName("/main/index.jsp");
    	
		return modelAndView;
		
	}
	@RequestMapping(value="/score/scoreList.do")
	public ModelAndView scoreList(HttpServletRequest request) {
		int pg =1;
		String pg_str = request.getParameter("pg");
		
		if(RegexHelper.getinstance().isNum(pg_str)) {
			pg = Integer.parseInt(pg_str);
		}
		/*
    	if(request.getParameter("pg") != null){
    		pg = Integer.parseInt(request.getParameter("pg"));
    	}
    	*/
    	System.out.println("pg="+pg);
    	// 목록 얻기 (5줄)
    	int endNum = pg*5;
    	int startNum = endNum-4;
    	System.out.println("endNum="+endNum);
    	System.out.println("startNum="+startNum);
    	
    	List<ScoreDTO> list = scoreService.scoreList(startNum, endNum);
    	// 페이징 데이터 얻기
    	int totalA = scoreService.scoreCount();
    	int totalP = (totalA+4)/5;
    	
    	int startPage = (pg-1)/3*3+1;
    	int endPage = startPage+2;
    	if(endPage > totalP) {
    		endPage = totalP;
    	}
    	
    	
    	
    	
    	ModelAndView modelAndView = new ModelAndView();
    	//modelAndView.setViewName("scoreList.jsp");
    	modelAndView.addObject("totalP", totalP);
    	modelAndView.addObject("startPage", startPage);
    	modelAndView.addObject("endPage", endPage);
    	modelAndView.addObject("pg", pg);
    	modelAndView.addObject("list", list);
    	modelAndView.addObject("display","../score/scoreList.jsp" );
    	modelAndView.setViewName("/main/index.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreDelete.do")
	public ModelAndView scoreDelete(HttpServletRequest request) {
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		
		int su = scoreService.scoreDel(studNo);
		
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("scoreDelete.jsp");
		modelAndView.addObject("su", su);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("display","../score/scoreDelete.jsp" );
    	modelAndView.setViewName("/main/index.jsp");
	
		return modelAndView;
	}
}
