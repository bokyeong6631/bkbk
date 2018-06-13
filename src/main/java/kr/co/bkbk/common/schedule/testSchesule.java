package kr.co.bkbk.common.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class testSchesule {
	
//	@Scheduled(fixedDelay = 1000*5)
	public void test() {
		
		log.debug("계속 실행되니===>??");
	}
	
	
}
