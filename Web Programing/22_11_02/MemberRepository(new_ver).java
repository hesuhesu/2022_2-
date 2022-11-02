package com.webp.p5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
	
} // interface

//MySQL에서 member 테이블과 동일하게 Member.java를 만들었지만, 아직 연결은 안됨
//이를 연결해주는게 JPA이고 소스로는 @Repository가 붙어있는 java 파일에 있는 MemberRepository 인터페이스이다.

/*
위의 MemberRepository.java에서 <> 꺽쇠 부분을 유의해야 하는데, 
<Member, String>이라는 의미는 JPA가 member 테이블과 연결되있다는 것과 그 테이블의 primary key가 문자열이라는걸 의미한다.
*/
