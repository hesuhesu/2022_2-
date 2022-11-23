package com.webp.p7;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuController2 {
	
	private BankService bankSvc;
	
	public SuController2(BankService bankSvc) {
		this.bankSvc = bankSvc;
	}
	
	@GetMapping("/myhistory")
	public String myhistory(HttpSession session, Model mo) {
		String id = (String)session.getAttribute("id");
		List<Bank> list = bankSvc.myhistory(id);
		String balance = bankSvc.findBalance(id);
		mo.addAttribute("id", id);
		mo.addAttribute("balance", balance);
		mo.addAttribute("list", list);
		return "myhistory";
	}
	
	@GetMapping("/deposit")
	public String deposit(HttpSession session, Model mo) {
		mo.addAttribute("id", session.getAttribute("id"));
		mo.addAttribute("word", "입");
		mo.addAttribute("color", "rgb(255,255,128)");
		mo.addAttribute("url", "/dewi?choice=1");
		return "dewi";
	}
	@GetMapping("/withdrawal")
	public String withdrawal(HttpSession session, Model mo) {
		mo.addAttribute("id", session.getAttribute("id"));
		mo.addAttribute("word", "출");
		mo.addAttribute("color", "#E0F8E7");
		mo.addAttribute("url", "/dewi?choice=-1");
		return "dewi";
	}
	
}