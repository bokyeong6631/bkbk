package kr.co.bkbk.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.common.dao.BaseDaoSupport;
import kr.co.bkbk.user.dao.IUserDAO;
import kr.co.bkbk.user.dto.UserDTO;

@Repository
public class UserDAOImpl extends BaseDaoSupport implements IUserDAO {

	@Override
	public void insertData(UserDTO userDTO) {
		this.getSqlSession().insert("User.insertData", userDTO);
	}
	@Override
	public int selectCountByloginId(String loginId) {
		return this.getSqlSession().selectOne("User.selectCountByloginId", loginId);
	}
	@Override
	public int selectCountByPhone(String phone) {
		return this.getSqlSession().selectOne("User.selectCountByPhone", phone);
	}
	@Override
	public int selectCountByEmail(String email) {
		return this.getSqlSession().selectOne("User.selectCountByEmail", email);
	}
	@Override
	public String selectFindId(UserDTO userDTO) {
		return this.getSqlSession().selectOne("User.selectFindId", userDTO);
	}
	@Override
	public UserDTO selectByloginID(String loginId) {
		return this.getSqlSession().selectOne("User.selectByloginID",loginId);
	}
	@Override
	public void updateData(UserDTO userDTO) {
		this.getSqlSession().update("User.updateData", userDTO);
	}
	@Override
	public UserDTO selectOne(Integer userId) {
		return this.getSqlSession().selectOne("User.selectOne", userId);
	}
	@Override
	public void updatePw(UserDTO userDTO) {
		this.getSqlSession().update("User.updatePw", userDTO);
	}
	@Override
	public int selectCountByloignPw(UserDTO userDTO) {
		return this.getSqlSession().selectOne("User.selectCountByloignPw",userDTO);
	}
	@Override
	public List<UserDTO> selectAllList() {
		return this.getSqlSession().selectList("User.selectAllList");
	}
	

}
