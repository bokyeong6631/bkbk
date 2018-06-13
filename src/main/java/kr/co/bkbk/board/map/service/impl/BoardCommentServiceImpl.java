package kr.co.bkbk.board.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.board.map.dao.IBoardCommentDAO;
import kr.co.bkbk.board.map.dao.IBoardDocDAO;
import kr.co.bkbk.board.map.dto.BoardCommentDTO;
import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardFileDTO;
import kr.co.bkbk.board.map.dto.BoardLikeDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.board.map.service.IBoardCommentService;
import kr.co.bkbk.board.map.service.IBoardDocService;
import kr.co.bkbk.board.map.service.IBoardFileService;
import kr.co.bkbk.board.map.service.IBoardLikeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardCommentServiceImpl implements IBoardCommentService {
	
	@Autowired private IBoardCommentDAO boardCommentDAOImpl = null;
	@Autowired private IBoardDocDAO boardDocDAOImpl = null;
	@Autowired private IBoardDocService boardDocServiceImpl = null;
	@Autowired private IBoardFileService boardFileServiceImpl = null;
	@Autowired private IBoardLikeService boardLikeServiceImpl = null;
	
	
	@Override
	public void write(BoardCommentDTO boardCommentDTO) {
		boardCommentDAOImpl.insertData(boardCommentDTO);
	}

	@Override
	public void remove(Integer commentId) {
		boardCommentDAOImpl.deleteData(commentId);
	}

	@Override
	public List<BoardCommentDTO> list(Integer docId) {
		return boardCommentDAOImpl.selectList(docId);
	}

	@Override
	public void removeByDocId(Integer docId) {
		boardCommentDAOImpl.deleteByDocId(docId);
	}

	@Override
	public List<BoardDocDTO> ViewListAndUserId(BoardSearchDTO search) {
		//1.게시물 갯수
		int total = boardCommentDAOImpl.selectCountByuserId(search);
		search.setTotal(total);
		log.debug("total=====================>"+total);
		//2.목록
		List<BoardDocDTO> list = boardDocDAOImpl.selectListByuserId(search);
		log.debug("service의 search : ===============> " + search);
		log.debug("service의 list : ===============> " + list);
		for(BoardDocDTO docDTO : list) {
			//첨부파일 갯수가 0이상 일때만 목록 가져옴
			if(docDTO.getCntFile() > 0) {
				//3.첨부파일 가져오기
				List<BoardFileDTO> fileList = boardFileServiceImpl.list(docDTO.getDocId());
				docDTO.setFileList(fileList);
			}
			//코멘트 갯수가 0이상일때만
			if(docDTO.getCntComment() > 0) {
				List<BoardCommentDTO> commentList = boardCommentDAOImpl.selectList(docDTO.getDocId());
				docDTO.setCommentList(commentList);
			}
			List<BoardLikeDTO> likeList = boardLikeServiceImpl.list(docDTO.getDocId());
			docDTO.setLikeList(likeList);
		}

		return list;
		
	}

}
