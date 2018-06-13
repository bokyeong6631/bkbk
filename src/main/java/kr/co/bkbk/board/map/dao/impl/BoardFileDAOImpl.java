package kr.co.bkbk.board.map.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.board.map.dao.IBoardFileDAO;
import kr.co.bkbk.board.map.dto.BoardFileDTO;
import kr.co.bkbk.common.dao.BaseDaoSupport;

@Repository
public class BoardFileDAOImpl extends BaseDaoSupport implements IBoardFileDAO {

	@Override
	public void insertData(BoardFileDTO boardFileDTO) {
		this.getSqlSession().insert("BoardFile.insertData", boardFileDTO);
	}

	@Override
	public List<BoardFileDTO> selectList(Integer docId) {
		return this.getSqlSession().selectList("BoardFile.selectList", docId);
	}

	@Override
	public void deleteData(Integer docId) {
		this.getSqlSession().delete("BoardFile.deleteData", docId);
	}

	@Override
	public BoardFileDTO selectOne(BoardFileDTO boardFileDTO) {
		return this.getSqlSession().selectOne("BoardFile.selectOne", boardFileDTO);
	}

	@Override
	public Integer selectByCntDocId(Integer docId) {
		return this.getSqlSession().selectOne("BoardFile.selectByCntDocId", docId);
	}

	@Override
	public void deleteOnlyFile(BoardFileDTO boardFileDTO) {
		this.getSqlSession().delete("BoardFile.deleteOnlyFile", boardFileDTO);
	}

}
