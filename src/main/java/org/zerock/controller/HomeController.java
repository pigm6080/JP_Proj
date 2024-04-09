package org.zerock.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import lombok.extern.log4j.Log4j;
@Log4j
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService service; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,Principal principal) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		log.info("마이프로필 창으로 이동");
		
		if (principal != null && principal.getName() != null) {
		    log.info("유저아이디: " + principal.getName());
		    String userid = principal.getName();
		    UserVO vo = service.get(userid);
		    String num = vo.getName()+" 님 환영합니다.";
		    vo.setName(num);
		    model.addAttribute("user", vo);
		    System.out.println("유저 정보는"+vo);
		}
			
			
		return "index";
	}
	
	@GetMapping("/regMember")
	public String regMember() {
		
		System.out.println("회원가입 폼 왔음.");
		
		return "regMember";
	}
	
	@PostMapping("/reg")
	public String regmember(@ModelAttribute UserVO vo) {
		
	    System.out.println("회원가입 정보: " + vo);
	    
	    service.register(vo);
	    
	    return "redirect:/";
	}
	
	   
	  @PostMapping("/email-check")
	   public @ResponseBody String emailCheck(@RequestParam("username")String username) {
		   System.out.println("username = " + username);
		   String checkResultString = service.emailcheck(username);
		   return checkResultString;
	   }
	
}
	

//main controller
