package kr.co.bkbk.user.dao;

import java.util.List;

import kr.co.bkbk.user.dto.UserDTO;

public interface IUserDAO {
	public void insertData(UserDTO userDTO);
	public int selectCountByloginId(String loginId);
	public int selectCountByPhone(String phone);
	public int selectCountByEmail(String email);
	public String selectFindId(UserDTO userDTO);
	public UserDTO selectByloginID(String loginId);
	public void updateData(UserDTO userDTO);
	public UserDTO selectOne(Integer userId);
	public void updatePw(UserDTO userDTO);
	public int selectCountByloignPw(UserDTO userDTO);
	public List<UserDTO> selectAllList();
	

}
