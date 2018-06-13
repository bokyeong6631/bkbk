package kr.co.bkbk.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.user.dao.IUserDAO;
import kr.co.bkbk.user.dto.UserDTO;
import kr.co.bkbk.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
	@Autowired private IUserDAO userDAO = null;
	@Override
	public void write(UserDTO userDTO) {
		userDAO.insertData(userDTO);
	}
	@Override
	public int checkLoginId(String loginId) {
		int cnt = userDAO.selectCountByloginId(loginId);
		if(cnt > 0) {
			//사용x
			return 0;
		}else {
			//사용o
			return 1;
		}
	}
	@Override
	public int checkPhone(String phone) {
		int cnt = userDAO.selectCountByPhone(phone);
		log.debug("phoneNumber===============>"+phone);
		if(cnt > 0) {
			return 0;
		}else {
			return 1;
		}
	}
	@Override
	public int checkEmail(String email) {
		int cnt = userDAO.selectCountByEmail(email);
		if(cnt > 0) {
			return 0;
		}else {
			return 1;
		}
	}
	@Override
	public String checkFindId(UserDTO userDTO) {
		return userDAO.selectFindId(userDTO);
	}
	@Override
	public UserDTO viewByloginID(String loginId) {
		return userDAO.selectByloginID(loginId);
	}
	@Override
	public void edit(UserDTO userDTO) {
		userDAO.updateData(userDTO);
	}
	@Override
	public UserDTO view(Integer userId) {
		return userDAO.selectOne(userId);
	}
	//비밀번호찾기 중 아이디 비번 확인 후 수정
	@Override
	public void editPw(UserDTO userDTO) {
		userDAO.updatePw(userDTO);
	}
	
	//비밀번호찾기 중 아이디 비밀번호 확인
	@Override
	public int viewCountByloignPw(UserDTO userDTO) {
		int cnt = userDAO.selectCountByloignPw(userDTO);
		if(cnt>0) {
			//존재하고 있으니까 확인된거!
			return 1;
		}else {
			//존재하지 않는거니까 확인안됨!
			return 0;
		}
	}
	@Override
	public List<UserDTO> listAll() {
		return userDAO.selectAllList();
	}

}
