package org.kakarrot.dao;

import org.kakarrot.domain.ApplierDTO;
import org.kakarrot.domain.HistoryVO;
import org.kakarrot.domain.MemberVO;
import org.kakarrot.domain.TeamVO;

public interface HistoryDAO extends CrudDAO<MemberVO, HistoryVO>{
	public boolean insertHistory(ApplierDTO dto);
   
	public int checkVote(TeamVO vo);
	
	public boolean updateDecision(ApplierDTO dto);
	
	public String findVote(ApplierDTO dto);
}
