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

import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardLikeDTO;
import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.board.map.service.IBoardDocService;
import kr.co.bkbk.board.map.service.IBoardFileService;
import kr.co.bkbk.board.map.service.IBoardLikeService;
import kr.co.bkbk.common.dto.ResponseDTO;
import kr.co.bkbk.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/board/doc/like")
public class BoardLikeController {
	
	@Autowired private IBoardLikeService boardLikeServiceImpl = null;
	@Autowired private IBoardDocService boardDocServiceImpl = null;
	@Autowired private IBoardFileService boardFileServiceImpl = null;
	
	@ResponseBody
	@RequestMapping(value="/like.java6",method=RequestMethod.POST)
	public ResponseDTO write(BoardLikeDTO boardLikeDTO,HttpSession session,Model model) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			UserDTO userDTO = (UserDTO) session.getAttribute("_user");
			boardLikeDTO.setUserId(userDTO.getUserId());
			boardLikeServiceImpl.write(boardLikeDTO);
			log.debug("boardLikeDTO===============>"+boardLikeDTO);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return responseDTO;
	}
	//내가 좋아요 한 글 리스트
	@RequestMapping(value="/list.java6",method=RequestMethod.GET)
	public void list(Model model  
					,HttpSession session
					,BoardDocDTO boardDocDTO
					,BoardMapDTO boardMapDTO
					,@ModelAttribute("search")BoardSearchDTO search) {
		
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		model.addAttribute("userDTO", userDTO);
		Integer viewerId = userDTO.getUserId();
		
		List<BoardDocDTO> list = boardDocServiceImpl.listByLikeId(viewerId);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value="/dislike.java6",method=RequestMethod.GET)
	public void dislikeList(Model model
							,HttpSession session
							,BoardDocDTO boardDocDTO
							,BoardMapDTO boardMapDTO
							,@ModelAttribute("search")BoardSearchDTO search) {
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		model.addAttribute("userDTO", userDTO);
		Integer viewerId = userDTO.getUserId();
		
		List<BoardDocDTO> list = boardDocServiceImpl.listByLikeId(viewerId);
		model.addAttribute("list", list);
		
	}

}
