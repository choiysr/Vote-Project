package org.kakarrot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kakarrot.domain.MemberVO;
import org.kakarrot.domain.PagingVO;
import org.kakarrot.domain.TeamMemberVO;

public class MemberDAOImpl implements MemberDAO {

	private final String mapperPath = "org.kakarrot.dao.memberMapper.";

	@Override
	public boolean insert(MemberVO vo) {
		SqlSession session = null;
		int result = 0;
		try {
			session = SessionFactory.FACTORY.getSession();
			result = session.insert("org.kakarrot.dao.memberMapper.insert", vo);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result == -1 ? false : true;
	}

	@Override
	public MemberVO selectOne(String id) {
		
		MemberVO result = null;
		String auth = null;
		try(SqlSession session = SessionFactory.FACTORY.getSession()) {
			result = session.selectOne(mapperPath + "selectOne", id);
			auth = session.selectOne(mapperPath + "selectAuth",id);
			result.setAuth(auth);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public List<MemberVO> selectList(PagingVO paging) {
		return null;
	}

	@Override
	public boolean update(MemberVO vo) {
		SqlSession session = null;
		int result =0;
		try {
			session = SessionFactory.FACTORY.getSession();
			result = session.update(mapperPath + "update", vo);
			session.commit();
		} catch(Exception e) {
			session.rollback();
			e.printStackTrace();	
		} finally {
			session.close();
		}
		return result == -1 ? false : true;
	}

	@Override
	public boolean delete(String id) {
		SqlSession session = null;
		int result = 0;		
		try {
			session = SessionFactory.FACTORY.getSession();
			result = session.delete(mapperPath + "delete", id);
			session.commit();
		} catch(Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return result == -1 ? false : true;
	}
	
	public boolean waiting(MemberVO vo) {
		int result=0;
		try(SqlSession session = SessionFactory.FACTORY.getSession()) {
//			if(vo.getAuth() == null)	result = session.selectOne(mapperPath + "selectOne", id);
//			else	result = session.selectOne(mapperPath + "selectAuth",id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return result == -1 ? true : false;
	}

}
