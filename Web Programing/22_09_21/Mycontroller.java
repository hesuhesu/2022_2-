package com.webp.p1;

import org.springframework.stereotype.Controller; // ctrl + shift + o 로 import 간단하게 가능.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class MyController {
	
	@GetMapping("/ex01")  // 주소창에 ~/ex01이면 이란 뜻.
	
	public String ex01() {
		return "ex01";
	}
	
	@PostMapping("/ex01/answer")
	public String ex01Answer(String id, Model model) {
		model.addAttribute("id", id);
		return "ex01Answer";
	}
}
