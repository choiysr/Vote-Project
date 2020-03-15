package org.kakarrot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kakarrot.domain.ApplierDTO;
import org.kakarrot.domain.PagingVO;
import org.kakarrot.domain.TeamBuildDTO;
import org.kakarrot.domain.TeamVO;

public class TeamDAOImpl implements TeamDAO {

	@Override
	public boolean insert(TeamBuildDTO dto) {
		SqlSession session = null;
		int result = -1;
		int result2 = -1;
		try {
			session = SessionFactory.FACTORY.getSession();
			result = session.insert("org.kakarrot.dao.teamMapper.insertTeam", dto);
			result2 = session.insert("org.kakarrot.dao.teamMapper.insertTeamMember", dto);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result != -1 || result2 != -1;
	}

	@Override
	public List<TeamVO> selectList() {
		List<TeamVO> result = null;
		try (SqlSession session = SessionFactory.FACTORY.getSession()) {
			result = session.selectList("org.kakarrot.dao.teamMapper.selectTeams");
			for (TeamVO vo : result) {
				vo.setMembers(session.selectList("org.kakarrot.dao.teamMapper.selectTeamMembers", vo.getT_id()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delete(String k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TeamBuildDTO selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamVO selectTeamVO(String m_id) {
		TeamVO vo = null;
		try (SqlSession session = SessionFactory.FACTORY.getSession()) {
			vo = session.selectOne("org.kakarrot.dao.teamMapper.selectOne", m_id);
			vo.setMembers(session.selectList("org.kakarrot.dao.teamMapper.selectTeamMembers", vo.getT_id()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<TeamBuildDTO> selectList(PagingVO paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(TeamBuildDTO vo) {
		return false;
	}
	
	public boolean updateApplier(ApplierDTO dto) {
		try (SqlSession session = SessionFactory.FACTORY.getSession()) {
			session.update("org.kakarrot.dao.teamMapper.updateApp", dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public TeamVO getMembers(String t_id) {
		TeamVO vo = null;
		try (SqlSession session = SessionFactory.FACTORY.getSession()) {
			vo = session.selectOne("org.kakarrot.dao.teamMapper.select", t_id);
			vo.setMembers(session.selectList("org.kakarrot.dao.teamMapper.selectTeamMembers", t_id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public boolean endVote(String t_id) {
		int result = 0;
		try (SqlSession session = SessionFactory.FACTORY.getSession()) {
			result = session.update("org.kakarrot.dao.teamMapper.endVote", t_id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean insertTeamMem(TeamVO vo) {
		int result = 0;
		try (SqlSession session = SessionFactory.FACTORY.getSession()) {
			result = session.insert("org.kakarrot.dao.teamMapper.insertTeamMem", vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean updateState(TeamVO vo) {
		int result = 0;
		try (SqlSession session = SessionFactory.FACTORY.getSession()) {
			result = session.update("org.kakarrot.dao.teamMapper.state", vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean checkMax(String t_id) {
		int result = -1;
		try (SqlSession session = SessionFactory.FACTORY.getSession()) {
			result = session.selectOne("org.kakarrot.dao.teamMapper.count", t_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result == 0 ? false : true;
	}

}
