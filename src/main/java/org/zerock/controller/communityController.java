package org.zerock.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.AuthVO;
import org.zerock.domain.UserVO;
import org.zerock.security.domain.Role;
import org.zerock.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//커뮤니티 카테고리 컨트롤러 아마.. 가장 많은 기능구현될 컨트롤러.랄까..
@Controller
@Log4j
@RequestMapping("/community/*")
@AllArgsConstructor
public class communityController {
	
	@Autowired
	UserService service; 
	
	@GetMapping("/home") //카테고리 메인으로이동
	public String home() {
		
		return "community";
	}
	
	@GetMapping("/review")
	public String review() {
		
		return "/community/review";
	}
	
	@GetMapping("/review/save")
	public String save() {
		
		return "/community/register";
	}
	@GetMapping("/review/list")
	public String list() {
		
		return "/community/list";
	}
	@GetMapping("/list")
	public String triplist() {
		
		return "/community/triplist";
	}
	@GetMapping("/favorite")
	public String favorite() {
		
		return "/community/favorite";
	}
	@GetMapping("/regMember")
	public String regMember() {
		
		System.out.println("회원가입 폼 왔음.");
		
		return "redirect:/regMember";
	}
	
	@PostMapping("/reg")
	public String regmember(@ModelAttribute UserVO vo) {
		//일반회원 회원가입임
		
		AuthVO authVO = new AuthVO(vo.getUsername(),Role.MEMBER.name());
	    System.out.println("회원가입 정보: " + vo);
	    vo.setAuth(authVO); //FIXME
	    
	    service.register(vo);
	    
	    return "redirect:/";
	}
}
