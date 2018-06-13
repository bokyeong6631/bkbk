package kr.co.bkbk.user.service;

import java.util.List;

import kr.co.bkbk.user.dto.UserDTO;

public interface IUserService {
	public void write(UserDTO userDTO);
	public int checkLoginId(String loginId);
	public int checkPhone(String phone);
	public int checkEmail(String email);
	public String checkFindId(UserDTO userDTO);
	public UserDTO viewByloginID(String loginId);
	public void edit(UserDTO userDTO);
	public UserDTO view(Integer userId);
	public void editPw(UserDTO userDTO);
	public int viewCountByloignPw(UserDTO userDTO);
	public List<UserDTO> listAll();
}
