package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//여행정보 카테고리 컨트롤러 아마.. 두번쨰로 기능구현될 컨트롤러.랄까..
@Controller
@Log4j
@RequestMapping("/trip/*")
@AllArgsConstructor
public class tripController {
	
	@Autowired
	UserService service; 
	
	@GetMapping("/home")
	public String home() {
		
		return "trip";
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
	@GetMapping("/detail")
	public String tripdetail() {
		
		System.out.println("디테일 폼 왔음.");
		
		return "/trip/trip_detail";
	}
	@GetMapping("/detailInsert")
	public String tripInsertForm() {
	    System.out.println("디테일 인서트폼 왔음.");
	    return "/trip/trip_insert";
	}

}
