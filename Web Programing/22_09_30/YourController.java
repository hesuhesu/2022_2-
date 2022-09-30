package com.webp.p1;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class YourController{
	
	
	@GetMapping("/")
	public String login() {
		return"login";
		}
	
	@PostMapping("/login/check") 
	public String loginCheck(HttpSession session, String id) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("고흐");
		list.add("james");
		list.add("dooli");
		list.add("bread");
		
		if( list.contains(id) ) {
			session.setAttribute("id", id);
			return "redirect:/menu"; // 같은 controller안 다른 method인 menu로 가라는 뜻.
			}
		else
			return "popups";
		
	}
	
	@GetMapping("/menu")
	public String menu(HttpSession session, Model model) {
		model.addAttribute("id", session.getAttribute("id"));
		return"menu";
	}
	
	@GetMapping("/popups")
		public String popups() {
		return"popups";
	}
	
}
