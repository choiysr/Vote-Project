package org.kakarrot.dao;

import java.util.List;

import org.kakarrot.domain.ApplierDTO;
import org.kakarrot.domain.TeamBuildDTO;
import org.kakarrot.domain.TeamVO;

public interface TeamDAO extends CrudDAO<String, TeamBuildDTO> {

	public List<TeamVO> selectList();

	public TeamVO getMembers(String t_id);
	public TeamVO selectTeamVO(String m_id);
	public boolean updateApplier(ApplierDTO dto);
	public boolean insertTeamMem(TeamVO vo) ;
	public boolean endVote(String t_id);
	public boolean updateState(TeamVO vo);
	public boolean checkMax(String t_id);
}
