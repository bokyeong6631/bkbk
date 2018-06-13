package kr.co.bkbk.board.map.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardMapDTO {
	private Integer mapId;
	private Integer mapSort;
	private Integer parMapId;
	
	private String mapName;
	private String mapType;
	private String delYn;
	private String commentYn;
	
	private Date regDt;

}
