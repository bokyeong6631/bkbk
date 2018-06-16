package kr.co.bkbk.board.map.dto;

import java.util.Date;

import lombok.Data;
@Data
public class BoardCheckDTO {

	private Integer checkId = null;
	private Integer userId = null;
	
	private String checkYn = null;
	private String event = null;
	
	private Date regDt;
}
