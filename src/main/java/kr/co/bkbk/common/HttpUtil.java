
package kr.co.bkbk.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HttpUtil {
	public String connect(String str)
			throws UnsupportedEncodingException, IOException {
			URL url = new URL(str);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String result = "";
			String line = "";
			
			while((line = br.readLine()) != null) {
				result += line + "\n";
			}
			
			if(conn != null) {
				conn.disconnect();
			}
			
			if(br != null) {
				br.close();
			}
			
			return result;
	}
}
