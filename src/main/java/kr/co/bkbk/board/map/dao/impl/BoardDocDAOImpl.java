package kr.co.bkbk.board.map.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.board.map.dao.IBoardDocDAO;
import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.common.dao.BaseDaoSupport;

@Repository
public class BoardDocDAOImpl extends BaseDaoSupport implements IBoardDocDAO {

	@Override
	public void insertData(BoardDocDTO boardDocDTO) {
		this.getSqlSession().insert("BoardDoc.insertData",boardDocDTO);
	}

	@Override
	public List<BoardDocDTO> selectList(BoardSearchDTO boardSearchDTO) {
		return this.getSqlSession().selectList("BoardDoc.selectList",boardSearchDTO);
	}


	@Override
	public void updateDoc(BoardDocDTO boardDocDTO) {
		this.getSqlSession().update("BoardDoc.updateDoc", boardDocDTO);
	}

	@Override
	public void deleteData(Integer docId) {
		this.getSqlSession().delete("BoardDoc.deleteData", docId);
	}

	@Override
	public int selectCount(BoardSearchDTO boardSearchDTO) {
		return this.getSqlSession().selectOne("BoardDoc.selectCount", boardSearchDTO);
	}

	@Override
	public BoardDocDTO selectOne(BoardDocDTO boardDocDTO) {
		return this.getSqlSession().selectOne("BoardDoc.selectOne", boardDocDTO);
	}

	@Override
	public void updateCntRead(Integer docId) {
		this.getSqlSession().update("BoardDoc.updateCntRead", docId);
	}

	@Override
	public List<BoardDocDTO> selectListAndUserId(BoardSearchDTO search) {
		return this.getSqlSession().selectList("BoardDoc.selectListAndUserId",search);
	}

	@Override
	public int selectCountByuserId(BoardSearchDTO boardSearchDTO) {
		return this.getSqlSession().selectOne("BoardDoc.selectCountByuserId", boardSearchDTO);
	}

	@Override
	public List<BoardDocDTO> selectListByuserId(BoardSearchDTO boardSearchDTO) {
		return this.getSqlSession().selectList("BoardDoc.selectListByuserId", boardSearchDTO);
	}

	@Override
	public List<BoardDocDTO> selectListAll() {
		return this.getSqlSession().selectList("BoardDoc.selectListAll");
	}

	@Override
	public List<BoardDocDTO> selectListByLikeId(Integer viewerId) {
		return this.getSqlSession().selectList("BoardDoc.selectListByLikeId",viewerId);
	}

	@Override
	public BoardDocDTO selectImageBydocId(Integer docId) {
		return this.getSqlSession().selectOne("BoardDoc.selectImageBydocId", docId);
	}


}
