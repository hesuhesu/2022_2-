package com.webp.p7;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class QA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer no;
	public String id;
	@CreationTimestamp 
	public LocalDateTime qdate;
	public String question;
	@CreationTimestamp
	public LocalDateTime adate;
	public String answer;
}