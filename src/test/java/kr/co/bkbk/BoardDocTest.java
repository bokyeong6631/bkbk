package kr.co.bkbk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.service.IBoardDocService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class BoardDocTest {
	@Autowired
	private IBoardDocService boardDocService = null;
	
//	@Test
//	public void write() {
//		BoardDocDTO boardDocDTO = new BoardDocDTO();
//		
//		boardDocDTO.setMapId(8);
//		boardDocDTO.setTitle("왜안될까");
//		boardDocDTO.setBoardContents("될까");
//		boardDocService.write(boardDocDTO);
//	}
//	@Test
//	public void viewTitle() {
//		BoardDocDTO boardDocDTO = new BoardDocDTO();
//		boardDocDTO.setTitle("ddd");
//		System.out.println(boardDocDTO.toString());
//	}
//	@Test
//	public void editDoc() {
//		BoardDocDTO boardDocDTO = new BoardDocDTO();
//		boardDocDTO.setTitle("수정");
//		boardDocDTO.setBoardContents("rere");
//		boardDocDTO.setDocId(2);
//		
//	}
//	@Test
//	public void remove() {
//		BoardDocDTO boardDocDTO = new BoardDocDTO();
//		boardDocDTO.setDocId(2);
//	}
}
