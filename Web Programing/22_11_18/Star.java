package com.webp.p7;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Star {
	@Id public Integer no; // @Id가 붙은 의미는 primary key를 의미한다.
	public String name;
	public Integer count;
}