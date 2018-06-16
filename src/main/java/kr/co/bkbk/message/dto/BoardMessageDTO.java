package kr.co.bkbk.message.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardMessageDTO {
	private Integer userId = null;
	private Integer sMessageId = null;
	private Integer receiveId = null;
	
	private String title = null;
	private String contents = null;
	private String readYn = null;
	private String spamYn = null;
	private String spamMemo = null;
	
	private Date regDt;

}
