package kr.co.bkbk.board.map.dto;

import java.util.Date;

import lombok.Data;
@Data
public class BoardCommentDTO {
	private Integer commentId = 0;
	private Integer docId;
	private Integer userId;
	private Integer cntComment;
	
	private String mapName = null;
	private String userName = null;
	private String comments = null;
	
	private Date regDt;
}
