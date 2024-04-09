package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

//시큐리티 확인 컨트롤러!
@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {
	
	@GetMapping("/all")
	public void doAll() {
		
		log.info("모든접근가능한 all!! do all con access everybody");
		
	}
	
	@GetMapping("/member")
	public void doMember() {
		
		log.info("맴버만접근가능한 member !!logined member");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		
		log.info("모든 사용자접근가능한 admin !!admin only");
		
	}
	
	
	
		
}
