package kr.co.bkbk.board.map.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.board.map.dao.IBoardCommentDAO;
import kr.co.bkbk.board.map.dto.BoardCommentDTO;
import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.common.dao.BaseDaoSupport;

@Repository
public class BoardCommentDAOImpl extends BaseDaoSupport implements IBoardCommentDAO {

	@Override
	public void insertData(BoardCommentDTO boardCommentDTO) {
		this.getSqlSession().insert("BoardComment.insertData", boardCommentDTO);
	}

	@Override
	public void deleteData(Integer commentId) {
		this.getSqlSession().delete("BoardComment.deleteData", commentId);
	}

	@Override
	public List<BoardCommentDTO> selectList(Integer docId) {
		
		return this.getSqlSession().selectList("BoardComment.selectList", docId);
	}

	@Override
	public void deleteByDocId(Integer docId) {
		this.getSqlSession().delete("BoardComment.deleteByDocId", docId);
	}

	@Override
	public List<BoardDocDTO> selectListAndUserId(BoardSearchDTO search) {
		return this.getSqlSession().selectList("BoardComment.selectListAndUserId", search);
	}

	@Override
	public int selectCountByuserId(BoardSearchDTO search) {
		return this.getSqlSession().selectOne("BoardComment.selectCountByuserId", search);
	}

}
