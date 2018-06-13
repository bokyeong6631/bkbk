package kr.co.bkbk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.bkbk.user.dto.UserDTO;
import kr.co.bkbk.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Slf4j
public class UserTest {
	@Autowired
	private IUserService userService = null;

//	@Test
//	public void write() {
//		UserDTO userDTO = new UserDTO();
//		userDTO.setUserId(300);
//		userDTO.setLoginId("starwars");
//		userDTO.setLoginPw("B");
//		userDTO.setName("가나다");
//		userDTO.setPhone("010-22-2012");
//		userDTO.setEmail("qwe@gmail.com");
//
//		userService.write(userDTO);
//	}
	@Test
	public void checkFindId() {
		UserDTO userDTO = new UserDTO();
		userDTO.setName("아브라");
		userDTO.setPhone("010-333-3333");
		userService.checkFindId(userDTO);
	}

}
