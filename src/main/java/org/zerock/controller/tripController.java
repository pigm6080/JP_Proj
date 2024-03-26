package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//여행정보 카테고리 컨트롤러 아마.. 두번쨰로 기능구현될 컨트롤러.랄까..
@Controller
@Log4j
@RequestMapping("/trip/*")
@AllArgsConstructor
public class tripController {
	
	@GetMapping("/home")
	public String home() {
		
		return "trip";
	}

}
