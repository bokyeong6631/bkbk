package kr.co.bkbk.message.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.common.dao.BaseDaoSupport;
import kr.co.bkbk.message.dao.IReceiveMessageDAO;
import kr.co.bkbk.message.dto.ReceiveMessageDTO;

@Repository
public class receiveMessageDAOImpl extends BaseDaoSupport implements IReceiveMessageDAO {

	@Override
	public void insertData(ReceiveMessageDTO receiveDTO) {
		this.getSqlSession().insert("ReceiveMessage.insertData",receiveDTO);
	}

	@Override
	public List<ReceiveMessageDTO> selectList(Integer receiveId) {
		return this.getSqlSession().selectList("ReceiveMessage.selectList", receiveId);
	}

	@Override
	public ReceiveMessageDTO selectOne(Integer rMessageId) {
		return this.getSqlSession().selectOne("ReceiveMessage.selectOne", rMessageId);
	}

}
