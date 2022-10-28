package com.webp.p5;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Sale {
	@Id public Integer number;
	public String id;
	public String name;
	@CreationTimestamp public LocalDateTime rdate;
	public Integer count;
	public Integer price;
}