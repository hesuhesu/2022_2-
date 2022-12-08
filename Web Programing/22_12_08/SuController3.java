package com.webp.p7;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SuController3 {
	
	@Autowired
	private QARepository qaRep;
	
	@GetMapping("/qa/question")
	public String question(HttpSession session, Model mo) {
		String id = (String)session.getAttribute("id");
		if (id == null) id = "회원";
		List<QA> list = qaRep.findAll();
		
		mo.addAttribute("id", id);
		mo.addAttribute("list", list);
		return "question";
	}
	
	@PostMapping("/qa/question")
	public String insertQuestion(HttpSession session, String question, Model mo) {
		String id = (String)session.getAttribute("id");
		if (id == null) id = "회원";
		QA q = new QA();
		q.id = id;
		
		q.question = question;
		q.answer = "(답변준비중)";
		qaRep.save(q);
		mo.addAttribute("msg", id+"님의 질문이 등록되었습니다.");
		mo.addAttribute("url", "/qa/question");
		return "popups";
	}
	
	@GetMapping("/qa/answer")
	public String answer(HttpSession session, Model mo) {
		String id = (String)session.getAttribute("id");
		List<QA> list = qaRep.findAll();
		mo.addAttribute("id", id);
		mo.addAttribute("list", list);
		return "answer";
	}
	
	@PostMapping("/qa/answer")
	public String updateAnswer(int no, String answer, Model mo) {
		if(!qaRep.existsById(no)) {
			mo.addAttribute("msg", no+"번은 존재하지 않는 질문번호입니다. 확인 부탁드립니다.");
			mo.addAttribute("url", "back");
		}
		else {
			qaRep.updateAnswer(no, answer);
			mo.addAttribute("msg", "답변이 등록되었습니다.");
			mo.addAttribute("url", "/qa/answer");
		}
		return "popups";
	}
	
	
}