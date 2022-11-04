package com.webp.p5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VanController1 {
	
	@Autowired
	private MemberRepository memRep;
	
	@Autowired
	private SaleRepository saleRep;
	
	@Autowired
	private memoRepository memoRep;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/study")
	public String study() {
		return "study";
	}
	
	@GetMapping("/foods")
	public String foods() {
		return "foods";
	}
	
	@PostMapping("/foods/result")
	public String foodsResult(String gender, int age, String[] arr, int face, int grade, int omg, String comments, Model mo) {
		mo.addAttribute("gender", gender);
		mo.addAttribute("age", age);
		String temp = "";
		if(arr==null) {
			temp = "없음";
		}
		else {
			for(int i=0; i < arr.length; i++) {
				if (i == (arr.length - 1)) {
					temp += arr[i];
					break;
				}
				temp += arr[i] + ", ";	
			}
		}
		mo.addAttribute("foods", temp);
		mo.addAttribute("face", face);
		mo.addAttribute("grade", grade);
		mo.addAttribute("omg", omg);
		mo.addAttribute("comments", comments);
		return "foodsResult";
	}
	
	@GetMapping("/member/register")
	public String memberRegister() {
		return "memberRegister";
	}
	
	@GetMapping("/memo")
	public String memo() {
		return "memo";
	}
	
	
	@PostMapping("/member/insert")
	public String memberInsert(String id, String pw, String name, String phone, Model mo) {
		Member member = new Member();
		member.id = id;
		member.name = name;
		member.pw = pw;
		member.phone = phone;
		member.balance = 0;
		memRep.save(member);
		mo.addAttribute("msg", id + "님, 회원가입을 축하드립니다!!");
		return "popups2";
	}
	
	@PostMapping("/memo/insert")
	public String memoInsert(String title, String memo, Model mo) {
		memo mm = new memo();
		mm.title = title;
		mm.memo = memo;
		memoRep.save(mm);
		mo.addAttribute("msg", "잘 저장되었습니다 ~ ^.^");
		return "popups";
	}
	
	@GetMapping("/member/list")
	public String memberList (Model mo) {
		List<Member> list = memRep.findAll(); // 변수명.findAll()을 호출하면 MySQL에서 select * from member;을 한 것과 같다.
		mo.addAttribute("list", list);
		return "memberList";	
	}
	
	@GetMapping("/sale/list")
	public String saleList (Model mo) {
		List<Sale> list2 = saleRep.findAll();
		mo.addAttribute("list2", list2);
		return "saleList";
	}
	
	@GetMapping("/memo/list")
	public String memoList (Model mo) {
		List<memo> list3 = memoRep.findAll();
		mo.addAttribute("list3", list3);
		return "memoList";
	}
}
