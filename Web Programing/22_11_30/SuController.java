package com.webp.p7;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SuController {
	
	@Autowired
	private MemberRepository memRep;
	
	@Autowired
	private StarRepository starRep;
	
	@GetMapping("/login")
	public String login(Model mo) {
		int count = memRep.findCount();
		mo.addAttribute("count", count);
		return "login";
	}
	@GetMapping("/member/register")
	public String memberRegister() {
		return "memberRegister";
	}
	
	@GetMapping("/member/insert")
	public String memberInsert(String id, String pw, String phone, String name, Model mo) {
		Member m = new Member();
		m.name = name;
		m.id = id;
		m.pw = pw;
		m.phone = phone;
		m.balance = 0;
		if(memRep.existsById(id)) { // 이미 존재하는 아이디
			mo.addAttribute("msg", id+"는 이미 사용되고 있는 아이디입니다.");
			mo.addAttribute("url", "back");
		}
		else {
			memRep.save(m);
			mo.addAttribute("msg", id+"님, 반갑습니다!! (로그인 화면으로 이동)");
			mo.addAttribute("url", "/login");
		}
		return "popups";
	}
	
	@GetMapping("/login/check")
	public String loginCheck(HttpSession session, String id, Model mo) {
		if (memRep.existsById(id)) {
			session.setAttribute("id", id);
			return "redirect:/menu"; // 사용하지 않으면 주소창부터 꼬인다.
		}
		else {
			mo.addAttribute("msg", id + "는 미등록 아이디입니다. 확인 후 로그인 부탁드립니다.");
			mo.addAttribute("url", "/login");
			return "popups";
		}
	}
	
	@GetMapping("/menu")
	public String menu(HttpSession session, Model mo) {
		String id = (String)session.getAttribute("id");
		if (id == null) {
			mo.addAttribute("msg", "로그인 후 이용해주세요.");
			mo.addAttribute("url", "/login");
			return "popups";
		}
		else {
			mo.addAttribute("id", id);
			return "menu";
		}
	}
	
	@GetMapping("/member/list")
	public String memberList(HttpSession session, Model mo) {
		String id = (String)session.getAttribute("id");
		if (id == null) {
			mo.addAttribute("msg", "admin으로 이용해주세요.");
			mo.addAttribute("url", "/login");
			return "popups";
		}
		else if (id.equals("admin")){
			List<Member> list = memRep.findAll();
			mo.addAttribute("list", list);
			return "memberList";
		}
		else {
			mo.addAttribute("msg", id+"님 admin으로 이용해주세요.");
			mo.addAttribute("url", "/login");
			return "popups";
		}
	}
	
	@GetMapping("/myinfo")
	public String myinfo(HttpSession session, Model mo) {
		String id = (String)session.getAttribute("id");
		Member m = memRep.findById(id).get();
		mo.addAttribute("m", m);
		DecimalFormat df = new DecimalFormat("###,###");
		mo.addAttribute("won", df.format(m.balance)+" 원");
		return "myinfo";
	}
	
	@GetMapping("/myinfo/update")
	public String myinfoUpdate(HttpSession session, String pw, String name, String phone, String h_pw
			, String h_name, String h_phone, Model mo) {
		
		String id = (String)session.getAttribute("id");
		
		if(pw.equals(h_pw) && name.equals(h_name) && phone.equals(h_phone)) {
			mo.addAttribute("msg", "변경된 정보가 없습니다.");
			mo.addAttribute("url", "back");
		}
		else if(memRep.updateMyinfo(id,  pw, name, phone)==0) {
			mo.addAttribute("msg", "정보 변경 실패. 고객센터로 문의하세요.");
			mo.addAttribute("url", "back");
		}
		else {
			mo.addAttribute("msg", id+"님의 정보가 변경되었습니다.");
			mo.addAttribute("url", "/myinfo");
		}
		return "popups";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model mo) {
		mo.addAttribute("id", session.getAttribute("id"));
		session.invalidate();
		return "logout";
	}
	
	
	
	@GetMapping("/star/1")
	public String star1() {
		return "star1";
	}
	@GetMapping("/star/2")
	public String star2(String choice1, Model mo) {
		mo.addAttribute("choice1", choice1);
		starRep.updateCount_semi(choice1);
		return "star2";
	}
	@GetMapping("/star/3")
	public String star3(Model mo, String choice2, String choice1) {
		mo.addAttribute("choice1", choice1);
		mo.addAttribute("choice2", choice2);
		starRep.updateCount_semi(choice2);
		return "star3";
	}
	@GetMapping("/star/winner")
	public String starWinner(Model mo, String winner) {
		starRep.updateCount_final(winner);
		starRep.updateCount_semi_delete(winner);
		mo.addAttribute("winner", winner);
		return "starWinner";
	}
	@GetMapping("/star/list")
	public String starList(Model model) {
		List<Star> list4 = starRep.findAll();
		model.addAttribute("list4", list4);
		return "starList";
	}
	@GetMapping("/star/reset")
	public String starReset() {
		starRep.starReset1();
		starRep.starReset2();
		return "redirect:/star/list";
	}
	
	
	/*
	<세션을 사용할 때>
	@GetMapping("/star/1")
	public String star1() {
		return "star1";
	}
	@GetMapping("/star/2")
	public String star2(HttpSession session, String choice1) {
		session.setAttribute("choice1", choice1);
		starRep.updateCount_semi(choice1);
		return "star2";
	}
	@GetMapping("/star/3")
	public String star3(Model model, HttpSession session, String choice2) {
		session.setAttribute("choice2", choice2);
		starRep.updateCount_semi(choice2);
		model.addAttribute("choice1", session.getAttribute("choice1"));
		model.addAttribute("choice2", session.getAttribute("choice2"));
		return "star3";
	}
	@GetMapping("/star/winner")
	public String starWinner(HttpSession session, Model model, String winner) {
		starRep.updateCount_final(winner);
		starRep.updateCount_semi_delete(winner);
		model.addAttribute("winner", winner);
		return "starWinner";
	}
	@GetMapping("/star/list")
	public String starList(Model model) {
		List<Star> list4 = starRep.findAll();
		model.addAttribute("list4", list4);
		return "starList";
	}
	@GetMapping("/star/reset")
	public String starReset() {
		starRep.starReset1();
		starRep.starReset2();
		return "redirect:/star/list";
	}*/
	
	
	
}