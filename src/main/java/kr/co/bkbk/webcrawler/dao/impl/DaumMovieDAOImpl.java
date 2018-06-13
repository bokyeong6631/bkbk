package kr.co.bkbk.webcrawler.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.common.dao.BaseDaoSupport;
import kr.co.bkbk.webcrawler.dao.IDaumMovieDAO;
import kr.co.bkbk.webcrawler.dto.DaumMovieDTO;

@Repository
public class DaumMovieDAOImpl extends BaseDaoSupport implements IDaumMovieDAO {

	@Override
	public void insertData(DaumMovieDTO dmDTO) {
		this.getSqlSession().insert("DaumMovie.insertData", dmDTO);
	}

	@Override
	public List<DaumMovieDTO> selectList(BoardSearchDTO search) {
		return this.getSqlSession().selectList("DaumMovie.selectList", search);
	}

	@Override
	public int selectCount(BoardSearchDTO search) {
		return this.getSqlSession().selectOne("DaumMovie.selectCount", search);
	}

}
