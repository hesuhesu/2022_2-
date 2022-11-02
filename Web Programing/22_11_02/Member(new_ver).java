package com.webp.p5;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Member {
	@Id public String id; // @Id가 붙은 의미는 primary key를 의미한다.
	public String pw;
	public String name;
	public String phone;
	public Integer balance;
	@CreationTimestamp public LocalDateTime rdate;
}

// Member m = new Member(); 같은 식으로 회원 1명의 정보를 저장 가능하다.
// ArrayList<Member> list = new ArrayList<Member>(); 같은 식으로 배열을 만들어 여러명의 정보를 기입할 수 있다.
