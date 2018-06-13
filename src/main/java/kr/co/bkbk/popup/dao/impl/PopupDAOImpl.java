package kr.co.bkbk.popup.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.common.dao.BaseDaoSupport;
import kr.co.bkbk.popup.dao.IPopupDAO;
import kr.co.bkbk.popup.dto.PopupDTO;

@Repository
public class PopupDAOImpl extends BaseDaoSupport implements IPopupDAO {

	@Override
	public void insertData(PopupDTO popupDTO) {
		this.getSqlSession().insert("popup.insertData",popupDTO);
	}

	@Override
	public List<PopupDTO> selectList() {
		return this.getSqlSession().selectList("popup.selectList");
	}

	@Override
	public PopupDTO selectOne(int popupId) {
		return this.getSqlSession().selectOne("popup.selectOne",popupId);
	}

	@Override
	public void deleteData(int popupId) {
		this.getSqlSession().delete("popup.deleteData", popupId);
	}

}
