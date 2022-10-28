package com.webp.p5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VanController1 {
	
	@Autowired
	private MemberRepository memRep;
	
	@Autowired
	private SaleRepository saleRep;
	
	@GetMapping("/member/list")
	public String memberList (Model mo) {
		List<Member> list = memRep.findAll();
		mo.addAttribute("list", list);
		return "memberList";	
	}
	
	@GetMapping("/sale/list")
	public String saleList (Model mo) {
		List<Sale> list2 = saleRep.findAll();
		mo.addAttribute("list2", list2);
		return "saleList";
	}
}