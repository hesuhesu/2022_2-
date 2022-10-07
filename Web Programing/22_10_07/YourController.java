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
	public String start() { return "ex1/start";
	}
	
	@PostMapping("/survey1")
	public String survey1(HttpSession session, String id) {
		session.setAttribute("id",id);
		return "ex1/survey1";
	}
	
	@PostMapping("/survey2")
	public String survey2(HttpSession session, String artist) {
		session.setAttribute("artist",artist);
		return "ex1/survey2";
	}
	
	@PostMapping("/thanks")
	public String thanks(HttpSession session, String musician) {
		session.setAttribute("musician",musician);
		return "ex1/thanks";
	}
	
	@GetMapping("/result")
	public String result(HttpSession session, Model model) {
		model.addAttribute("id", session.getAttribute ("id"));
		model.addAttribute("artist", session.getAttribute ("artist"));
		model.addAttribute("musician",session.getAttribute("musician"));
		return "ex1/result";
	}
	
	
	
	
	@GetMapping("/phone")
	public String phone() {
		return "ex1/phone";
	}
	@PostMapping("/phone/result")
	public String phoneThanks(HttpSession session, String model, String company, Model mo) {
		
		if(company.equals("삼성")||company.equals("애플")) {
			String msg = "삼성 z플립9을 선택해주셔서 감사합니다!!";
			mo.addAttribute("msg",msg);
			session.setAttribute("model",model);
			session.setAttribute("company",company);
		}
		else {
			String msg = "해당 회사의 제품은 매진되었습니다.";
			mo.addAttribute("msg",msg);
			
		}
		return "ex1/phoneThanks";
		
	}
	@GetMapping("/phone/session")
	public String phoneSession(HttpSession session, String model, String company, Model mo) {
		mo.addAttribute("model", session.getAttribute ("model"));
		mo.addAttribute("company", session.getAttribute ("company"));
		session.invalidate();
		return "ex1/phoneSession";
	}
}