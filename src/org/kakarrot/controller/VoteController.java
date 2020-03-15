package org.kakarrot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kakarrot.annotation.RequestMapping;
import org.kakarrot.dao.HistoryDAO;
import org.kakarrot.dao.HistoryDAOImpl;
import org.kakarrot.dao.MemberDAO;
import org.kakarrot.dao.MemberDAOImpl;
import org.kakarrot.dao.TeamDAO;
import org.kakarrot.dao.TeamDAOImpl;
import org.kakarrot.domain.ApplierDTO;
import org.kakarrot.domain.MemberVO;
import org.kakarrot.domain.TeamBuildDTO;
import org.kakarrot.domain.TeamVO;

public class VoteController {

	private final MemberDAO memberDAO = new MemberDAOImpl();
	private final TeamDAO dao = new TeamDAOImpl();
	private final HistoryDAO historyDAO = new HistoryDAOImpl();

	@RequestMapping(value = "/vote/build.sr", type = "GET")
	public String getBuild(HttpServletRequest req, HttpServletResponse resp) {
		return "/vote/build";
	}

	@RequestMapping(value = "/vote/build.sr", type = "POST")
	public String postBuild(HttpServletRequest req, HttpServletResponse resp) {

		String[] name = req.getParameterValues("name");
		String[] leader = req.getParameterValues("leader");
		String[] max = req.getParameterValues("max");

		boolean result = false;

		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i] + " " + leader[i] + " " + max[i]);
			TeamBuildDTO dto = new TeamBuildDTO();
			dto.setName(name[i]);
			dto.setM_id(leader[i]);
			dto.setMax_mem(Integer.parseInt(max[i]));
			result = dao.insert(dto);
		}

		return result ? "redirect://vote/apply.sr" : "/vote/build";
	}

	@RequestMapping(value = "/vote/apply.sr", type = "GET")
	public String getApply(HttpServletRequest req, HttpServletResponse resp) {

		List<TeamVO> list = dao.selectList();

		req.setAttribute("list", list);

		return "/vote/apply";
	}

	@RequestMapping(value = "/vote/apply.sr", type = "POST")
	public String postApply(HttpServletRequest req, HttpServletResponse resp) {
		ApplierDTO dto = new ApplierDTO();

		dto.setMember_vo((MemberVO) req.getSession().getAttribute("member"));
		dto.setTeam_vo(dao.getMembers(req.getParameter("t_id")));
		dto.getTeam_vo().setState("F");
		dto.getTeam_vo().setT_id(req.getParameter("t_id"));;
		// 테이블 정보 갱신
		historyDAO.insertHistory(dto);
		dao.updateApplier(dto);
		dao.updateState(dto.getTeam_vo());
		
		dto.getMember_vo().setWaiting(false);
		
		return "redirect://vote/waiting.sr";
	}

	@RequestMapping(value = "/vote/vote.sr", type = "GET")
	public String getVote(HttpServletRequest req, HttpServletResponse resp) {
		return "/vote/vote";
	}

	@RequestMapping(value = "/vote/vote.sr", type = "POST")
	/*
	 * update (select * from tbl_his_mem where h_id = (select h_id from tbl_his
	 * where target = #{m_id} and t_id = #{t_id})) set decision = #{decision}
	 */
	public String postVote(HttpServletRequest req, HttpServletResponse resp) {
		ApplierDTO dto = new ApplierDTO();
		MemberVO memberVO = (MemberVO)req.getSession().getAttribute("member");
		dto.setMember_vo(memberVO);
		memberVO.setWaiting(false);
		TeamVO teamVO = new TeamVO();
		teamVO.setT_id(req.getParameter("t_id"));
		teamVO.setApplier(req.getParameter("target"));
		dto.setTeam_vo(teamVO);

		dto.setDecision(req.getParameter("vote"));
		historyDAO.updateDecision(dto);
		
		int end = historyDAO.checkVote(teamVO);
		System.out.println(end);
		//applier 비우기
		//taget 친구 tbl_team_mem에 추가
		if(end != 0) {
			dao.endVote(req.getParameter("t_id"));
			if(end == 1)	dao.insertTeamMem(teamVO);
			if(dao.checkMax(req.getParameter("t_id"))) {
				teamVO.setState("P");
				dao.updateState(teamVO);
			}
//			memberVO = memberDAO.selectOne(req.getParameter("id"));
//			memberVO.setWaiting(true);
		}
		return "redirect://vote/waiting.sr";
	}
	
	@RequestMapping(value = "/vote/waiting.sr", type = "GET")
	public String getWaiting(HttpServletRequest req, HttpServletResponse resp) {
		return "/vote/waiting";
	}
}
