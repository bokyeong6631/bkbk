package kr.co.bkbk.common.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	public int code = 9; //9 : 성공
	public String msg = "성공하였습니다.";
	
}
