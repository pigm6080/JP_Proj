package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//커뮤니티 카테고리 컨트롤러 아마.. 가장 많은 기능구현될 컨트롤러.랄까..
@Controller
@Log4j
@RequestMapping("/community/*")
@AllArgsConstructor
public class communityController {
	
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
	
}
