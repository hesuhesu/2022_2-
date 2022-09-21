package com.webp.p1;  // cmd에 netstat -ano 를 입력하면 네트워크 현황을 알려준다.

//taskkill /f /pid ~ 는 강제 종료.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P1Application {

	public static void main(String[] args) {
		SpringApplication.run(P1Application.class, args);
	}

} 
