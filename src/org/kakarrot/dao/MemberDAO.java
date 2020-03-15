package org.kakarrot.dao;

import org.kakarrot.domain.MemberVO;

public interface MemberDAO extends CrudDAO<String, MemberVO> {
	public boolean waiting(MemberVO vo);
}
