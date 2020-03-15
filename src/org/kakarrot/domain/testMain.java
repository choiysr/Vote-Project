package org.kakarrot.domain;

import org.kakarrot.dao.MemberDAO;
import org.kakarrot.dao.MemberDAOImpl;

public class testMain {

	public static void main(String[] args) {
//		HistoryDAO dao = new HistoryDAOImpl();
//		TeamVO vo = new TeamVO();
//		vo.setT_id("T2");
//		vo.setApplier("choiysr");
//		System.out.println(dao.checkVote(vo));
		
		MemberDAO dao = new MemberDAOImpl();
		for(int i=1; i<=100; i++) {
			MemberVO vo = new MemberVO();
			vo.setM_id("whatsora"+i);
			vo.setPw("rjqnrdl"+i);
			vo.setName("sora"+i);
			dao.insert(vo);
		}
	}
}
