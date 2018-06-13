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
import kr.co.bkbk.board.map.service.IBoardLikeService;
import kr.co.bkbk.board.map.service.IBoardMapService;
import kr.co.bkbk.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/doc")
public class BoardDocController {
	
	@Autowired private IBoardLikeService boardLikeServiceImpl = null;
	@Autowired private IBoardFileService boardFileServiceImpl = null;
	@Autowired private IBoardMapService boardMapService = null;
	@Autowired private IBoardDocService boardDocService = null;
	
	//내가 쓴 게시글
	@RequestMapping(value="/user.java6",method=RequestMethod.GET)
	public void mineList(Model model,Integer userId
			,@ModelAttribute("search") BoardSearchDTO search
			,HttpSession session
			,BoardDocDTO boardDocDTO
			) {
		//유저정보
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		model.addAttribute("userDTO", userDTO);
		
		//게시판 목록
		List<BoardDocDTO> listMine = boardDocService.viewListByuserId(search);
		model.addAttribute("mine", listMine);
		log.debug("listAndUserId_search========================>"+listMine);
		log.debug("boardDocDTO_search========================>"+boardDocDTO);
		
		 List<BoardFileDTO> fileList = boardDocDTO.getFileList();
		 model.addAttribute("fileList", fileList);
	}
	
	@RequestMapping(value="/list.java6", method=RequestMethod.GET)
	public void list(Model model, @ModelAttribute("search") BoardSearchDTO search,BoardDocDTO boardDocDTO) {
		
		//1.통합맵 정보 가져오기
		BoardMapDTO boardMapDTO = boardMapService.view(search.getMapId());
		model.addAttribute("boardMapDTO", boardMapDTO);
		
		//2.게시판 목록 가져오기
		List<BoardDocDTO> list = boardDocService.list(search);
		model.addAttribute("list", list);
		log.debug("니ㅏㅇ민어미나로ㅓㄹ=============>"+list);
	}
	
	//글쓰기 창 열기
	@RequestMapping(value="/write.java6", method=RequestMethod.GET)
	public void gowrite(Model model, Integer mapId,@ModelAttribute("search") BoardSearchDTO search) {
		//1.통합맵 정보 가져오기
		BoardMapDTO boardMapDTO = boardMapService.view(search.getMapId());
		model.addAttribute("boardMapDTO", boardMapDTO);
		log.debug("mapName =====>"+boardMapDTO);
	}
	//글쓰기 등록
	@RequestMapping(value="/write.java6", method=RequestMethod.POST)
	public String dowrite(Model model
						  ,HttpSession session
						  ,BoardDocDTO boardDocDTO
						  ,@ModelAttribute("search") BoardSearchDTO search) {
		
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		boardDocDTO.setUserId(userDTO.getUserId());
		
		boardDocService.write(boardDocDTO,session);
//		HtmlUtils.htmlEscape(input);
		
		return "redirect:./list.java6?mapId="+boardDocDTO.getMapId();
	}
	
	//게시글
	@RequestMapping(value="/view.java6", method=RequestMethod.GET)
	public void view(Model model
					,@ModelAttribute("search") BoardSearchDTO search
					,HttpSession session
					,Integer docId
					,BoardDocDTO docDTO) {
		
		//통합맵 정보가져오기 (list에서 가져온건데 일일히 가져오기싫으면 session에 넣으면됨.
		BoardMapDTO boardMapDTO = boardMapService.view(search.getMapId());
		model.addAttribute("boardMapDTO", boardMapDTO);
		
		
		// 2. 로그인 한 사용자 ID 구하기(뷰어)
		UserDTO userDTO = (UserDTO)session.getAttribute("_user");
		docDTO.setViewerId(userDTO.getUserId());
		log.debug("viewerId==========>"+docDTO);
		model.addAttribute("userDTO",userDTO);
		
		//조회
		BoardDocDTO boardDocDTO = boardDocService.view(docDTO);
		model.addAttribute("view",boardDocDTO);
//		log.debug("보이자View boardDocDTO=========>"+boardDocDTO);
		
		//첨부파일 조회
		 List<BoardFileDTO> list = boardDocDTO.getFileList();
		model.addAttribute("list", list);
		
	}
	@RequestMapping(value="/edit.java6", method=RequestMethod.GET)
	public void goEdit(Model model
						,@ModelAttribute("search") BoardSearchDTO search
						,Integer mapId
						,BoardDocDTO docDTO
						) {
		//1.통합맵 정보 가져오기
		BoardMapDTO boardMapDTO = boardMapService.view(search.getMapId());
		model.addAttribute("boardMapDTO", boardMapDTO);

		//2.게시판 목록 가져오기
		BoardDocDTO boardDocDTO = boardDocService.view(docDTO);
		model.addAttribute("view", boardDocDTO);
		log.debug("askjhawkrghwa===========>"+boardDocDTO);

		//첨부파일 조회
		List<BoardFileDTO> list = boardDocDTO.getFileList();
		model.addAttribute("list", list);

		
	}
	//게시판 수정
	@RequestMapping(value="/edit.java6", method=RequestMethod.POST)
	public String doEdit(Model model, HttpSession session,@ModelAttribute("search") BoardSearchDTO search,BoardDocDTO boardDocDTO) {
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		boardDocDTO.setUserId(userDTO.getUserId());
		
		boardDocService.editDoc(boardDocDTO,session);
		log.debug("doedit=====>"+boardDocDTO);
		
		return "redirect:./view.java6?docId="+boardDocDTO.getDocId()+"&"+search.getParams();
	}
	
	//게시판 삭제
	@RequestMapping(value="/remove.java6", method=RequestMethod.GET)
	public String remove(@ModelAttribute("search") BoardSearchDTO search) {
		
		boardDocService.remove(search.getDocId());
		return "redirect:./list.java6?mapId="+search.getMapId();
	}
	@RequestMapping(value="/all.java6",method=RequestMethod.GET)
	public void listAll() {
		boardDocService.viewListAll();
	}
	
	@RequestMapping(value="/lock.java6")
	public void locked(@ModelAttribute("search") BoardSearchDTO search,Model model,BoardDocDTO docDTO) {
		BoardDocDTO boardDocDTO = boardDocService.view(docDTO);
		model.addAttribute("boardDocDTO", boardDocDTO);
		log.debug("locked_boardDocDTO============>"+boardDocDTO);
		log.debug("locked_search============>"+search);

	}
	

}
