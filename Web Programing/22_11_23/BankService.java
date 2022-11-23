package com.webp.p7;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
	@Autowired
	private BankRepository bankRep;
	
	@Autowired
	private MemberRepository memRep;
	
	public List<Bank> myhistory(String id){
		return bankRep.findByIdOrderByTdateDesc(id);
	}
	public String findBalance(String id) {
		int balance = memRep.findBalance(id);
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(balance);
	}
}