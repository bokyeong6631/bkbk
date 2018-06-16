package kr.co.bkbk.webcrawler.controller;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.webcrawler.dto.DaumMovieDTO;
import kr.co.bkbk.webcrawler.service.IDaumMovieService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/movie")
public class DaumMovieController {
	
	@Autowired IDaumMovieService daumMovieServiceImpl = null;
	
	@RequestMapping(value="/redaum.java6",method=RequestMethod.GET)
	public void RedaumMovieReview() throws IOException {
		String url = "http://movie.daum.net/moviedb/grade?movieId=108035&type=netizen&page=";
		int page = 1;
		try {
			log.debug("@@@@@@@@@@=============>");
			while(page <= 5) {
				page++;
				String connectUrl = url + page;
				Document doc = Jsoup.connect(connectUrl).get();
				log.debug("==============================================================="+page+"페이지=============================================================");
				Elements info = doc.select("div.review_info");
				for (Element element : info) {
					DaumMovieDTO dmDTO = new DaumMovieDTO();
					dmDTO.setMtitle("쥬라기공원");
					dmDTO.setMwriter(element.select("em.link_profile").text());
					dmDTO.setMreviews(element.select("p.desc_review").text());
					dmDTO.setMscore(element.select("em.emph_grade").text());
					dmDTO.setMdate(element.select("span.info_append").text());
					daumMovieServiceImpl.write(dmDTO);
					log.debug("dmDTO==================>"+dmDTO.toString());
				}	
			}
		}catch (Exception e) {
			e.printStackTrace();
			log.debug(" 안나와여==================>catch!!!!!");
		}
	}
	@RequestMapping(value="/daum.java6",method=RequestMethod.GET)
	public void daumMovieReview(Model model,@ModelAttribute("search") BoardSearchDTO search) {
		List<DaumMovieDTO> list = daumMovieServiceImpl.list(search);
		model.addAttribute("list",list);
		
		log.debug("search=================>"+search);
	}

}
