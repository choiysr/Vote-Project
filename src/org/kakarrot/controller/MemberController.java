package org.kakarrot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kakarrot.annotation.RequestMapping;
import org.kakarrot.dao.HistoryDAO;
import org.kakarrot.dao.HistoryDAOImpl;
import org.kakarrot.dao.MemberDAO;
import org.kakarrot.dao.MemberDAOImpl;
import org.kakarrot.dao.TeamDAO;
import org.kakarrot.dao.TeamDAOImpl;
import org.kakarrot.domain.ApplierDTO;
import org.kakarrot.domain.MemberVO;
import org.kakarrot.domain.TeamVO;

public class MemberController {
	
	private MemberDAO memberDao = new MemberDAOImpl();
	private final TeamDAO dao2 = new TeamDAOImpl();
	private final HistoryDAO hisDAO = new HistoryDAOImpl();
	
	@RequestMapping(value = "/member/login.sr", type = "GET")
	public String getLogin(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "");
		return "/member/login";
	}

	@RequestMapping(value = "/member/login.sr", type = "POST")
	public String postLogin(HttpServletRequest request, HttpServletResponse response) {
		String result = "redirect://member/myPage.sr";
		MemberVO vo = null;
		try {
			vo = memberDao.selectOne(request.getParameter("id"));
			vo.setWaiting(memberDao.waiting(vo));
 			if (!vo.getPw().equals(request.getParameter("pw"))) {
				result = "/member/login";
				request.setAttribute("msg", "pwerr");
			}
			else {	
				request.getSession().setAttribute("member", vo);
			}
			
		} catch (Exception e) {
			result = "/member/login";
			request.setAttribute("msg", "iderr");
		}
		return result;
	}

	@RequestMapping(value = "/member/logout.sr", type = "GET")
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect://member/login.sr";
	}
	
	@RequestMapping(value = "/member/register.sr", type = "POST")
	public String postRegister(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo = new MemberVO();
		vo.setM_id(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setName(request.getParameter("name"));
		
		return memberDao.insert(vo) ? "redirect://member/myPage.sr" : "/member/register" ;
	}
	
	@RequestMapping(value = "/member/register.sr", type = "GET")
	public String getRegister(HttpServletRequest request, HttpServletResponse response) {
		return "/member/register";
	}
	
	@RequestMapping(value = "/member/myPage.sr", type = "GET")
	public String getMyPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		TeamVO tvo = dao2.selectTeamVO(mvo.getM_id());
		request.setAttribute("team", tvo );
		//t_id와 aplier로 h_id찾고 m_id로 투표결과를 찾음
		ApplierDTO dto = new ApplierDTO();
		dto.setMember_vo(mvo);
		dto.setTeam_vo(tvo);
		String vote = hisDAO.findVote(dto);
		
		request.setAttribute("vote", vote);
		return "/member/myPage";
	}

	@RequestMapping(value = "/member/idCheck.sr", type = "GET")
	public String getIdCheck(HttpServletRequest request, HttpServletResponse response) {

		MemberVO vo = memberDao.selectOne(request.getParameter("id"));
		if(vo != null)	{ request.setAttribute("msg", "중복입니다"); System.out.println(request.getAttribute("msg")); }
		else	{ request.setAttribute("msg", "사용가능합니다"); System.out.println(request.getAttribute("msg")); }

		return "redirect://member/register.sr";
	}
//	
}
