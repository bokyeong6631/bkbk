package kr.co.bkbk.main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.bkbk.common.dto.ResponseDTO;
import kr.co.bkbk.user.dto.UserDTO;
import kr.co.bkbk.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/find")
public class findController {
	
	@Autowired private IUserService userServiceImpl = null;
	
	//아이디찾기 창열기
	@RequestMapping(value="/id.java6", method=RequestMethod.GET)
	public void gofindId(Model model) {
		
	}
	//찾기 눌렀을때
	@ResponseBody
	@RequestMapping(value="/id.java6", method=RequestMethod.POST)
	public String dofindId(Model model,UserDTO userDTO) {
		String loginId = userServiceImpl.checkFindId(userDTO);
		model.addAttribute("loginId",loginId);
		return loginId;
	}
	
	//아이디찾기 후 넘어가는 비번찾기 창열기
	@RequestMapping(value="/pw.java6", method=RequestMethod.GET)
	public void gofindPw(Model model,UserDTO userDTO) {
		
		String loginId = userServiceImpl.checkFindId(userDTO);
		model.addAttribute("loginId",loginId);
		
	}
	@ResponseBody
	@RequestMapping(value="/pw.java6", method=RequestMethod.POST)
	public void dofindPw(Model model,UserDTO userDTO) {
		
		
		
	}
	
	//로그인화면에서 비번찾기 눌렀을때
	@RequestMapping(value="/editpw.java6", method=RequestMethod.GET)
	public void goEditPw(Model model) {
		
		
	}
	@ResponseBody
	@RequestMapping(value="/editpw.java6", method=RequestMethod.POST)
	public void doEditPw(Model model,UserDTO userDTO) {
		log.debug("userDTO===========>"+userDTO);
		try {
			userServiceImpl.editPw(userDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/cntpw.java6",method=RequestMethod.GET)
	public int viewCountByloignPw(UserDTO userDTO) {
		int result = userServiceImpl.viewCountByloignPw(userDTO);
		if(result == 1) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	
	//db아이디랑 입력받은값이랑 비교
	@ResponseBody
	@RequestMapping(value="/check/id.java6", method=RequestMethod.GET)
	public ResponseDTO checkId(String loginId) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			int result = userServiceImpl.checkLoginId(loginId);
			responseDTO.setCode(result);			
			//있는아이디
			if(result==0) {
				responseDTO.setMsg("O");
			//없는아이디
			}else {
				responseDTO.setMsg("존재하지않습니다 회원가입해주세요");
			}
		}catch(Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("L에러발생. 관리자에게 문의바람");
		}
		return responseDTO;
	}
	
	@ResponseBody
	@RequestMapping(value="/check/phone.java6", method=RequestMethod.GET)
	public ResponseDTO checkPhone(String phone) {
		ResponseDTO responseDTO = new ResponseDTO();
		log.debug("gg====>"+phone);
		try {
			int result = userServiceImpl.checkPhone(phone);
			responseDTO.setCode(result);
			if(result == 0) {
				responseDTO.setMsg("존재");
			}else {
				responseDTO.setMsg("입력하신 번호가 존재하지 않습니다.");
			}
		}catch (Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("P에러발생. 관리자에게 문의바람");
		}
		return responseDTO;
	}
	
	
	

}
