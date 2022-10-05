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
	public String loginCheck(HttpSession session, String id, Model model) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("은희수");
		list.add("hesuhesu");
		list.add("dooli");
		list.add("practice");
		
		if( list.contains(id) ) {
			session.setAttribute("id", id);
			model.addAttribute("id", id);
			return "menu"; // 같은 controller안 다른 method인 menu로 가라는 뜻.
			}
		else
			return "popups";
		
	}
	
	/*
	 * @GetMapping("/menu")
	public String menu(HttpSession session, Model model) {
		model.addAttribute("id", session.getAttribute("id"));
		return"menu";
	}
	 */
	
	/*
	@GetMapping("/popups")
		public String popups() {
		return"popups";
	}
	 */
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		model.addAttribute("id", session.getAttribute("id"));
		session.invalidate();
		return"logout";
	}
	
	
	
	
	
	@GetMapping("/start")
	public String start() { return "start";
	}
	
	@PostMapping("/survey1")
	public String survey1(HttpSession session, String id) {
		session.setAttribute("id",id);
		return "survey1";
	}
	
	@PostMapping("/survey2")
	public String survey2(HttpSession session, String artist) {
		session.setAttribute("artist",artist);
		return "survey2";
	}
	
	@PostMapping("/thanks")
	public String thanks(HttpSession session, String musician) {
		session.setAttribute("musician",musician);
		return "thanks";
	}
	
	@GetMapping("/result")
	public String result(HttpSession session, Model model) {
		model.addAttribute("id", session.getAttribute ("id"));
		model.addAttribute("artist", session.getAttribute ("artist"));
		model.addAttribute("musician",session.getAttribute("musician"));
		return "result";
}
}
