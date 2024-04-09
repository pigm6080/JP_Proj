package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//플래너 카테고리 컨트롤러
@Controller
@Log4j
@RequestMapping("/planner/*")
@AllArgsConstructor
public class plannerController {
	
	@Autowired
	UserService service; 
	
	@GetMapping("/home")
	public String home() {
		
		return "planner";
	}
	
	@GetMapping("/regMember")
	public String regMember() {
		
		System.out.println("회원가입 폼 왔음.");
		
		return "redirect:/regMember";
	}
	
	@PostMapping("/reg")
	public String regmember(@ModelAttribute UserVO vo) {
		
	    System.out.println("회원가입 정보: " + vo);
	    
	    service.register(vo);
	    
	    return "redirect:/";
	}
}
