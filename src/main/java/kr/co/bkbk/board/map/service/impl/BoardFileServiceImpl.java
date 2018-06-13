package kr.co.bkbk.board.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.board.map.dao.IBoardFileDAO;
import kr.co.bkbk.board.map.dto.BoardFileDTO;
import kr.co.bkbk.board.map.service.IBoardFileService;
@Service
public class BoardFileServiceImpl implements IBoardFileService {
	
	@Autowired private IBoardFileDAO boardFileDAOImpl = null;
	
	@Override
	public void write(BoardFileDTO boardFileDTO) {
		boardFileDAOImpl.insertData(boardFileDTO);
	}

	@Override
	public List<BoardFileDTO> list(Integer docId) {
		return boardFileDAOImpl.selectList(docId);
	}

	@Override
	public void remove(Integer docId) {
		boardFileDAOImpl.deleteData(docId);
	}

	@Override
	public BoardFileDTO view(BoardFileDTO boardFileDTO) {
		return boardFileDAOImpl.selectOne(boardFileDTO);
	}

	@Override
	public Integer viewByCntDocId(Integer docId) {
		return boardFileDAOImpl.selectByCntDocId(docId);
	}

	@Override
	public void removeOnlyFile(BoardFileDTO boardFileDTO) {
		boardFileDAOImpl.deleteOnlyFile(boardFileDTO);
	}

}
