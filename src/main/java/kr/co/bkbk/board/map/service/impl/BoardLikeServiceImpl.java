package kr.co.bkbk.board.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.board.map.dao.IBoardLikeDAO;
import kr.co.bkbk.board.map.dto.BoardLikeDTO;
import kr.co.bkbk.board.map.service.IBoardLikeService;

@Service
public class BoardLikeServiceImpl implements IBoardLikeService {
	
	@Autowired private IBoardLikeDAO boardLikeDAOImpl = null;

	//좋아요,싫어요
	@Override
	public void write(BoardLikeDTO boardLikeDTO) {
		//무관심일때 삭제
		if(boardLikeDTO.getLikeYn()=="") {
			this.remove(boardLikeDTO.getLikeId());
		}
		
		boardLikeDAOImpl.insertData(boardLikeDTO);
	}
	
	//무관심
	@Override
	public void remove(Integer likeId) {
		boardLikeDAOImpl.deleteData(likeId);
	}

	@Override
	public List<BoardLikeDTO> list(Integer docId) {
		
		return boardLikeDAOImpl.selectList(docId);
	}

	@Override
	public void removeDoc(Integer docId) {
		boardLikeDAOImpl.deleteDoc(docId);
	}


}
