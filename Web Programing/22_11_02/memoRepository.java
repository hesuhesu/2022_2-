package com.webp.p5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface memoRepository extends JpaRepository<memo, String>{
	
} // interface