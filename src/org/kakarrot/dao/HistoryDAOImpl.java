package org.kakarrot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kakarrot.domain.ApplierDTO;
import org.kakarrot.domain.HistoryVO;
import org.kakarrot.domain.MemberVO;
import org.kakarrot.domain.PagingVO;
import org.kakarrot.domain.TeamVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class HistoryDAOImpl implements HistoryDAO {

	@Override
	public boolean insertHistory(ApplierDTO dto) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = SessionFactory.FACTORY.getSession();
			cnt = session.insert("org.kakarrot.dao.historyMapper.insertHis", dto);
			System.out.println(cnt);
			System.out.println(dto);
			for (MemberVO vo : dto.getTeam_vo().getMembers()) {
				System.out.println(vo);
				session.insert("org.kakarrot.dao.historyMapper.insertHisMem", vo.getM_id());
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt != -1;
	}

	@Override
	public int checkVote(TeamVO vo) {
		List<String> result = null;
		String h_id = "";
		SqlSession session = null;
		try {
			session = SessionFactory.FACTORY.getSession();
			h_id = session.selectOne("org.kakarrot.dao.historyMapper.findByHisId", vo);
			result = session.selectList("org.kakarrot.dao.historyMapper.checkVote", h_id);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// -1 = NonPass, 0 = Running, 1 = Pass
		int state = result.size() == 0 ? 1 : (result.get(0).equals("R") ? 0 : -1);
//			입력값 생각 필요
//		if(state != 0 )	session.update("org.kakarrot.dao.historyMapper.updateHis", "입력");

		return state;
	}

	@Override
	public boolean updateDecision(ApplierDTO dto) {
		int result = -1;
		SqlSession session = null;
		try {
			session = SessionFactory.FACTORY.getSession();
			result = session.update("org.kakarrot.dao.historyMapper.update", dto);
			System.out.println(dto.getTeam_vo().getApplier());
			System.out.println(dto.getTeam_vo().getT_id());
			System.out.println(dto.getMember_vo().getM_id());
			System.out.println(dto.getDecision());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		System.out.println(result);
		return result != -1 ;
	}
	
	public String findVote(ApplierDTO dto) {
		SqlSession session = null;
		String result = "";
		try {
			session = SessionFactory.FACTORY.getSession();
			result = session.selectOne("org.kakarrot.dao.historyMapper.findVote",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	
	// --------------------------------------------------------------------------------------------

	@Override
	public boolean insert(HistoryVO vo) {
		boolean result = false;
		SqlSession session = null;
		try {
			session = SessionFactory.FACTORY.getSession();
			session.insert("org.kakarrot.dao.historyMapper.insert", vo);
			session.commit();
			result = true;
		} catch (Exception e) {
			log.error(e);
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public HistoryVO selectOne(MemberVO vo) {
		HistoryVO result = null;
		try (SqlSession session = SessionFactory.FACTORY.getSession()) {
			result = session.selectOne("org.kakarrot.dao.historyMapper.selectOne", vo);
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@Override
	public boolean update(HistoryVO vo) {
		boolean result = false;
		SqlSession session = null;
		try {
			session = SessionFactory.FACTORY.getSession();
			session.update("org.kakarrot.dao.historyMapper.update", vo);
			session.commit();
			result = true;
		} catch (Exception e) {
			log.error(e);
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean delete(MemberVO vo) {
		boolean result = false;
		SqlSession session = null;
		try {
			session = SessionFactory.FACTORY.getSession();
			session.delete("org.kakarrot.dao.historyMapper.delete", vo);
			session.commit();
			result = true;
		} catch (Exception e) {
			log.error(e);
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<HistoryVO> selectList(PagingVO paging) {
		// TODO Auto-generated method stub
		return null;
	}

//   @Override
//   public boolean insertHistoryMember(HistoryMemberVO vo) {
//      boolean result = false;
//      
//      SqlSession session = null;
//      try {
//         session = SessionFactory.FACTORY.getSession();
//         session.insert("org.kakarrot.dao.historyMapper.insertHisMem", vo);
//         session.commit();
//         result = true;
//      } catch (Exception e) {
//    	  log.error(e);
//      } finally {
//         session.close();
//      }
//      return result;
//   }

}
