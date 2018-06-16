package kr.co.bkbk.user.dto;

import java.util.Date;
import lombok.Data;

@Data
public class UserDTO {
	private Integer userId = null;
	private Integer status = null;
	
	private String loginId = null;
	private String loginPw = null;
	private String name = null;
	private String phone = null;
	private String email = null;
	private String role = "USER";
	
	private Date regDt;
}
