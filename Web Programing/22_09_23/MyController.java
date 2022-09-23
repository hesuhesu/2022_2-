package com.webp.p1;

import org.springframework.stereotype.Controller; // ctrl + shift + o 로 import 간단하게 가능.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class MyController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/ex01")  // 주소창에 ~/ex01이면 이란 뜻.
	public String ex01() {
		return "ex01";
	}
	@PostMapping("/ex01/answer")
	public String ex01Answer(String id, String pw, Model model) { // Model의 model 변수에 전해준다. model은 변경 가능.
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "ex01Answer";
	}
	
	
	
	@GetMapping("/wise")  // 임시 과제용1-1.
	public String wise() {
		return "wise";
	}
	@PostMapping("/wise/answer")  // 임시 과제용1-2.
	public String wiseAnswer(String wee, String meong, Model model) {
		model.addAttribute("wee", wee);
		model.addAttribute("meong", meong);
		return "wiseAnswer";
	}
	
	@GetMapping("/bread")  // 임시 과제용2-1.
	public String bread() {
		return "bread";
	}
	@PostMapping("/bread/answer")  // 임시 과제용2-2.
	public String breadAnswer(String like, int price, int num, Model model) {
		model.addAttribute("like", like);
		model.addAttribute("price", price);
		model.addAttribute("num", num);
		return "breadAnswer";
	}
	
	
	
}
