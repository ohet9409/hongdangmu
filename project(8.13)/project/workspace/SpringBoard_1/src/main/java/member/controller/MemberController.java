package member.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	@RequestMapping(value = "/member/checkId.do")
	public ModelAndView checkId(HttpServletRequest request) {
		// 데이터 처리
		String id = request.getParameter("id");
		// DB 처리
		
		String id1 = service.isExistId(id);
		System.out.println("id1 = " + id1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/checkId.jsp");
		modelAndView.addObject("id", id);
		modelAndView.addObject("id1", id1);
		return modelAndView;
	}

	@RequestMapping(value = "/member/delete.do")
	public ModelAndView delete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		
		int su = service.delete(id);
		// 세션 삭제
		session.removeAttribute("memId");
		session.removeAttribute("memName");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/delete.jsp");
		modelAndView.addObject("su", su);
		return modelAndView;
	}

	@RequestMapping(value = "/member/deleteForm.do")
	public ModelAndView deleteForm(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/deleteForm.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/member/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		// 데이터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		
		String name = service.login(id, pwd);

		if (name != null) {
			/*
			 * 페이지 이동 get 방식으로 이동하기 때문에 이름과 id가 주소창에 오픈된다. 보안에 취약 그래서 쿠키나 세션으로 보내야 함(다음 장에서
			 * 할 것임).
			 */
			// response.sendRedirect("loginOk.jsp?name="
			// + URLEncoder.encode(name, "utf-8") + "&id=" + id);

			/* 데이터 공유 1 : 쿠키 이용 */
			/*
			 * Cookie cookie1 = new Cookie("memName", URLEncoder.encode(name, "UTF-8"));
			 * cookie1.setMaxAge(120); // 120초 설정 Cookie cookie2 = new Cookie("memId", id);
			 * cookie2.setMaxAge(120); // 120초 설정
			 * 
			 * response.addCookie(cookie1); response.addCookie(cookie2);
			 */
			/* 데이터 공유 2 : 세션 이용 */
			HttpSession session = request.getSession();
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);

			modelAndView.setViewName("../member/loginOk.do");
			// response.sendRedirect("loginOk.jsp");

		} else {

			// response.sendRedirect("loginFail.jsp");
			modelAndView.setViewName("../member/loginFail.do");

		}

		return modelAndView;
	}

	@RequestMapping(value = "/member/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/loginForm.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/member/loginOk.do")
	public ModelAndView loginOk(HttpServletRequest request) {
		// 데이터 처리
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String name = request.getParameter("name");
		// String id = request.getParameter("id");

		String name = "";
		String id = "";
		/* 데이터 공유 1 : 쿠키 이용 */
		/*
		 * Cookie[] cookies = request.getCookies(); if(cookies != null) { for(int i=0;
		 * i<cookies.length; i++) { if(cookies[i].getName().equals("memName")) { name =
		 * URLDecoder.decode(cookies[i].getValue(), "UTF-8"); } else
		 * if(cookies[i].getName().equals("memId")) { id = cookies[i].getValue(); } } }
		 */
		/* 데이터 공유 2 : 세션 이용 */
		HttpSession session = request.getSession();
		name = (String) session.getAttribute("memName");
		id = (String) session.getAttribute("memId");
		System.out.println("name = " + name);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/loginOk.jsp");
		modelAndView.addObject("name", name);
		modelAndView.addObject("id", id);
		return modelAndView;
	}

	@RequestMapping(value = "/member/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		// 쿠키 정보 삭제 : 브라우저에게 쿠키정보를 더이상 보내지마라 설정
		/*
		 * Cookie[] cookies = request.getCookies(); if(cookies != null) { for(int i=0;
		 * i<cookies.length; i++) { if(cookies[i].getName().equals("memName")) {
		 * cookies[i].setMaxAge(0); // 쿠키 삭제 요청 response.addCookie(cookies[i]); } else
		 * if(cookies[i].getName().equals("memId")) { cookies[i].setMaxAge(0); // 쿠키 삭제
		 * 요청 response.addCookie(cookies[i]); } } }
		 */
		// 세션 삭제
		HttpSession session = request.getSession();
		session.removeAttribute("memName");
		session.removeAttribute("memId");

		session.invalidate(); // 무효화, 전부 삭제
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/logout.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/loginFail.do")
	public ModelAndView loginFail(HttpServletRequest request) {
		

		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/loginFail.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/memberList.do")
	public ModelAndView memberList(HttpServletRequest request) {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB 처리
		// 목록 5개씩 끊어서 가져오기
		// pg=1	rn>=1 and rn<=5
		// pg=2	rn>=6 and rn<=10
		// pg=3	rn>=11 and rn<=15
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		
		List<MemberDTO> list = service.selectList(startNum, endNum);
		
		/* 페이징 처리
			총회원수 : 12
			총페이지수 : 3
			
			총회원수 : 23
			총페이지수 : 5
			
			총페이지수 = (총회원수 + 4) / 5;
		*/
		int totalMember = service.getTotalMember();	// 총 회원수
		int totalP = (totalMember + 4) / 5;
		
		/* 3블럭 나눠서 보여주기
			총페이지수 : 8
				 [1][2][3][다음]
			[이전][4][5][6][다음]
			[이전][7][8]
		*/
		int startPage = (pg-1)/3*3 + 1;
		int endPage = startPage + 2;
		if(totalP < endPage) endPage = totalP;
		System.out.println("totalP = " + totalP);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/memberList.jsp");
		modelAndView.addObject("list", list);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("pg", pg);
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/modify.do")
	public ModelAndView modify(HttpServletRequest request) {
		// 데이터 처리
		// post 방식에서의 한글 처리
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		
		// DB 처리
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setAddr(addr);
		System.out.println("addr = " + addr);
		
		int su = service.modify(memberDTO);
		System.out.println("su = " + su);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/modify.jsp");
		modelAndView.addObject("su", su);
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request) {
		// 데이터 처리
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		System.out.println("id = " + id);
		MemberDTO memberDTO = service.selectOne(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/modifyForm.jsp");
		modelAndView.addObject("memberDTO", memberDTO);
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/write.do")
	public ModelAndView write(HttpServletRequest request) {
		// 데이터 처리
		// post 방식에서의 한글 처리
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		
		// DB 처리
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setAddr(addr);
		System.out.println("name = " + memberDTO.getName());
		
		int su = service.write(memberDTO);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/write.jsp");
		modelAndView.addObject("su", su);
		System.out.println("su = " + su);
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/writeForm.do")
	public ModelAndView writeForm(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../member/writeForm.jsp");
	
		return modelAndView;
	}
}
