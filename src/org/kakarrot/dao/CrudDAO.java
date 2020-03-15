package org.kakarrot.dao;

import java.util.List;

import org.kakarrot.domain.PagingVO;

public interface CrudDAO<K, V> {
	boolean insert(V vo);
	V selectOne(K id);
	List<V> selectList(PagingVO paging);
	boolean update(V vo);
	boolean delete(K id);
}
