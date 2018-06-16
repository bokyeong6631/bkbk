package kr.co.bkbk.board.map.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.board.map.dao.IBoardLikeDAO;
import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardLikeDTO;
import kr.co.bkbk.common.dao.BaseDaoSupport;

@Repository
public class BoardLikeDAOImpl extends BaseDaoSupport implements IBoardLikeDAO {

	@Override
	public void insertData(BoardLikeDTO boardLikeDTO) {
		this.getSqlSession().insert("BoardLike.insertData",boardLikeDTO);
	}

	@Override
	public void deleteData(Integer likeId) {
		this.getSqlSession().delete("BoardLike.deleteData", likeId);
	}

	@Override
	public List<BoardLikeDTO> selectList(Integer docId) {
		return this.getSqlSession().selectList("BoardLike.selectList", docId);
	}

	@Override
	public void deleteDoc(Integer docId) {
		this.getSqlSession().delete("BoardLike.deleteDoc", docId);
	}



}
