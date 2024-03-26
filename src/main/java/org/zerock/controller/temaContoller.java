package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//테마 카테고리 컨트롤러
@Controller
@Log4j
@RequestMapping("/tema/*")
@AllArgsConstructor
public class temaContoller {
	
	@GetMapping("/home")
	public String home() {
		
		return "tema";
	}

}
