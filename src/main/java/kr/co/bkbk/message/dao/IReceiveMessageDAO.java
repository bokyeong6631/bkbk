package kr.co.bkbk.message.dao;

import java.util.List;

import kr.co.bkbk.message.dto.ReceiveMessageDTO;

public interface IReceiveMessageDAO {
	
	public void insertData(ReceiveMessageDTO receiveDTO);
	public List<ReceiveMessageDTO> selectList(Integer receiveId);
	public ReceiveMessageDTO selectOne(Integer rMessageId);

}
