package kr.co.bkbk.board.map.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
import kr.co.bkbk.common.file.FileService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class BoardDocServiceImpl implements IBoardDocService {
	
	@Autowired private IBoardLikeService boardLikeServiceImpl = null;
	@Autowired private IBoardCommentService boardCommentServiceImpl = null;
	@Autowired private IBoardFileService boardFileServiceImpl = null;
	@Autowired private FileService fileService = null;
	@Autowired private IBoardDocDAO boardDocDAO = null;
	
	@Override
	@Transactional
	public void write(BoardDocDTO boardDocDTO,HttpSession session) {
		//1.게시물 insert
		BoardFileDTO fileDTO = null;
		if(boardDocDTO.getFiles() == null) {
			boardDocDAO.insertData(boardDocDTO);
		} else {
			boardDocDAO.insertData(boardDocDTO);
			for(MultipartFile file : boardDocDTO.getFiles()) {
				//첨부파일 물리적인 디스크에 저장
				fileDTO = fileService.uploadSingleFile(file, session);
				//첨부파일 디비에 insert
				fileDTO.setDocId(boardDocDTO.getDocId());
				boardFileServiceImpl.write(fileDTO);
			}
		}
	}
	//내가 쓴 게시물
	@Override
	public List<BoardDocDTO> viewListByuserId(BoardSearchDTO search) {
		//1.게시물 갯수
		int total = boardDocDAO.selectCountByuserId(search);
		search.setTotal(total);
		//2.목록
		List<BoardDocDTO> list = boardDocDAO.selectListByuserId(search);
		for(BoardDocDTO docDTO : list) {
			//첨부파일 갯수가 0이상 일때만 목록 가져옴
			if(docDTO.getCntFile() > 0) {
				//3.첨부파일 가져오기
				List<BoardFileDTO> fileList = boardFileServiceImpl.list(docDTO.getDocId());
				docDTO.setFileList(fileList);
			}
			//코멘트 갯수가 0이상일때만
			if(docDTO.getCntComment() > 0) {
				List<BoardCommentDTO> commentList = boardCommentServiceImpl.list(docDTO.getDocId());
				docDTO.setCommentList(commentList);
			}
			List<BoardLikeDTO> likeList = boardLikeServiceImpl.list(docDTO.getDocId());
			docDTO.setLikeList(likeList);
		}

		return list;
	}
	
	//목록
	@Override
	public List<BoardDocDTO> list(BoardSearchDTO search) {
		
		//1.게시물 갯수
		int total = boardDocDAO.selectCount(search);
		search.setTotal(total);
		//2.목록
		List<BoardDocDTO> list = boardDocDAO.selectList(search);
		for(BoardDocDTO docDTO : list) {
			//첨부파일 갯수가 0이상 일때만 목록 가져옴
			if(docDTO.getCntFile() > 0) {
				//3.첨부파일 가져오기
				List<BoardFileDTO> fileList = boardFileServiceImpl.list(docDTO.getDocId());
				docDTO.setFileList(fileList);
			}
			//코멘트 갯수가 0이상일때만
			if(docDTO.getCntComment() > 0) {
				List<BoardCommentDTO> commentList = boardCommentServiceImpl.list(docDTO.getDocId());
				docDTO.setCommentList(commentList);
			}
			List<BoardLikeDTO> likeList = boardLikeServiceImpl.list(docDTO.getDocId());
			docDTO.setLikeList(likeList);
		}
		return list;
	}
	
	@Override
	@Transactional
	public void editDoc(BoardDocDTO boardDocDTO,HttpSession session) {
		
		//1.게시물 insert
		BoardFileDTO fileDTO = null;
		if(boardDocDTO.getFiles() == null) {
			boardDocDAO.updateDoc(boardDocDTO);
		} else {
			boardDocDAO.updateDoc(boardDocDTO);
			for(MultipartFile file : boardDocDTO.getFiles()) {

			//2.첨부파일 물리적인 디스크에 저장
			fileDTO = fileService.uploadSingleFile(file, session);

			//3.첨부파일 디비에 insert
			fileDTO.setDocId(boardDocDTO.getDocId());
			boardFileServiceImpl.write(fileDTO);
			
//			//선택한 파일 삭제
//			boardFileServiceImpl.removeOnlyFile(fileDTO);
			}
		}
		
	}
	
	@Override
	@Transactional
	public void remove(Integer docId) {
		//1.첨부파일
		boardFileServiceImpl.remove(docId);
		//2.댓글
		boardCommentServiceImpl.removeByDocId(docId);
		//3.좋아요
		boardLikeServiceImpl.removeDoc(docId);
		//4.게시물
		boardDocDAO.deleteData(docId);
		
	}
	//조회
	@Override
	@Transactional //있으면 롤백이 잘됨. 없으면 창을 눌렀을때 에러가 떠도 조회수가 올라감
	public BoardDocDTO view(BoardDocDTO boardDocDTO) {
		
		//1.조회수 증가
		boardDocDAO.updateCntRead(boardDocDTO.getDocId());
		
		//2.조회
		boardDocDTO = boardDocDAO.selectOne(boardDocDTO);
		
		//3.첨부파일 가져오기
		List<BoardFileDTO> fileList = boardFileServiceImpl.list(boardDocDTO.getDocId());
		boardDocDTO.setFileList(fileList);
		
		return boardDocDTO;
	}
	//조회수 증가
	@Override
	public void editCntRead(Integer docId) {
		boardDocDAO.updateCntRead(docId);
	}
	//내가쓴게시판 불러오기
//	@Override
//	public List<BoardDocDTO> listAndUserId(Integer userId) {
//		
//		return boardDocDAO.selectListAndUserId(userId);
//	}
	@Override
	public List<BoardDocDTO> viewListAll() {
		return boardDocDAO.selectListAll();
	}
	//내가 좋아요 누른 게시글만 보기
	@Override
	public List<BoardDocDTO> listByLikeId(Integer viewerId) {
		
		List<BoardDocDTO> list = boardDocDAO.selectListByLikeId(viewerId);
		
		for(BoardDocDTO docDTO : list) {
			if(docDTO.getCntFile()>0) {
				List<BoardFileDTO> fileList = boardFileServiceImpl.list(docDTO.getDocId());
				docDTO.setFileList(fileList);
			}
			if(docDTO.getCntComment()>0) {
				List<BoardCommentDTO> commentList = boardCommentServiceImpl.list(docDTO.getDocId());
				docDTO.setCommentList(commentList);
			}
			List<BoardLikeDTO> likeList = boardLikeServiceImpl.list(docDTO.getDocId());
			docDTO.setLikeList(likeList);
		}
		
		return list;
	}
	@Override
	public BoardDocDTO viewImageBydocId(Integer docId) {
		//조회
		BoardDocDTO boardDocDTO = boardDocDAO.selectImageBydocId(docId);
		
		//첨부파일 가져오기
		List<BoardFileDTO> fileList = boardFileServiceImpl.list(docId);
		boardDocDTO.setFileList(fileList);
		log.debug("이것도 봅시다,..... ==================>"+boardDocDTO);
		
		return boardDocDTO;
	}

}
