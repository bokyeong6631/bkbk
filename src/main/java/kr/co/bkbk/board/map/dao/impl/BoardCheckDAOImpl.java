package kr.co.bkbk.board.map.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.board.map.dao.IBoardCheckDAO;
import kr.co.bkbk.board.map.dto.BoardCheckDTO;
import kr.co.bkbk.common.dao.BaseDaoSupport;

@Repository
public class BoardCheckDAOImpl extends BaseDaoSupport implements IBoardCheckDAO {

	@Override
	public void insertData(BoardCheckDTO boardCheckDTO) {
		this.getSqlSession().insert("BoardCheck.insertData", boardCheckDTO);
	}

	@Override
	public void deleteData(BoardCheckDTO boardCheckDTO) {
		this.getSqlSession().delete("BoardCheck.deleteData", boardCheckDTO);

	}

	@Override
	public List<BoardCheckDTO> selectList(Integer userId) {
		return this.getSqlSession().selectList("BoardCheck.selectList", userId);
	}

}
