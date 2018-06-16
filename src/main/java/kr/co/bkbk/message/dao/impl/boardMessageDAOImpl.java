package kr.co.bkbk.message.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.common.dao.BaseDaoSupport;
import kr.co.bkbk.message.dao.IBoardMessageDAO;
import kr.co.bkbk.message.dto.BoardMessageDTO;

@Repository
public class boardMessageDAOImpl extends BaseDaoSupport implements IBoardMessageDAO {

	@Override
	public void insertData(BoardMessageDTO boardMessageDTO) {
		this.getSqlSession().insert("BoardMessage.insertData", boardMessageDTO);
	}

	@Override
	public List<BoardMessageDTO> selectList(Integer userId) {
		return this.getSqlSession().selectList("BoardMessage.selectList", userId);
	}

	@Override
	public void deleteData(Integer sMessageId) {
		this.getSqlSession().delete("BoardMessage.deleteData", sMessageId);
	}

}
