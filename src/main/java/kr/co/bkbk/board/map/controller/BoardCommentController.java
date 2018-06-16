package kr.co.bkbk.board.map.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.bkbk.board.map.dto.BoardCommentDTO;
import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardFileDTO;
import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.board.map.service.IBoardCommentService;
import kr.co.bkbk.board.map.service.IBoardDocService;
import kr.co.bkbk.common.dto.ResponseDTO;
import kr.co.bkbk.user.dto.UserDTO;
import kr.co.bkbk.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/comment")
public class BoardCommentController {
	@Autowired private IBoardCommentService boardCommentServiceImpl = null;
	@Autowired private IUserService userServiceImpl = null;
	@Autowired private IBoardDocService boardDocServiceImpl =null;
	
	
	@ResponseBody 
	@RequestMapping(value="/enroll.java6",method=RequestMethod.POST)
	public ResponseDTO enroll(Model model, HttpSession session,@ModelAttribute("commentDTO") BoardCommentDTO boardCommentDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			//사용자 ID 구하기
			UserDTO userDTO = (UserDTO) session.getAttribute("_user");
			boardCommentDTO.setUserId(userDTO.getUserId());
			//댓글저장
			boardCommentServiceImpl.write(boardCommentDTO);
			model.addAttribute("user",userDTO);
			
		}catch(Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("L에러발생. 관리자에게 문의바람");
		}
		return responseDTO;
	}
	@RequestMapping(value="/list.java6", method=RequestMethod.GET)
	public void list(Model model, Integer docId) {
		List<BoardCommentDTO> list = boardCommentServiceImpl.list(docId);
		model.addAttribute("list", list);
		
	}
	//댓글삭제
	@ResponseBody
	@RequestMapping(value="/delete.java6", method=RequestMethod.POST)
	public void delete(Integer commentId
			,@ModelAttribute("search")BoardSearchDTO search
			,BoardDocDTO boardDocDTO) {
		boardCommentServiceImpl.remove(commentId);
	}
	
	@RequestMapping(value="/user.java6",method=RequestMethod.GET)
	public void ViewByUserCommnent(Model model,Integer userId
			,@ModelAttribute("search") BoardSearchDTO search
			,HttpSession session
			,BoardDocDTO boardDocDTO
			) {
		//유저정보
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		model.addAttribute("userDTO", userDTO);
		
		//게시판 목록
		List<BoardDocDTO> listMine = boardCommentServiceImpl.ViewListAndUserId(search);
		model.addAttribute("mine", listMine);
		log.debug("listAndUserId_search========================>"+listMine);
		log.debug("boardDocDTO_search========================>"+boardDocDTO);
		
		 List<BoardFileDTO> fileList = boardDocDTO.getFileList();
		 model.addAttribute("fileList", fileList);
	}
}
