package kr.co.bkbk.main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.bkbk.common.HttpUtil;
import kr.co.bkbk.common.file.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	@Autowired private HttpUtil httpUtil = null;
	@Autowired private FileService fileservice = null; 
	
	@RequestMapping(value="/main/index.java6", method=RequestMethod.GET)
	public void index() {
		
	}
	
	@RequestMapping(value="/main/bus.java6",method=RequestMethod.GET)
	public void busInfo() {
		
	}
	

	
	@ResponseBody
	@RequestMapping(value="/main/bus.java6",method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String getBusInfo(HttpServletResponse response, HttpSession session) {
		try {
			String url="http://api.gwangju.go.kr/json/arriveInfo"
					+"?serviceKey=WNcKLKef%2BXz9cy%2BOsFbJB8Qq%2F4JBVGsZ4ySAKcG%2B%2F7EJMA6MRUn0flHyuscyb8IOJjmFgS8rWblWGG%2Bp7PKohA%3D%3D"
					+"&BUSSTOP_ID=2873";
			String result = httpUtil.connect(url);
			log.debug("@@Result ==> " + result);
			
			JsonParser parser = new JsonParser();
			JsonElement je = parser.parse(result);
			
			JsonObject jsonObject = je.getAsJsonObject();
			
			JsonObject resultObject = jsonObject.get("RESULT").getAsJsonObject();
			String resultCode = resultObject.get("RESULT_CODE").getAsString();
			log.debug("resultCode===>"+resultCode);
			
			if(resultCode != null && resultCode.equals("SUCCESS")) {
				JsonArray jsonArray = jsonObject.get("BUSSTOP_LIST").getAsJsonArray();
				
				// 포이 시작
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("버경");
				
				String[] strArray = {
							"번호"
							, "ARRIVE"
							, "REMAIN_STOP"
							, "BUS_ID"
							, "METRO_FLAG"
							, "BUSSTOP_NAME"
							, "CURR_STOP_ID"
							, "LINE_ID"
							, "REMAIN_MIN"
							, "ENG_BUSSTOP_NAME"
							, "DIR_START"
							, "DIR"
							, "LOW_BUS"
							, "ARRIVE_FLAG"
							, "LINE_NAME"
						};
				
				Row row = sheet.createRow(0);
				for(int i = 0; i < strArray.length; i++) {
					Cell cell = row.createCell(i);
					cell.setCellValue(strArray[i]);
				}
				
				for(int i = 0; i < jsonArray.size(); i++) {
					int rowNum = i + 1;
					
					JsonObject obj = jsonArray.get(i).getAsJsonObject();
					log.debug(rowNum + " / " + i);
					
					Row rows = sheet.createRow(rowNum);
					
					List<String> list = new ArrayList<String>();
					list.add(rowNum + "");
					list.add(obj.get("ARRIVE").getAsString());
					list.add(obj.get("REMAIN_STOP").getAsString());
					list.add(obj.get("BUS_ID").getAsString());
					list.add(obj.get("METRO_FLAG").getAsString());
					list.add(obj.get("BUSSTOP_NAME").getAsString());
					list.add(obj.get("CURR_STOP_ID").getAsString());
					list.add(obj.get("LINE_ID").getAsString());
					list.add(obj.get("REMAIN_MIN").getAsString());
					list.add(obj.get("ENG_BUSSTOP_NAME").getAsString());
					list.add(obj.get("DIR_START").getAsString());
					list.add(obj.get("DIR").getAsString());
					list.add(obj.get("LOW_BUS").getAsString());
					list.add(obj.get("ARRIVE_FLAG").getAsString());
					list.add(obj.get("LINE_NAME").getAsString());
					
					for(int j = 0; j < list.size(); j++) {
						Cell cell = rows.createCell(j);
						cell.setCellValue(list.get(j));
					}
				}
//				File file = new File("D:/test.xlsx");
//	        	FileOutputStream fos = new FileOutputStream(file);
	        	FileOutputStream fos = new FileOutputStream("test.xls");
	        	workbook.write(fos);
	        	
	        	fos.close();
	        	workbook.close();
	        	
//	        	fileservice.downloadExcelFile(response, session, workbook);
			}
			return new String(result.getBytes(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "실패";
		}
	}

}
