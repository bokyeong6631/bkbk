package kr.co.bkbk.board.map.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardFileDTO;
import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.board.map.service.IBoardDocService;
import kr.co.bkbk.board.map.service.IBoardFileService;
import kr.co.bkbk.board.map.service.IBoardMapService;
import kr.co.bkbk.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/doc/photo")
public class boardPhotoController {
	
	@Autowired IBoardMapService boardMapServiceImpl = null;
	@Autowired IBoardDocService boardDocServiceImpl = null;
	@Autowired IBoardFileService boardFileServiceImpl = null;
	
	
	@RequestMapping(value="/list.java6",method=RequestMethod.GET)
	public void list(Model model
					,@ModelAttribute("search") BoardSearchDTO search
					,BoardDocDTO boardDocDTO) {
		//1.통합맵 정보 가져오기
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());
		model.addAttribute("boardMapDTO", boardMapDTO);
		
		//2.게시판 목록 가져오기
		List<BoardDocDTO> list = boardDocServiceImpl.list(search);
		model.addAttribute("list", list);
		log.debug("photo_list==============>"+list);
		
	}
	@RequestMapping(value="/write.java6",method=RequestMethod.GET)
	public void gowrite(@ModelAttribute("search") BoardSearchDTO search,Model model) {
		//1.통합맵 정보 가져오기
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());
		model.addAttribute("boardMapDTO", boardMapDTO);
		log.debug("mapName =====>"+boardMapDTO);
		
	}
	@RequestMapping(value="/write.java6",method=RequestMethod.POST)
	public String dowrite(BoardDocDTO boardDocDTO
						  ,HttpSession session
						  ,@ModelAttribute("search") BoardSearchDTO search
						  ) {
		
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		boardDocDTO.setUserId(userDTO.getUserId());
		
		boardDocServiceImpl.write(boardDocDTO,session);
		
		return "redirect:./list.java6?mapId="+boardDocDTO.getMapId();
	}
	@RequestMapping(value="/view.java6",method=RequestMethod.GET)
	public void view(Model model
			,@ModelAttribute("search") BoardSearchDTO search
			,HttpSession session
			,BoardDocDTO docDTO) {
		
		//통합맵 정보가져오기
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());
		model.addAttribute("boardMapDTO", boardMapDTO);
		
		//조회
		BoardDocDTO boardDocDTO = boardDocServiceImpl.view(docDTO);
		model.addAttribute("view",boardDocDTO);
		
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		boardDocDTO.setUserId(userDTO.getUserId());
		model.addAttribute("userDTO",userDTO);
		
		//첨부파일 조회
		 List<BoardFileDTO> list = boardDocDTO.getFileList();
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value="/remove.java6",method=RequestMethod.GET)
	public String remove(@ModelAttribute("search") BoardSearchDTO search) {

		boardDocServiceImpl.remove(search.getDocId());
		return "redirect:./list.java6?mapId="+search.getMapId();
	}
}
