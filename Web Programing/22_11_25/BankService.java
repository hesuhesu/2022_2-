package com.webp.p7;

import java.text.DecimalFormat;
import java.util.List;

import javax.transaction.Transactional;

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
	
	@Transactional
	public void dewi(String id, int money, int choice) {
		Bank b = new Bank();
		b.id = id;
		b.de = (choice == 1? money: 0);
		b.wi = (choice == -1? money: 0);
		b.tcode = 0;
		bankRep.save(b);
		memRep.updateBalance(id, choice*money);
	}
	
	@Transactional
	public boolean transfer(String id, int money, String tid) {
		if(!memRep.existsById(tid)) {
			return false;
		}
		Bank b = new Bank();
		b.id = id;
		b.de = 0;
		b.wi = money;
		b.tcode = 1;
		b.tid = tid;
		bankRep.save(b);
		memRep.updateBalance(id, -money);
		
		b = new Bank();
		b.id = tid;
		b.de = money;
		b.wi = 0;
		b.tcode = 2;
		b.tid = id;
		bankRep.save(b);
		memRep.updateBalance(tid, money);
		
		return true;
	}
	
	public List<Bank> bankList(){
		return bankRep.findAllOrderByIdTdateDesc();
	}
	public int findCount() {
		return memRep.findCount();
	}
	public String findSum() {
		int sum = memRep.findSum();
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(sum);
	}
}