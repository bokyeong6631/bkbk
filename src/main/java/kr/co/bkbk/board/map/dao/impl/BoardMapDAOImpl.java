package kr.co.bkbk.board.map.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.board.map.dao.IBoardMapDAO;
import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.common.dao.BaseDaoSupport;

@Repository
public class BoardMapDAOImpl extends BaseDaoSupport implements IBoardMapDAO {

	@Override
	public List<BoardMapDTO> seletList() {
		return this.getSqlSession().selectList("BoardMap.selectList");
	}

	@Override
	public BoardMapDTO selectOne(Integer mapId) {
		return this.getSqlSession().selectOne("BoardMap.selectOne", mapId);
	}



	

}
