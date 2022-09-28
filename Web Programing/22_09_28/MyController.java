package com.webp.p1;

import java.util.ArrayList;

import org.springframework.stereotype.Controller; // ctrl + shift + o 로 import 간단하게 가능.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ctrl+shift+o = 자동 import 구문 생성.

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
	
	
	@GetMapping("/ex02") 
	public String ex02() {
		return "ex02";
	}
	@PostMapping("/ex02/answer")
	public String ex02Answer(String name, String po, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("po", po);
		
		int salary = 0;
		switch(po) {
		case "사원" -> salary = 3500;
		case "대리" -> salary = 5000;
		case "팀장" -> salary = 7000;
		case "임원" -> salary = 9000;
		}
		model.addAttribute("salary", salary);
		return "ex02Answer";
	}
	
	
	@GetMapping("/ex03")
	public String ex03() {
	return "ex03";
	}
	@PostMapping("/ex03/answer")
	public String ex03Answer(String name, String color, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("color", color);
		return"ex03Answer";
	}
	
	
	@GetMapping("/ex04")
	public String ex04Answer(Model model) {
		ArrayList<String> list= new ArrayList<String>();
		list.add("고흐"); // 정수는 ArrayList<int>는 안되지만, integal로는 가능하다.
		list.add("james"); // vector<String> = 멀티 쓰레드, ArrayList<String> = 단일 쓰레드.
		list.add("dooli");
		list.add("bread");
		model.addAttribute("list",list);
		return"ex04";
	}
	
	
	@GetMapping("/q06")  // 22_09_28 과제 q06.
	public String q06() {
		return "q06";
	}
	@GetMapping("/q06/a")  // q06a.
	public String q06a() {
		return "q06a";
	}
	@PostMapping("/q06/aa")  // q06aa.
	public String q06aa(String st, String nd, Model model) {
		model.addAttribute("st", st);
		model.addAttribute("nd", nd);
		return "q06aa";
	}
	
	
	@GetMapping("/q06/b")  // q06b.
	public String q06b() {
		return "q06b";
	}
	@PostMapping("/q06/bb")  // q06bb.
	public String q06bb(String job, Model model) {
		model.addAttribute("job", job);
		return "q06bb";
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
