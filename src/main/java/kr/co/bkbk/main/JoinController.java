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
public class JoinController {
	
	@Autowired private IUserService userService = null;
	
	//나의 정보 수정 페이지
	@RequestMapping(value="/edit.java6", method=RequestMethod.GET)
	public void goEdit(Model model, HttpSession session) {
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		userDTO = userService.view(userDTO.getUserId());
		model.addAttribute("userDTO",userDTO);
	}
	//수정후 저장버튼 눌렀을시
		@ResponseBody
		@RequestMapping(value="/edit.java6", method=RequestMethod.POST)
		public Integer doEdit(UserDTO userDTO, HttpSession session) {
			UserDTO param = (UserDTO) session.getAttribute("_user");
			userDTO.setUserId(param.getUserId());
			try {
				userService.edit(userDTO);
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}
			return 1;
		}
	
	
	//회원가입 페이지로 이동
	@RequestMapping(value="/join.java6", method=RequestMethod.GET)
	public void gojoin() {
		
	}
	//회원가입
	@ResponseBody
	@RequestMapping(value="/join.java6", method=RequestMethod.POST)
	public Integer dojoin(UserDTO userDTO) {
			userService.write(userDTO);
			return 1;
	}
	@ResponseBody
	@RequestMapping(value="/check/id.java6", method=RequestMethod.GET)
	public ResponseDTO checkId(String loginId) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			int result = userService.checkLoginId(loginId);
			responseDTO.setCode(result);			
			//아이디 사용가능
			if(result==1) {
				responseDTO.setMsg("아이디 사용이 가능합니다");
			//아이디 사용불가능
			}else {
				responseDTO.setMsg("이미 존재하는 아이디입니다.");
			}
		}catch(Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("L에러발생. 관리자에게 문의바람");
		}
		return responseDTO;
	}
	@ResponseBody
	@RequestMapping(value="/check/phone.java6", method=RequestMethod.GET)
	public ResponseDTO checkPhone(String phoneNumber) {
		ResponseDTO responseDTO = new ResponseDTO();
		log.debug("gg====>"+phoneNumber);
		try {
			int result = userService.checkPhone(phoneNumber);
			responseDTO.setCode(result);
			if(result == 1) {
				responseDTO.setMsg("사용가능한 핸드폰번호");
			}else {
				responseDTO.setMsg("중복된 핸드폰 번호");
			}
		}catch (Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("P에러발생. 관리자에게 문의바람");
		}
		return responseDTO;
	}
	@ResponseBody
	@RequestMapping(value="/check/email.java6", method=RequestMethod.GET)
	public ResponseDTO checkEmail(String email) {
		ResponseDTO responseDTO = new ResponseDTO();
		log.debug("gg====>"+email);
		try {
			int result = userService.checkEmail(email);
			responseDTO.setCode(result);
			if(result == 1) {
				responseDTO.setMsg("사용가능한 이메일주소");
			}else {
				responseDTO.setMsg("중복된 이메일 주소");
			}
		}catch (Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("P에러발생. 관리자에게 문의바람");
		}
		return responseDTO;
	}
	
}
